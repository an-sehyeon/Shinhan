import { useRef, useState } from "react";
import "components2/VarCompare.css";

function VarCompare() {
  const [count, setCount] = useState(0);
  const countRef = useRef(0);
  let countLet = 0;

  // 리렌더링을 유발하기 위한 state
  const [render, setRender] = useState(false);

  const increaseState = () => setCount(count + 1);

  const increaseRef = () => {
    countRef.current += 1;
    console.log(`Ref 값 (렌더링 안됨): ${countRef.current}`);
  };

  const increaseLet = () => {
    countLet += 1;
    console.log(`Let 값 (렌더링 안됨): ${countLet}`);
  };

  return (
    <div className="var-compare-container">
      <div className="value-display">
        <h2>
          State: <span>{count}</span>
        </h2>
        <h2>
          Ref: <span>{countRef.current}</span>
        </h2>
        <h2>
          Let: <span>{countLet}</span>
        </h2>
      </div>
      <div className="button-group">
        <button onClick={increaseState}>State + 1</button>
        <button onClick={increaseRef}>Ref + 1</button>
        <button onClick={increaseLet}>Let + 1</button>
      </div>
      <button className="rerender-button" onClick={() => setRender(!render)}>
        강제 리렌더링
      </button>
    </div>
  );
}
export default VarCompare;
