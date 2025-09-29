import React, { useCallback, useEffect, useMemo, useState } from "react";
import ChildComp1 from "./ChildComp1";

function ParentComp1(props) {
  const [parentMessage, setParentMessage] = useState("초기값");
  useEffect(() => {
    console.log("parent redering");
  });
  const clickListener = () => {
    setParentMessage(parentMessage + "*");
  };

  const clickListener2 = useCallback((message) => {
    setParentMessage(message);
  }, []);

  return (
    <div>
      <h1>부모:{parentMessage} </h1>
      <button onClick={clickListener}>부모버튼</button>
      <ChildComp1 clickListener2={clickListener2}></ChildComp1>
    </div>
  );
}

export default ParentComp1;
