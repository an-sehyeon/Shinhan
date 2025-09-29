import { useEffect } from "react";
import { useState } from "react";

export function useDebounce(initValue, delay) {
  const [debounceInput, setDebounceInput] = useState(initValue);

  useEffect(() => {
    let timerId = setInterval(() => {
      setDebounceInput(initValue);
    }, delay);
    return () => {
      clearTimeout(timerId);
    };
  }, [initValue, delay]);

  return debounceInput;
}
