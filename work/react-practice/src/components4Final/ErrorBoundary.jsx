import { Component } from "react";
import "./ErrorBoundary.css";

//ErrorBoundary는 클래스형 컴포넌트로만 작성할 수 있다
//자바스크립트 오류는 앱 전체를 중단시킴. ErrorBoundary는 이러한 오류가 앱 전체로 전파되는 것을 막고, 지정된 대체 UI를 보여주는 역할을 함

class ErrorBoundary extends Component {
  state = {
    hasError: false,
    error: null,
    errorInfo: null,
  };
  //하위 컴포넌트에서 에러발생시 호출됨
  static getDerivedStateFromError(error) {
    //다른 렌더링에서 콜백 UI를 표시하기 위해 state를 update
    return { hasError: true };
  }
  //하위 컴포넌트 트리에서 오류가 발생했을 때 호출되는 생명주기 메소드
  //이곳에서 오류 정보를 state에 저장하고, 로그를 남기는 등의 작업을 수행할 수 있음
  componentDidCatch(error, errorInfo) {
    this.setState({
      error: error,
      errorInfo: errorInfo,
    });
    console.error("Uncaught error:", error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      return (
        <div className="error-boundary-container">
          <div className="error-card">
            <h2 className="error-title">앗, 에러가 발생했습니다!</h2>
            <p>
              예상치 못한 문제가 발생했습니다. <br />
              페이지를 새로고침하거나, 문제가 지속될 경우 관리자에게
              문의해주세요.
            </p>
            <button
              className="reload-button"
              onClick={() => window.location.reload()}
            >
              페이지 새로고침
            </button>
            <details className="error-details">
              <summary>에러 상세 정보 보기</summary>
              {this.state.error && this.state.error.toString()}
              <br />
              <br />
              {this.state.errorInfo && this.state.errorInfo.componentStack}
            </details>
          </div>
        </div>
      );
    }
    // 에러가 없으면 자식 컴포넌트를 그대로 렌더링
    return this.props.children;
  }
}

export default ErrorBoundary;
