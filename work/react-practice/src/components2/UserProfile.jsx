import React, { useState } from "react";
import "components2/userProfile.css";
function UserProfile(props) {
  const [user, setUser] = useState({ name: "아무개", age: 30 });
  const [favorites, setFavorites] = useState(["게임", "영화보기"]);
  const [newfavorite, setNewfavorite] = useState("");
  //   const nameChangehandler = (e) => {
  //     setUser({ ...user, name: e.target.value });
  //   };
  //   const ageChangeHandler = (e) => {
  //     setUser({ ...user, age: e.target.value });
  //   };
  const changeHandler = (e) => {
    //기존속성은 : e.target.속성
    //추가속성은 : e.target.getAttribute("colname")
    const colname = e.target.getAttribute("colname");
    setUser({ ...user, [colname]: e.target.value });
  };
  const changeFavoriteHandler = (e) => {
    console.log(e.target.value);
    setNewfavorite(e.target.value);
  };
  const addHandler = () => {
    setFavorites([...favorites, newfavorite]);
    setNewfavorite("");
  };

  return (
    <div className="profile-card">
      <div className="profile-header">
        <h2>프로필 카드</h2>
      </div>
      <div className="profile-body">
        <div className="input-group">
          <label htmlFor="name-input">이름:</label>
          <input
            id="name-input"
            colname="name"
            type="text"
            onChange={changeHandler}
          />
        </div>
        <div className="input-group">
          <label htmlFor="age-input">나이:</label>
          <input
            id="age-input"
            colname="age"
            type="number"
            onChange={changeHandler}
          />
        </div>
        <hr />
        {/* '좋아하는 것' 추가 섹션 */}
        <div className="input-group">
          <label htmlFor="favorite-input">좋아하는 것:</label>
          <div className="add-item-container">
            <input
              id="favorite-input"
              placeholder="예: 코딩"
              onChange={changeFavoriteHandler}
              value={newfavorite}
            />
            <button className="add-button" onClick={addHandler}>
              추가
            </button>
          </div>
        </div>
        {/* '좋아하는 것' 목록 표시 */}
        <ul className="favorites-list">
          {favorites.map((item, index) => (
            <li className="favorite-item" key={index}>
              <p>{item}</p>
            </li>
          ))}
        </ul>
      </div>
      <div className="profile-footer">
        <h4>
          {" "}
          {user.name} 님의 나이는 {user.age} 살입니다.
        </h4>
      </div>
    </div>
  );
}

export default UserProfile;
