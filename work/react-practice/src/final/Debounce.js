import { useEffect, useState } from "react";

export function useDebounce(value, delay) {
  const [debounceInput, setDebounceInput] = useState(value);

  useEffect(() => {
    let timerId = setTimeout(() => {
      setDebounceInput(value);
    }, delay);
    return () => clearTimeout(timerId);
  }, [value, delay]);

  return debounceInput;
}
