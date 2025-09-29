import React, { useEffect, useState } from "react";
import "components2/counter.css";
function Counter(props) {
  //상태관리 : useState Hook이용
  const [count, setCount] = useState(0); //count=0
  // const incrementHandler = () => {
  //   setCount(count + 1); //set은 비동기이다.
  // };
  // const decrementHandler = () => {
  //   setCount(count - 1);
  // };
  // const resetHandler = () => {
  //   setCount(0);
  // };

  const clickHandler = (e) => {
    const text = e.target.innerText.trim();
    console.log("*" + text + "*");
    if (text === "+") {
      setCount(count + 1);
    } else if (text === "-") {
      setCount(count - 1);
    } else {
      setCount(0);
    }
  };

  //count가 변경되었는지 확인하고자한다. useEffect()훅을 이용,
  //의존배열에 변수를 주면 그 변수가 변경되었을때만 수행한다.
  useEffect(() => {
    console.log(count);
  }, [count]);

  return (
    <div className="counter-container">
      <h2 className="counter-display">{count}</h2>
      <div className="counter-buttons">
        <button className="counter-button" onClick={clickHandler}>
          -
        </button>
        <button className="counter-button reset" onClick={clickHandler}>
          Reset
        </button>
        <button className="counter-button" onClick={clickHandler}>
          +
        </button>
      </div>
    </div>
  );
}

export default Counter;
