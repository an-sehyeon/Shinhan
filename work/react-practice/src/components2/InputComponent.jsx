import React from "react";
import { Form, InputGroup } from "react-bootstrap";

function InputComponent(props) {
  return (
    <div>
      <InputGroup>
        <InputGroup.Text> {props.label}</InputGroup.Text>
        <Form.Control
          name={props.label}
          aria-label={props.label}
          onChange={props.onChange}
        ></Form.Control>
        <Form.Control
          name={props.label}
          aria-label={props.label}
          onChange={(e) => {
            props.onChange2(e.target.value);
          }}
        ></Form.Control>
      </InputGroup>
    </div>
  );
}

export default InputComponent;
