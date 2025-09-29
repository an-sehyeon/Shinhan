import axios from "axios";
import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { Table } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";
import EmpListHeader from "./EmpListHeader";
import EmpListData from "./EmpListData";
import { springPath } from "./common";
import { Helmet } from "react-helmet";

function EmpListPage(props) {
  const [searchParams, setSerchParams] = useSearchParams();
  const sortOrder = searchParams.get("sort") || "latest";

  const [empList, setEmpList] = useState([]);

  useEffect(() => {
    const body = {};
    const headers = { headers: {} };
    axios(`${springPath}/emp/api/emplist.do`, body, headers)
      .then((response) => {
        //console.log("응답data:", response.data);
        setEmpList(response.data);
      })
      .catch((error) => {
        console.log("에러코드:" + error.status);
        console.log("에러메서드:" + error.message);
      })
      .finally(() => {
        console.log("empList.....axios 완료");
      });
  }, []);

  return (
    <div>
      <Helmet>
        <title>직원조회</title>
      </Helmet>
      <h1>직원목록 : {sortOrder} </h1>
      <Table className="striped bordered hover">
        <EmpListHeader />
        <tbody>
          {empList.map((emp, index) => (
            <tr key={emp.employee_id}>
              <EmpListData emp={emp} cpath={springPath} />
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default EmpListPage;
