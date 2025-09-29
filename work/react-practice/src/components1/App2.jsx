import React from "react";
import WelcomeFunc from "components1/WelcomeFunc";
import WelcomeClass from "components1/WelcomeClass";

function App2(props) {
  return (
    <div>
      <WelcomeFunc name="func1"></WelcomeFunc>
      <WelcomeFunc name="func2"></WelcomeFunc>
      {/* <welcomeFunc2 name="funct3소문자 불가"></welcomeFunc2> */}
      <WelcomeClass name="class1"></WelcomeClass>
      <WelcomeClass name="class2"></WelcomeClass>
    </div>
  );
}

export default App2;
