import React, { useEffect, useMemo, useState } from "react";

/*
1.자식의 상태값이 변경되면 자식만 Re-rendering
2.부모의 상태가 변경되면 자식도 Re-rendering
(이를 해결하려면 자식component에 Memoization을 이용)
React.memo(자식컴포넌트)
*/

function Comp2Child({ clickHander2 }) {
  const [count, setCount] = useState(0);
  const [count2, setCount2] = useState(100);

  useEffect(() => {
    console.log("Comp2Child.....자식Rendering");
  });
  const clickHander = () => {
    setCount(count + 1);
  };
  const anotherClickHandler = () => {
    setCount2(count2 + 1);
  };

  const changeHander2 = (e) => {
    clickHander2(e.target.value);
  };

  //오래걸리는 연산작업
  const expensiveCaculation = (num) => {
    console.log("오래걸리는 연산작업중....");
    for (let i = 1; i <= 1000; i++) {
      num += i;
    }
    return num;
  };
  //값을 Memoization, 의존배열이 변경된 경우만 함수를 수행하도록 한다.
  //useMemo(함수, [의존배열])
  const result = useMemo(() => expensiveCaculation(count), [count]);

  return (
    <div style={{ border: "1px solid green" }}>
      <h1>자식Component입니다. count:{count}</h1>
      <p>오래걸려서 계산한 결과 : {result}</p>
      <button onClick={clickHander}>클릭(자식)</button>
      <button onClick={anotherClickHandler}>클릭(자식 count2)</button>
      <input onChange={changeHander2} />
    </div>
  );
}

export default React.memo(Comp2Child);
