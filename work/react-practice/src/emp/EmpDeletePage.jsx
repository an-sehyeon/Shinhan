import axios from "axios";
import React from "react";
import { useEffect } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import { springPath } from "./common";

function EmpDeletePage(props) {
  //1.param받기
  const { empid } = useParams();
  const location = useLocation();
  const { empid2, fname } = location.state;
  const navi = useNavigate();

  //console.log("파라메터전달:" + empid);
  //console.log("Link전달:", empid2, fname);

  useEffect(() => {
    axios
      .delete(`${springPath}/emp/api/empdelete.do/${empid}`)
      .then((response) => {
        alert(response.data.message);
        navi("/emp/list");
      })
      .catch((error) => {
        console.log("에러코드:" + error.status);
        console.log("에러메서드:" + error.message);
      })
      .finally(() => {
        console.log("delete.....axios 완료");
      });
  }, []);

  return <div>delete</div>;
}

export default EmpDeletePage;
