import React from "react";

function Profile({ name = "아무개", age = 5, children }) {
  console.log("자식:", name, age);
  return (
    <div style={{ border: "1px solid green" }}>
      <p>이름은 {name}</p>
      <p>나이는 {age}</p>
      <div>
        !!!자식!!!
        {children}
      </div>
    </div>
  );
}

export default Profile;
