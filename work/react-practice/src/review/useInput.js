import { useState } from "react";

export function useInput(initData) {
  const [data, setData] = useState(initData);
  const onChangeHandler = (e) => {
    setData(e.target.value);
  };
  const clickHandler = () => {
    alert(data);
  };

  return [data, onChangeHandler, clickHandler];
}
