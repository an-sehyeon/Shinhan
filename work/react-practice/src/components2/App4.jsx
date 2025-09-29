import React from "react";
import Profile from "./Profile";
import { Link } from "react-router-dom";

function App4(props) {
  const user = { name: "지민", age: 30 };
  const user2 = { ...user, age: 40 };
  const { name, age } = user2;
  console.log("부모:", name, age);
  return (
    <div>
      <Profile name="상현1" age={10} />
      <Profile name={user.name} age={user.age} />
      <Profile {...user}>
        <p style={{ color: "blue" }}>user의 자식</p>
      </Profile>
      <Profile {...user2}>
        <p style={{ color: "red" }}>user2의 자식</p>
      </Profile>
      <Profile></Profile>
    </div>
  );
}

export default App4;
