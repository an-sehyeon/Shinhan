import { Button } from "bootstrap";
import React, { useEffect, useMemo, useState } from "react";
import { Stack } from "react-bootstrap";

function ChildComp1({ clickListener2 }) {
  const [childValue, setChildValue] = useState(0);
  const [childValue2, setChildValue2] = useState(100);
  useEffect(() => {
    console.log("child redering");
  });
  const clickListener = () => {
    setChildValue(childValue + 1);
  };
  const changeListener = (e) => {
    clickListener2(e.target.value);
  };

  const expensiveCalculation = (num) => {
    console.log("복잡한 오래걸리는 Calculating...");
    for (let i = 0; i < 1000; i++) {
      num += 1;
    }
    return num;
  };
  const result = useMemo(() => expensiveCalculation(childValue), [childValue]);
  const changeListener2 = () => {
    setChildValue2(childValue2 + 1);
  };
  return (
    <div>
      <h3 className="mb-4">
        Child1: <span className="text-primary">{childValue}</span>
        {"   "}계산결과 : <span className="text-primary">{result}</span>
      </h3>
      <button onClick={clickListener}>자식에서클릭</button>
      <br />
      childValue:
      <input onChange={changeListener} />
      childValue2:<input onChange={changeListener2}></input>
      <p className="text-danger">
        이값이 변경되어도 오래걸리는 작업안함:{childValue2}
      </p>
    </div>
  );
}

export default React.memo(ChildComp1);
