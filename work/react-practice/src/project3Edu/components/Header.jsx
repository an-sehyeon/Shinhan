import React from "react";
import "project3Edu/css/Header.css";
function Header({ leftChild, rightChild, title }) {
  return (
    <div className="Header">
      <div className="header_left">{leftChild}</div>
      <div className="header_title">{title}</div>
      <div className="header_right">{rightChild}</div>
    </div>
  );
}

export default Header;
