import React from "react";

function RenderingTest({ message }) {
  const userName = "짱구";
  const score = 100;
  const score2 = false;
  const student = { name: "짱구2", age: 30 };

  //rendering되지않음
  const data1 = false;
  const data2 = null;
  const data3 = undefined;
  // && : 모두 참이면 참이다. 앞이거짓이면 뒷부분 안함
  // || : 하나라도 참이면 참이다, 앞이참이면 뒷부분안함
  return (
    <div>
      <h1>{message}</h1>
      <h2>이름은 {userName}</h2>
      <h2>점수는 {score}</h2>
      <h2>
        student이름은 {student.name} 나이는 {student.age}
        객체의 속성에 접근하여 출력한다. 객체출력은 하지못함 (오류)
      </h2>
      <h2>false인경우 보이지않음: {data1}</h2>
      <h2>null인경우 보이지않음: {data2}</h2>
      <h2>undefined인경우 보이지않음: {data3}</h2>
      <h2>undefined인경우 (data가 없음): {data3 || "data가 없음"}</h2>
      <h2>값이있는경우 수행.없으면 다음뒷부분(100): {score || 200}</h2>
      <h2>값이있으면 다음뒷부분(200): {score && 200}</h2>
      <h2>값이있으면 다음뒷부분(없음): {score2 && 200}</h2>
    </div>
  );
}

export default RenderingTest;
