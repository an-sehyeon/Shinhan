import AuthPage from "board/AuthPage";
import BoardDeletePage from "board/BoardDeletePage";
import BoardDetailPage from "board/BoardDetailPage";
import BoardLayout from "board/BoardLayout";
import BoardListPage from "board/BoardListPage";
import BoardUpdatePage from "board/BoardUpdatePage";
import BoardWritePage from "board/BoardWritePage";
import HomePage from "board/HomePage";
import NotFoundPage from "board/NotFoundPage";
import ProtectedRoute from "board/ProtectedRoute";
import { useAuth } from "board/AuthContext";
import { Link, Route, Routes } from "react-router-dom";
import "./App.css";

function App() {
  const { isLoggedIn, user, logout } = useAuth();

  return (
    <div className="app-container">
      <header className="main-header">
        <Link to="/" className="nav-link logo">
          Home
        </Link>
        <nav className="nav-links">
          <Link to="/board/list" className="nav-link">
            게시판
          </Link>
          {isLoggedIn ? (
            <>
              <span className="welcome-msg">{user.mid}님 환영합니다.</span>
              <button onClick={logout} className="nav-link logout-button">
                로그아웃
              </button>
            </>
          ) : (
            <Link to="/auth" className="nav-link login-button">
              로그인
            </Link>
          )}
        </nav>
      </header>

      <main className="main-content">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/board" element={<BoardLayout />}>
            <Route path="list" element={<BoardListPage />} />
            <Route
              path="write"
              element={
                <ProtectedRoute>
                  <BoardWritePage />
                </ProtectedRoute>
              }
            />
            <Route path="detail/:bno" element={<BoardDetailPage />} />
            <Route
              path="update/:bno"
              element={
                <ProtectedRoute>
                  <BoardUpdatePage />
                </ProtectedRoute>
              }
            />
            <Route
              path="delete/:bno"
              element={
                <ProtectedRoute>
                  <BoardDeletePage />
                </ProtectedRoute>
              }
            />
          </Route>
          <Route path="/auth" element={<AuthPage />} />
          <Route path="*" element={<NotFoundPage />} />
        </Routes>
      </main>
    </div>
  );
}

export default App;
