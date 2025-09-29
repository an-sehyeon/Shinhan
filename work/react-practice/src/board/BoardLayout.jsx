import { Link, Outlet } from 'react-router-dom';

function BoardLayout() {
    return (
    <div className="board-layout">
        <aside className="board-sidebar">
            <h2>게시판 메뉴</h2>
            <Link to="/board/list">글 목록</Link>
            <Link to="/board/write">글쓰기</Link> 
        </aside>
        <section className="board-content"> 
            {/* <Outlet />을 통해 중첩된 자식 페이지들이 렌더링될 위치를 지정 */}
            <Outlet />
        </section>
    </div>
  );
}

export default BoardLayout;