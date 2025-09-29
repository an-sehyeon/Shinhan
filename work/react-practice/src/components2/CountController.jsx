import React from "react";
import { Button } from "react-bootstrap";

function CountController({ count, setCount, clickHandler2 }) {
  const clickHandler = (e) => {
    var su = parseInt(e.target.innerText);
    if (su === 0) {
      setCount(0);
    } else {
      //setCount(count + su);
      //setCount((pre2) => pre2 + su);
      setCount((pre2) => {
        return pre2 + su;
      });
    }
  };
  const compute = (su) => {
    setCount(count + su);
  };
  return (
    <div>
      {/* 자식이 정의함수를 호출 */}
      <Button
        variant="primary"
        onClick={() => {
          compute(-1);
        }}
      >
        -1
      </Button>
      {/* 부모가 정의한함수를 호출 */}

      <Button variant="secondary" onClick={() => clickHandler2(-10)}>
        -10
      </Button>
      {/* 자식이 정의한 함수(이벤트핸들러)를 이벤트에 연결 */}
      <Button variant="success" onClick={clickHandler}>
        -100
      </Button>
      <Button variant="warning" onClick={clickHandler}>
        -1000
      </Button>
      <Button variant="danger" onClick={clickHandler}>
        1000
      </Button>
      <Button variant="info" onClick={clickHandler}>
        100
      </Button>
      <Button variant="light" onClick={clickHandler}>
        10
      </Button>
      <Button variant="dark" onClick={clickHandler}>
        1
      </Button>
      <Button variant="link" onClick={clickHandler}>
        0
      </Button>
    </div>
  );
}

export default CountController;
