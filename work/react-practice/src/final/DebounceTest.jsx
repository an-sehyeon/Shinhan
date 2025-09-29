import React, { useEffect, useState } from "react";
import { useDebounce } from "./Debounce";

function getData(word) {
  if (!word) return [];
  const users = [
    { name: "홍길동", age: 20 },
    { name: "김민수", age: 30 },
    { name: "김민영", age: 40 },
    { name: "정민수", age: 50 },
  ];
  return users.filter((user) => user.name.startsWith(word));
}

function DebounceTest(props) {
  const [input, setInput] = useState("");
  //const [deboundInput, setDeboundInput] = useState(input);
  const [deboundInput] = useDebounce(input, 300);
  const handleChange = (e) => {
    setInput(e.target.value);
  };
  const [result, setResult] = useState([]);
  useEffect(() => {
    console.log("search......");
    setResult(getData(deboundInput));
  }, [deboundInput]);

  return (
    <div className="container" style={{ padding: "2rem" }}>
      <h3>🔎 Debounced Search</h3>
      <input
        type="text"
        placeholder="검색어를 입력하세요"
        value={input}
        onChange={handleChange}
        style={{ padding: "0.5rem", width: "300px" }}
      />
      <hr />
      {result.map((it, index) => (
        <p key={index}>{it.name}</p>
      ))}
    </div>
  );
}

export default DebounceTest;
