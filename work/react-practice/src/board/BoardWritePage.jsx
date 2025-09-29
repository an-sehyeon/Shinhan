import { useAuth } from "board/AuthContext";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import ApiService from "services/ApiService";

function BoardWritePage() {
  const navigate = useNavigate();
  const { user } = useAuth();
  const [board, setBoard] = useState({ title: "", content: "" });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setBoard({ ...board, [name]: value });
  };

  const handleSubmit = () => {
    ApiService.post("/board/insert.do", {
      title: board.title,
      content: board.content,
    })
      .then(() => {
        alert("게시글이 등록되었습니다.");
        navigate("/board/list");
      })
      .catch((error) => {
        console.error("게시글 등록 실패:", error);
        alert("게시글 등록에 실패했습니다.");
      });
  };

  return (
    <div>
      <h3>✍️ 새 글 작성</h3>
      <input
        name="title"
        className="form-input"
        placeholder="제목"
        onChange={handleChange}
      />
      <input name="writer" className="form-input" value={user.mid} readOnly />
      <textarea
        name="content"
        className="form-textarea"
        placeholder="내용"
        onChange={handleChange}
      ></textarea>
      <button onClick={handleSubmit} className="submit-button">
        등록하기
      </button>
    </div>
  );
}
export default BoardWritePage;
