//Component는 반드시 대문자시작이름, 확장자는 js. jsx, Tag로 사용가능 ,반복사용가능
import React from "react";
import { useState } from "react";

function f1() {
  alert("f1함수이다.");
}

function ChildComponent1({ money = 3000, house = "50평", children }) {
  console.log("자식 rendering");

  //1.속성전달
  //const { money = 3000, house = "50평" } = props;
  //2.상태관리 ...값이 변경되면 React가 UI를 Rending한다.
  const [score, setScore] = useState(0); //초기값을 score에 setting  score=0

  //자식이 상태값이 변경되면 자식을 rendering
  //부모이 상태값이 변경되면 자식도 rendering....관련이 없다면 Component를 memo한다.rendering막기
  const scoreChangeHandler = (event) => {
    setScore(event.target.value);
  };
  return (
    <div>
      <h2>자식 Component : {score}</h2>
      <input onChange={scoreChangeHandler} />
      <p>부모에게 받은 속성 : {children}</p>
      <p>부모에게 받은 속성 : {money}</p>
      <p>부모에게 받은 속성 : {house}</p>
    </div>
  );
}

export default React.memo(ChildComponent1);
