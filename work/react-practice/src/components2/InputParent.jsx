import React from "react";
import { Stack } from "react-bootstrap";
import InputComponent from "./InputComponent";

function InputParent(props) {
  const handleChange = (event) => {
    console.log(event.target.name, event.target.value);
    //dash속성은 카멜표기법 사용으로 접근한다.
    //console.log(event.target.ariaLabel);
  };
  const handleChange2 = (data) => {
    console.log("자식에서 받은data:" + data);
  };
  return (
    <div>
      <Stack direction="horizontal" gap={2} className="mt-3">
        <InputComponent
          label="username"
          onChange={handleChange}
          onChange2={handleChange2}
        />
        <InputComponent
          label="email"
          onChange={handleChange}
          onChange2={handleChange2}
        />
        <InputComponent
          label="password"
          onChange={handleChange}
          onChange2={handleChange2}
        />
      </Stack>
    </div>
  );
}

export default InputParent;
