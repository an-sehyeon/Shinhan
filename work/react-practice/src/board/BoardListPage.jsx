import "board/BoardListPage.css";
import { useEffect, useState } from "react";
import { Link, useSearchParams } from "react-router-dom";
import ApiService from "services/ApiService";

function BoardListPage() {
  const [boardList, setBoardList] = useState([]);
  const [loading, setLoading] = useState(true);

  const [searchParams, setSearchParams] = useSearchParams();
  // URL에서 'sort' 쿼리 파라미터 값을 가져온다. (없으면 'latest')
  const sortOrder = searchParams.get("sort") || "latest";

  useEffect(() => {
    setLoading(true);
    // API 호출 시 정렬 파라미터를 함께 전송
    ApiService.get(`/board/listAll.do?sort=${sortOrder}`)
      .then((response) => {
        setBoardList(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("게시글 목록을 불러오는 데 실패했습니다:", error);
        setLoading(false);
      });
  }, [sortOrder]);

  useEffect(() => {
    //console.log(boardList);
  },[boardList]);


  // 쿼리 스트링을 변경하는 함수
  const handleSort = (order) => {
    setSearchParams({ sort: order });
  };

  // 날짜 형식을 "YYYY년 MM월 DD일 HH:mm"으로 변환하는 헬퍼 함수
  const formatDate = (dateString) => {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, "0");
    const day = String(date.getDate()).padStart(2, "0");
    const hours = String(date.getHours()).padStart(2, "0");
    const minutes = String(date.getMinutes()).padStart(2, "0");
    return `${year}년 ${month}월 ${day}일 ${hours}:${minutes}`;
  };

  if (loading) return <div>로딩 중...</div>;

  return (
    <div>
      <div className="list-header">
        <h3>📋 게시글 목록</h3>
        {/* 정렬 버튼 그룹 */}
        <div className="sort-buttons">
          <button
            onClick={() => handleSort("latest")}
            className={`sort-button ${sortOrder === "latest" ? "active" : ""}`}
          >
            최신순
          </button>
          <button
            onClick={() => handleSort("popular")}
            className={`sort-button ${sortOrder === "popular" ? "active" : ""}`}
          >
            인기순
          </button>
        </div>
      </div>
      <table className="board-table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>수정일</th>
          </tr>
        </thead>
        <tbody>
          {boardList.map((board, index) => (
            <tr key={board.bno}>
              <td>
                <Link to={`/board/detail/${board.bno}`}>{index + 1}</Link>
              </td>
              <td>
                <Link to={`/board/detail/${board.bno}`}>{board.title}</Link>
                <span>댓글건수{board.replyCount}</span>
              </td>
              <td>{board.writer}</td>
              <td>{formatDate(board.modDate)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default BoardListPage;
