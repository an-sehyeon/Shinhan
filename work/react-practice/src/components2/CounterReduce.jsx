import React, { useEffect, useReducer, useState } from "react";
import "components2/counter.css";

function countReducer(state, action) {
  switch (action.type) {
    case "INCREMENT":
      return state + 1;
    case "DECREMENT":
      return state - 1;
    case "RESET":
      return 0;
    default:
      return state;
  }
}

function CounterReduce(props) {
  const [count, dispatch] = useReducer(countReducer, 0);
  const clickHandler = (e) => {
    const text = e.target.innerText.trim();
    console.log("*" + text + "*");
    if (text === "+") {
      dispatch({ type: "INCREMENT" });
    } else if (text === "-") {
      dispatch({ type: "DECREMENT" });
    } else {
      dispatch({ type: "RESET" });
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

export default CounterReduce;
