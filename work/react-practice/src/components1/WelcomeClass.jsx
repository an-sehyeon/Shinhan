import React, { Component } from "react";

class WelcomeClass extends Component {
  render() {
    console.log("class component Redering....");
    return (
      <div>
        <h1>Hello~ {this.props.name} (함수형 컴포넌트 )</h1>
      </div>
    );
  }
}

export default WelcomeClass;
