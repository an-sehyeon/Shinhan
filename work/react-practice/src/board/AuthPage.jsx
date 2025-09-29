import "board/AuthPage.css";
import { useAuth } from "board/AuthContext";
import { useEffect, useState } from "react";
import ApiService from "services/ApiService";
import DaumPostcode from "react-daum-postcode";

const initMember = {
  mid: "",
  mpassword: "",
  confirmPassword: "",
  mname: "",
  mrole: "USER",
  address: "",
  addressDetail: "",
};
function AuthPage() {
  const [isLoginMode, setIsLoginMode] = useState(true);
  const [form, setForm] = useState(initMember);
  const [error, setError] = useState("");
  const { login } = useAuth();
  const [isPostcodeOpen, setIsPostcodeOpen] = useState(false);
  useEffect(() => {
    if (isPostcodeOpen) {
      document.body.style.overflow = "hidden";
    } else {
      document.body.style.overflow = "unset";
    }
    return () => {
      document.body.style.overflow = "unset";
    };
  }, [isPostcodeOpen]);

  const handlePostcodeComplete = (data) => {
    setForm((prev) => ({ ...prev, address: data.address }));
    setIsPostcodeOpen(false);
  };
  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };
  const toggleMode = () => {
    setIsLoginMode((prev) => !prev);
    setForm(initMember);
    setError("");
  };
  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    if (!isLoginMode) {
      if (form.mpassword !== form.confirmPassword) {
        setError("비밀번호가 일치하지 않습니다.");
        return;
      }
      if (!form.mname) {
        setError("이름을 입력해주세요.");
        return;
      }
      if (!form.address || !form.addressDetail) {
        setError("주소와 상세주소를 모두 입력해주세요.");
        return;
      }
    }
    if (isLoginMode) {
      await login(form.mid, form.mpassword);
    } else {
      try {
        const { mid, mpassword, mname, mrole, address, addressDetail } = form;
        await ApiService.post("/signup", {
          mid,
          mpassword,
          mname,
          mrole,
          address,
          addressDetail,
        });
        alert("회원가입 성공! 이제 로그인해주세요.");
        toggleMode();
      } catch (err) {
        setError(err.response?.data || "회원가입에 실패했습니다.");
      }
    }
  };
  return (
    <div className="auth-page-container">
      <div className="auth-header">
        <h2>{isLoginMode ? "로그인" : "회원가입"}</h2>
      </div>

      <form className="auth-form" onSubmit={handleSubmit}>
        <div className="form-field">
          <label htmlFor="mid">아이디</label>
          <input
            id="mid"
            name="mid"
            value={form.mid}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-field">
          <label htmlFor="mpassword">비밀번호</label>
          <input
            id="mpassword"
            name="mpassword"
            type="password"
            value={form.mpassword}
            onChange={handleChange}
            required
          />
        </div>

        {!isLoginMode && (
          <>
            <div className="form-field">
              <label htmlFor="confirmPassword">비밀번호 확인</label>
              <input
                id="confirmPassword"
                name="confirmPassword"
                type="password"
                value={form.confirmPassword}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-field">
              <label htmlFor="mname">이름</label>
              <input
                id="mname"
                name="mname"
                type="text"
                value={form.mname}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-field2">
              <label>
                ADMIN
                <input
                  type="radio"
                  name="mrole"
                  value="ADMIN"
                  checked={form.mrole === "ADMIN"}
                  onChange={handleChange}
                />
              </label>
              <label>
                MANAGER
                <input
                  type="radio"
                  name="mrole"
                  value="MANAGER"
                  checked={form.mrole === "MANAGER"}
                  onChange={handleChange}
                />
              </label>
              <label>
                USER
                <input
                  type="radio"
                  name="mrole"
                  value="USER"
                  checked={form.mrole === "USER"}
                  onChange={handleChange}
                />
              </label>
            </div>
            <div className="form-field">
              <label htmlFor="address">주소</label>
              <div className="address-field">
                <input
                  id="address"
                  name="address"
                  type="text"
                  value={form.address}
                  readOnly
                  placeholder="우편번호 검색"
                  required
                />
                <button type="button" onClick={() => setIsPostcodeOpen(true)}>
                  검색
                </button>
              </div>
              <input
                className="detail-address-input"
                id="addressDetail"
                name="addressDetail"
                type="text"
                value={form.addressDetail}
                onChange={handleChange}
                placeholder="상세주소를 입력해주세요."
                required
              />
            </div>
          </>
        )}

        {error && <p className="error-message">{error}</p>}
        <button type="submit" className="submit-button">
          {isLoginMode ? "로그인하기" : "가입하기"}
        </button>
      </form>

      <div className="toggle-button-container">
        <button type="button" onClick={toggleMode} className="toggle-button">
          {isLoginMode ? "계정이 없으신가요?" : "이미 계정이 있으신가요?"}
        </button>
      </div>

      {isPostcodeOpen && (
        <div className="postcode-modal-overlay">
          <div className="postcode-modal-content">
            <button
              className="postcode-close-button"
              onClick={() => setIsPostcodeOpen(false)}
            >
              &times;
            </button>
            <DaumPostcode onComplete={handlePostcodeComplete} />
          </div>
        </div>
      )}
    </div>
  );
}

export default AuthPage;
