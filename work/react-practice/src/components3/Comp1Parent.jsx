import React, { useCallback, useEffect, useState } from "react";
import Comp2Child from "./Comp2Child";

function Comp1Parent(props) {
  const [message, setMessage] = useState("초기값");
  useEffect(() => {
    console.log("Comp1Parent.....부모Rendering");
  });
  const changeHandler = (e) => {
    setMessage(e.target.value);
  };
  //부모가 이벤트를 만들어 자식에게 전달
  //부모가 리렌더링될때 함수정의를 다시한다.
  //변경된 함수가 자식에게 전달된다.
  //자식 Re-rendering된다.
  //이를 해결하려면 함수를 Memoization한다.
  //useCallback(함수, [의존배열])
  const clickHander2 = useCallback((msg) => {
    setMessage(msg);
  }, []);
  return (
    <div style={{ border: "1px solid blue" }}>
      <h1>부모Component입니다. message:{message}</h1>
      <input onChange={changeHandler} />
      <Comp2Child clickHander2={clickHander2}></Comp2Child>
    </div>
  );
}

export default Comp1Parent;
