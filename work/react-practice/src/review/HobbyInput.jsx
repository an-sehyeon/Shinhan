import React from "react";

function HobbyInput({ hobbyChangeHandler, addClickHandler }) {
  console.log("HobbyInput rendering");
  return (
    <div style={{ border: "1px solid green" }}>
      <h3>hobby input</h3>
      <div>
        title : <input name="title" onChange={hobbyChangeHandler} />
      </div>
      <div>
        price : <input name="price" onChange={hobbyChangeHandler} />
      </div>
      <button onClick={addClickHandler}>취미추가</button>
    </div>
  );
}

export default React.memo(HobbyInput);
