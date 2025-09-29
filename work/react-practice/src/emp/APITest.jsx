import axios from "axios";
import React from "react";
import { useState } from "react";

const baseURL = "https://jsonplaceholder.typicode.com";

function APITest(props) {
  const [data, setData] = useState();

  const postHandler = () => {
    const headers = {};
    const body = JSON.stringify({});
    //1. 브라우저의 내장 API, Network에러만 처리, HTTP에러처리(404, 500)는 추가한다.
    fetch(`${baseURL}/posts`, { method: "get" }) //, {headers, body})
      .then((response) => {
        if (!response.ok) throw new Error("HTTP에러 발생");
        return response.json();
      })
      .then((json) => setData(json))
      .catch((error) => {
        console.log(error); //CORS오류 , 서버다운, 인터넷끊김
      })
      .finally(() => {
        console.log("fetch완료");
      });
  };

  //2. Promise : 비동기 처리 표준 객체, 비동기 흐름 제어
  const f_promise = () => {
    return new Promise((resolve, reject) => {
      fetch(`${baseURL}/users`)
        .then((res) => {
          if (!res.ok) throw new Error("데이터를 찾을 수 없음");
          return res.json();
        })
        .then(resolve)
        .catch(reject);
    });
  };
  const userHandler = () => {
    f_promise()
      .then((data) => setData(data))
      .catch((error) => console.error("Promise error:", error));
  };

  //3.Axios : 실무에서 주로 사용, 자동으로 JSON파싱, Chain방식
  //axios(), axios.get(), axios.post(), axios.delete(), axios.put(), axios({url:""})
  const albumHandler = () => {
    const body = {};
    const headers = { headers: {} };
    axios(`${baseURL}/albums`, body, headers)
      .then((response) => {
        console.log("응답data:", response.data);
        setData(response.data);
      })
      .catch((error) => {
        console.log("에러코드:" + error.status);
        console.log("에러메서드:" + error.message);
      })
      .finally(() => {
        console.log("axios 완료");
      });
  };
  //4.axios...async...await 동기처럼 보임, 깔끔
  const todoHandler = async () => {
    const response = await axios(`${baseURL}/todos`);
    try {
      setData(response.data);
    } catch (error) {
      console.log("에러코드:" + error.status);
      console.log("에러메서드:" + error.message);
    } finally {
      console.log("axios...async...await 완료");
    }
  };

  return (
    <div>
      <button onClick={postHandler}>posts가져오기</button>
      <button onClick={userHandler}>users가져오기</button>
      <button onClick={albumHandler}>albums가져오기</button>
      <button onClick={todoHandler}>todos가져오기</button>
      <pre>{JSON.stringify(data, null, 2)}</pre>
    </div>
  );
}

export default APITest;
