import { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import ApiService from "services/ApiService";

function BoardDeletePage(props) {
  const location = useLocation();
  const navigate = useNavigate();
  const { bno } = location.state;

  useEffect(() => {
    if (window.confirm(`${bno}번 게시글을 정말 삭제하시겠습니까?`)) {
      ApiService.delete(`/board/delete.do/${bno}`).then(() => {
        alert(`${bno}번 게시글이 삭제되었습니다.`);
        navigate("/board/list");
      });
    } else {
      navigate(`/board/detail/${bno}`);
    }
  }, [bno, navigate]);

  return <div>삭제 처리 중...</div>;
}

export default BoardDeletePage;
