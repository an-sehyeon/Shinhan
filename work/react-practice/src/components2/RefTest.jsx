import React, { useEffect, useRef, useState } from "react";
import { Button, Form, InputGroup } from "react-bootstrap";

//useRef
//1)DOM접근시 사용
//2)최초값이 ReRendering되었을때 다시 초기화되지않는 값이 필요할때
function RefTest(props) {
  const nameRef = useRef();
  const ageRef = useRef();

  const [count, setCount] = useState(0); //값이 변경되면 ReRendering한다.
  const countRef = useRef(0); //값이 변경되어도 ReRendering하지않음
  let countLet = 0; //일반변수는 ReRendering되었을때 다시 초기화

  const nameHandler = () => {
    nameRef.current.focus();
  };
  const ageHandler = () => {
    ageRef.current.focus();
  };
  const countHandler = () => {
    setCount(count + 1);
    countLet++;
    countRef.current++;

    console.log("countLet=" + countLet);
    console.log("countRef.current=" + countRef.current);
  };
  useEffect(() => {
    console.log("setCount로 count변경:" + count);
  }, [count]);

  useEffect(() => {
    console.log("리렌더링시마다 발생 ");
  });

  return (
    <>
      <p>상태관리 : {count}</p>
      <input ref={nameRef} placeholder="이름입력" />
      <input ref={ageRef} placeholder="나이입력" />
      <Button onClick={nameHandler}>Focus이동1(name)</Button>
      <Button onClick={ageHandler}>Focus이동2(age)</Button>
      <Button onClick={countHandler}>값증가</Button>
    </>
  );
}

export default RefTest;
