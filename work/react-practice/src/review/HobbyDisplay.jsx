import React from "react";

function HobbyDisplay(props) {
  console.log("HobbyDisplay rendering", props);
  const { hobbyArr, aa } = props;
  const lname = props.aa;
  return (
    <div style={{ border: "1px solid blue" }}>
      <h3>
        hobby display:{lname}...{aa}
      </h3>
      <ul>
        {hobbyArr.map((item, index) => (
          <li key={index}>
            {item.id}: {item.title}의 회비는 {item.price}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default React.memo(HobbyDisplay);
