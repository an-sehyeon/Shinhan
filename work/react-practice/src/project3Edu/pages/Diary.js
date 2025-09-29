import React from "react";
import { useParams } from "react-router-dom";

function Diary(props) {
  const { id } = useParams();

  return <div>Diary 페이지입니다.{id}번일기 </div>;
}

export default Diary;
