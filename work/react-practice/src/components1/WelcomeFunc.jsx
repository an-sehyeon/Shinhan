import React from "react";

function WelcomeFunc(arg) {
  console.log("WelcomeFunc  rendering....." + arg);
  return (
    <div>
      <h1>Hello,{arg.name} (함수형 컴포넌트)</h1>
    </div>
  );
}

export default WelcomeFunc;
