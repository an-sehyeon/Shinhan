import React, { useEffect, useState } from "react";
import CountViewer from "./CountViewer";
import CountController from "./CountController";
import { Button } from "react-bootstrap";

function CounterApp(props) {
  //부모가 count변수를 이용하여 상태관리를 한다. count값이 변경되면 React가 UI를 다시그린다.

  const [count, setCount] = useState(0);
  const [message, setMessage] = useState("초기값");
  const clickHandler2 = (su) => {
    setCount(count + su);
  };
  const messageHandler = () => {
    setMessage(message + "*");
  };
  /*함수형 컨포넌트의 라이프사이클 연습
  useEffect(콜백함수, [의존배열] )
  의존배열이 []이면 최초 rendering시 1회 
  */
  console.log("랜더링될때마다 수행된다.(useEffect없음)");
  useEffect(() => {
    console.log("useEffect...랜더링될때마다 수행된다.");

    //1초마다 문자찍기
    const intervalId = setInterval(() => {
      console.log("깜빡!!!!!!");
    }, 1000);

    //cleanUP을 return (마운트후에 호출할 함수를 return한다. )
    return () => {
      clearInterval(intervalId);
    };
  });
  useEffect(() => {
    console.log("useEffect...최초 rendering시 1회 수행된다.");
  }, []);
  useEffect(() => {
    console.log("useEffect...최초 rendering시,count변경시마다 수행된다.");
  }, [count]);
  useEffect(() => {
    console.log("useEffect...최초 rendering시,message변경시마다 수행된다.");
  }, [message]);
  useEffect(() => {
    console.log(
      "useEffect...최초 rendering시,count,message변경시마다 수행된다."
    );
  }, [count, message]);

  return (
    <div>
      <h1>{message}</h1>
      <Button variant="success" onClick={messageHandler}>
        메시지변경
      </Button>
      <CountViewer count2={count}></CountViewer>
      <CountController
        count={count}
        setCount={setCount}
        clickHandler2={clickHandler2}
      ></CountController>
    </div>
  );
}

export default CounterApp;
