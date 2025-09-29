import React from "react";
import { Button } from "react-bootstrap";

function EventTest(props) {
  const buttonHandler = (event) => {
    alert(event.target.textContent); //innerText
  };
  const changeHandler = (e) => {
    console.log(e.target.name, e.target.value);
  };
  const call = (su) => {
    alert(su);
  };
  function call2(su) {
    alert(su + 200);
  }
  return (
    <div>
      <Button
        variant="primary"
        onClick={(e) => {
          alert(e.target.innerText);
        }}
      >
        버튼1
      </Button>
      <Button variant="success" onClick={buttonHandler}>
        버튼2
      </Button>
      <Button variant="secondary" onClick={buttonHandler}>
        버튼3
      </Button>
      <Button
        variant="danger"
        onClick={() => {
          call(100);
          call2(100);
        }}
      >
        버튼4
      </Button>
      <input name="email" onChange={changeHandler} placeholder="이메일입력" />
      <input name="phone" onChange={changeHandler} placeholder="전화번호입력" />
    </div>
  );
}

export default EventTest;
