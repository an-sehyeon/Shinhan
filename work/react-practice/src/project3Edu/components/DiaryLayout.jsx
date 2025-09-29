import React from "react";
import { Link, Outlet } from "react-router-dom";

function DiaryLayout(props) {
  return (
    <div>
      <h1>My Diary</h1>

      <Outlet />
    </div>
  );
}

export default DiaryLayout;
