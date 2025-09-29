import { Component } from "react";
import "components2/LifeCycleExample.css";

// 자식 컴포넌트
class LifeCycleChild extends Component {
  // 컴포넌트가 생성될 때 호출됩니다.
  constructor(props) {
    super(props);
    console.log("👶 자식 constructor");
    // state는 여기에서 초기화할 수 있습니다.
  }

  // 컴포넌트가 DOM에 마운트된 직후에 호출됩니다.
  componentDidMount() {
    console.log("🌱 자식 componentDidMount");
  }

  // props나 state가 변경되어 리렌더링되기 직전에 호출됩니다.
  shouldComponentUpdate(nextProps, nextState) {
    console.log("🤔 자식 shouldComponentUpdate");
    return true; // true를 반환해야 리렌더링이 진행됩니다.
  }

  // 리렌더링이 완료된 직후에 호출됩니다.
  componentDidUpdate(prevProps, prevState) {
    console.log("🔄 자식 componentDidUpdate");
  }

  // 컴포넌트가 DOM에서 언마운트되기 직전에 호출됩니다.
  componentWillUnmount() {
    console.log("👋 자식 componentWillUnmount");
  }

  // UI를 렌더링합니다.
  render() {
    console.log("🎨 자식 render");
    return (
      <div className="child-box">
        <h4>자식 컴포넌트</h4>
        <p>부모에게 받은 title: {this.props.title}</p>
      </div>
    );
  }
}

export default LifeCycleChild;
