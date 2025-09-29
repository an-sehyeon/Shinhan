import React from "react";
import { useState } from "react";
import { useInput } from "./useInput";

function CustomHookTest({ title }) {
  //const [name, setName] = useState("aaaa")
  const [name, onChangeHandler, clickHandler] = useInput("아무개");
  const [age, onChangeHandler2, clickHandler2] = useInput(10);

  return (
    <div>
      <h1>data:{name}</h1>
      이름입력:
      <input onChange={onChangeHandler} />
      <button onClick={clickHandler}>확인</button>
      <hr />
      <h1>나이:{age}</h1>
      나이입력:
      <input onChange={onChangeHandler2} />
      <button onClick={clickHandler2}>확인</button>
    </div>
  );
}

export default CustomHookTest;
