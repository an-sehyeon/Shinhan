import React from "react";
import { Link, Outlet } from "react-router-dom";

function EmpLayout(props) {
  const ulStyle = {
    listStyle: "none",
    padding: 0,
    display: "flex",
    gap: "20px",
  };

  return (
    <div>
      <ul style={ulStyle}>
        <li>
          <Link to="/emp/list">조회</Link>
        </li>
        <li>
          <Link to="/emp/insert">입력</Link>
        </li>
      </ul>
      <div>
        <Outlet />
      </div>
    </div>
  );
}

export default EmpLayout;
