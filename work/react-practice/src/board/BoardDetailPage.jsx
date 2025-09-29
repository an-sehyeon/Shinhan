import { useAuth } from "board/AuthContext";
import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import ApiService from "services/ApiService";
import { Helmet } from "react-helmet";

function BoardDetailPage() {
  const { bno } = useParams();
  const { user } = useAuth();
  const [board, setBoard] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    ApiService.get(`/board/detail.do/${bno}`)
      .then((response) => setBoard(response.data))
      .catch((error) => console.error("게시글 로딩 실패", error));
  }, [bno]);

  const formatDate = (dateString) => {
    if (!dateString) return " - ";
    const date = new Date(dateString);
    return date.toLocaleString("ko-KR");
  };

  if (!board) return <div>로딩 중...</div>;

  const isAuthor = user && user.mid === board.writer;

  return (
    <div>
      <Helmet>
        <title>{`${board.title} - React 게시판`}</title>
      </Helmet>
      <h3>📄 {board.title}</h3>
      <div className="detail-info-grid">
        <div className="detail-info-item">
          <span>작성자</span> {board.writer}
        </div>
        <div className="detail-info-item">
          <span>조회수</span> {board.viewCount}
        </div>
        <div className="detail-info-item">
          <span>작성일</span> {formatDate(board.regDate)}
        </div>
        <div className="detail-info-item">
          <span>수정일</span> {formatDate(board.modDate)}
        </div>
      </div>
      <hr />
      <div className="detail-content">{board.content}</div>
      <div className="button-group">
        <button onClick={() => navigate("/board/list")} className="list-button">
          목록
        </button>
        {isAuthor && (
          <>
            <Link
              to={`/board/update/${bno}`}
              state={{ board: board }}
              className="edit-button"
            >
              수정
            </Link>
            <Link
              to={`/board/delete/${bno}`}
              state={{ bno: bno }}
              className="delete-button"
            >
              삭제
            </Link>
          </>
        )}
      </div>
    </div>
  );
}

export default BoardDetailPage;
