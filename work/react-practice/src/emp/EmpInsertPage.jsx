import axios from "axios";
import React from "react";
import { Navigate, useNavigate } from "react-router-dom";
import { springPath } from "./common";
import { useState } from "react";
import { useEffect } from "react";

//이동1(클릭동작) : <Link to="path"></Link>
//이동2(JS) : useNavigate()
//이동3 : <Navigate to="/" replace />

function EmpInsertPage(props) {
  const navigate = useNavigate();
  const [emp, setEmp] = useState({});
  const [deptList, setDeptList] = useState([]);
  const [jobList, setJobList] = useState([]);

  useEffect(() => {
    //부서선택, 직책선택을 위해 data를 가져와야함
    axios(`${springPath}/emp/api/selectDeptJob.do`).then((response) => {
      //console.log("응답data:", response);
      setDeptList(response.data.deptlist);
      setJobList(response.data.joblist);
    });
  }, []);

  const changehandler = (e) => {
    const { name, value } = e.target;
    setEmp({ ...emp, [name]: value });
  };
  const insertButtonHandler = () => {
    console.log("insert할 data:", emp);
    axios
      .post(`${springPath}/emp/api/empinsert.do`, emp)
      .then((response) => {
        console.log("응답data:", response);
        alert("직원이 등록되었습니다.");
        navigate("/emp/list");
      })
      .catch((error) => {
        console.log("에러코드:" + error.status);
        console.log("에러메서드:" + error.message);
      })
      .finally(() => {
        console.log("입력.....axios 완료");
      });
  };
  const homeButtonHandler = () => {
    navigate("/");
  };

  return (
    <div>
      <h1>직원등록</h1>

      <label>직원번호:</label>
      <input type="number" name="employee_id" onChange={changehandler} />

      <br />
      <label>이름:</label>
      <input name="first_name" onChange={changehandler} />
      <br />
      <label>성:</label>
      <input name="last_name" onChange={changehandler} />
      <br />
      <label>이메일:</label>
      <input name="email" onChange={changehandler} />
      <br />
      <label>전화번호:</label>
      <input name="phone_number" onChange={changehandler} />
      <br />

      <hr />
      <label>직책선택:</label>
      <select name="job_id" onChange={changehandler}>
        <option>직책선택</option>
        {jobList &&
          jobList.map((job, index) => (
            <option key={index} value={job.jobId}>
              {job.jobTitle}
            </option>
          ))}
      </select>

      <label>부서선택:</label>
      <select name="department_id" onChange={changehandler}>
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
      <input type="number" name="manager_id" onChange={changehandler} />
      <br />

      <label>Salary:</label>
      <input type="number" name="salary" onChange={changehandler} />
      <br />
      <label>commission_pct:</label>
      <input type="text" name="commission_pct" onChange={changehandler} />
      <br />
      <label>입사일:</label>
      <input type="date" name="hire_date" onChange={changehandler} />
      <br />

      <button onClick={insertButtonHandler}>입력하기</button>
      <button onClick={homeButtonHandler}>Home이동</button>
    </div>
  );
}

export default EmpInsertPage;
