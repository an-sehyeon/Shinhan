import React, { useEffect, useReducer } from "react";
import "components2/counter.css";
import { counterReducer } from "components3/counterReducer";

function CounterReducerTest(props) {
  //상태관리 : useState Hook이용......컨포넌트내에서 상태관리를 한다. 로직이 복잡해지면, 관리할 변수가 많아지면 컨포넌트 유지보수 어렵다
  //1.useState()이용
  //const [count, setCount] = useState(0); //count=0
  //2.useReducer이용
  const [count, dispatch] = useReducer(counterReducer, 0);

  // const incrementHandler = () => {
  //   dispatch({type:"INCREMENT"});
  // };
  // const decrementHandler = () => {
  //   dispatch({type:"DECREMENT"});
  // };
  // const resetHandler = () => {
  //  dispatch({type:"RESET"});
  // };

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
      <p>리듀서연습:</p>
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

export default CounterReducerTest;
