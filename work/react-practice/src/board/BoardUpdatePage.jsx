import { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import ApiService from "services/ApiService";

function BoardUpdatePage() {
  const location = useLocation();
  const navigate = useNavigate();

  // location.state에서 넘어온 board 객체로 초기 상태 설정
  const [board, setBoard] = useState(location.state.board);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setBoard({ ...board, [name]: value });
  };

  const handleUpdate = () => {
    // API 요청 시에는 bno, title, content만 보냄
    ApiService.put("/board/update.do", {
      bno: board.bno,
      title: board.title,
      content: board.content,
      //writer: board.writer,
    })
      .then(() => {
        alert(`${board.bno}번 게시글이 수정되었습니다.`);
        navigate(`/board/detail/${board.bno}`);
      })
      .catch((error) => {
        console.error("게시글 수정 실패:", error);
        alert("게시글 수정에 실패했습니다. 권한을 확인해주세요.");
      });
  };

  return (
    <div>
      <h3>✏️ {board.bno}번 글 수정</h3>
      <input
        name="title"
        className="form-input"
        value={board.title}
        onChange={handleChange}
      />
      <textarea
        name="content"
        className="form-textarea"
        value={board.content}
        onChange={handleChange}
      ></textarea>
      <input
        name="writer"
        className="form-input"
        value={board.writer}
        readOnly
      />
      <button onClick={handleUpdate} className="submit-button">
        수정 완료
      </button>
    </div>
  );
}
export default BoardUpdatePage;
