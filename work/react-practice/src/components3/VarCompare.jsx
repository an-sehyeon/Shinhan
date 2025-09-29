import { useEffect, useRef, useState } from "react";
import "components3/varCompare.css";

function VarCompare() {
  //상태관리를 하는 변수선언 setCount(0)=>count = 0  값이 변경되면 화면에 ReRendering한다.
  const [count, setCount] = useState(0);
  //최초 Rendering시에 countRef=0, ReRendering시에 다시 초기화하지않고 기존값이 유지된다.
  const countRef = useRef(0);
  //일반변수이다. ReRendering시에 다시 초기화한다.
  let countLet = 0;

  // 리렌더링을 유발하기 위한 state
  const [render, setRender] = useState(false);

  const increaseState = () => {
    setCount(count + 1); //비동기이므로 다음row가 먼저 실행된다.
    console.log(`상태관리를 하는 변수count(기존값): ${count}`);
  };

  useEffect(() => {
    console.log("의존배열이 비어있으면 최초 rendering시에 1회발생");
  }, []);

  useEffect(() => {
    console.log(`상태관리를 하는 변수count(변경값): ${count}`);
  }, [count]);

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
