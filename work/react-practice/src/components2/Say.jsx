import React, { Component } from "react";
import "components2/say.css";

//class형태의 컴포넌트
class Say extends Component {
  //상태관리
  //   constructor(){
  //     super();
  //     //생성자에서 코드를 투가하는 경우 반드시 부모호출문장을 먼저 사용한다.
  //     this.state = {
  //     message: "버튼을 눌러주세요",
  //     color: "black",
  //        };
  //   }
  state = {
    message: "버튼을 눌러주세요",
    color: "purple",
  };
  changeMessageHandler = (e) => {
    this.setState({ message: e.target.innerText });
  };
  changeColorHandler = (e) => {
    var colorName = e.target.innerText;
    if (colorName === "빨간색") {
      colorName = "red";
    } else if (colorName === "초록색") {
      colorName = "green";
    } else if (colorName === "파란색") {
      colorName = "blue";
    }
    this.setState({ color: colorName }, () => {
      //setState()는 비동기함수임. set후 해야할 코드는 callback한수이용한다
      console.log(this.state);
    });
  };
  render() {
    const { message, color } = this.state;
    return (
      <div className="say-container">
        {/* 입장/퇴장 버튼 그룹 */}
        <div className="button-group">
          <button
            style={{ color: color }}
            className="say-button"
            onClick={this.changeMessageHandler}
          >
            입장
          </button>
          <button
            style={{ color: this.state.color }}
            className="say-button"
            onClick={this.changeMessageHandler}
          >
            퇴장
          </button>
        </div>
        <hr className="divider" />
        {/* 색상 변경 버튼 그룹 */}
        <div className="button-group">
          <button
            className="say-button color-red"
            onClick={this.changeColorHandler}
          >
            빨간색
          </button>
          <button
            className="say-button color-green"
            onClick={this.changeColorHandler}
          >
            초록색
          </button>
          <button
            className="say-button color-blue"
            onClick={this.changeColorHandler}
          >
            파란색
          </button>
        </div>
        {/* 메시지 표시 영역 */}
        <h1 style={{ color: color }} className="message-display">
          {this.state.message}
        </h1>
        <h1 className="message-display">{message}</h1>

        <p className="color-status">현재색상 : {color} </p>
      </div>
    );
  }
}

export default Say;
