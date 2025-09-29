import React from "react";
import { Link } from "react-router-dom";

function EmpListData({ emp, cpath }) {
  //클라이언트 라우트에 설정된 주소 연결
  const detailPath = `/emp/detail/${emp.employee_id}`; //URL에포함, 동적세그먼트이용

  return (
    <>
      <td>
        <Link to={detailPath}>{emp.employee_id}</Link>
      </td>
      <td>{emp.first_name}</td>
      <td>{emp.last_name}</td>
      <td>{emp.salary}</td>
      <td>{emp.email}</td>
      <td>{emp.department_id}</td>
      <td>{emp.commission_pct}</td>
      <td>{emp.manager_id}</td>
      <td>{emp.phone_number}</td>
      <td>{emp.job_id}</td>
      <td>{emp.hire_date}</td>
      <td>
        <button>
          <Link
            to={`/emp/delete/${emp.employee_id}`}
            state={{ empid2: emp.employee_id, fname: emp.first_name }}
          >
            삭제
          </Link>
        </button>
      </td>
    </>
  );
}

export default EmpListData;
