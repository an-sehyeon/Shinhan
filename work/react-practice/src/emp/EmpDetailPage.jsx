import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { initEmp, sanitizeNullToEmpty, springPath } from "./common";
import axios from "axios";

function EmpDetailPage(props) {
  const navigate = useNavigate();
  const { empid } = useParams();
  //value가 undefined가 되는 것을 방지하기 위해 초기값setting함
  const [emp, setEmp] = useState(initEmp);
  const [deptList, setDeptList] = useState([]);
  const [jobList, setJobList] = useState([]);

  useEffect(() => {
    //부서선택, 직책선택을 위해 data를 가져와야함
    axios(`${springPath}/emp/api/empdetail.do/${empid}`).then((response) => {
      //console.log("응답data:", response);
      //만약 값에 null이 들어있다면? ""로 변경(1)null을 빈 문자열로 치환 (|| "")
      //(2) 가공***

      setEmp(sanitizeNullToEmpty(response.data.emp));
      setDeptList(response.data.deptlist);
      setJobList(response.data.joblist);
    });
  }, []);

  // useEffect(() => {
  //   console.log(emp);
  // }, [emp]);

  const homeButtonHandler = () => {
    navigate("/");
  };

  const changehandler = (e) => {
    const { name, value } = e.target;
    setEmp({ ...emp, [name]: value });
  };

  const updateButtonHandler = () => {
    //empupdate.do
    axios
      .put(`${springPath}/emp/api/empupdate.do`, emp)
      .then((response) => {
        //console.log("응답data:", response);
        alert(response.data);
        navigate("/emp/list");
      })
      .catch((error) => {
        console.log("에러코드:" + error.status);
        console.log("에러메서드:" + error.message);
      })
      .finally(() => {
        console.log("수정.....axios 완료");
      });
  };
  return (
    <div>
      <h1>{empid} : 직원상세보기 </h1>
      <label>직원번호:</label>
      <input
        type="number"
        name="employee_id"
        value={emp.employee_id}
        readOnly={true}
      />

      <br />
      <label>이름:</label>
      <input
        name="first_name"
        value={emp.first_name}
        onChange={changehandler}
      />
      <br />
      <label>성:</label>
      <input name="last_name" value={emp.last_name} onChange={changehandler} />
      <br />
      <label>이메일:</label>
      <input name="email" value={emp.email} onChange={changehandler} />
      <br />
      <label>전화번호:</label>
      <input
        name="phone_number"
        value={emp.phone_number}
        onChange={changehandler}
      />
      <br />

      <hr />
      <label>직책선택:</label>
      <select name="job_id" onChange={changehandler} value={emp.job_id}>
        <option>직책선택</option>
        {jobList &&
          jobList.map((job, index) => (
            <option key={index} value={job.jobId}>
              {job.jobTitle}
            </option>
          ))}
      </select>

      <label>부서선택:</label>
      <select
        name="department_id"
        onChange={changehandler}
        value={emp.department_id}
      >
        <option>부서선택</option>
        {deptList &&
          deptList.map((dept, index) => (
            <option key={index} value={dept.department_id}>
              {dept.department_name}
            </option>
          ))}
      </select>

      <hr />
      <label>manager_id:</label>
      <input
        type="number"
        name="manager_id"
        value={emp.manager_id}
        onChange={changehandler}
      />
      <br />

      <label>Salary:</label>
      <input
        type="number"
        name="salary"
        value={emp.salary}
        onChange={changehandler}
      />
      <br />
      <label>commission_pct:</label>
      <input
        type="text"
        name="commission_pct"
        value={emp.commission_pct}
        onChange={changehandler}
      />
      <br />
      <label>입사일:</label>
      <input
        type="date"
        name="hire_date"
        value={emp.hire_date}
        onChange={changehandler}
      />
      <br />

      <button onClick={updateButtonHandler}>수정하기</button>
      <button onClick={homeButtonHandler}>Home이동</button>
      <Link
        to={`/emp/delete/${emp.employee_id}`}
        state={{ empid2: emp.employee_id, fname: emp.first_name }}
      >
        삭제
      </Link>
    </div>
  );
}

export default EmpDetailPage;
