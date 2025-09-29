import axios from "axios";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";

const baseURL = "https://jsonplaceholder.typicode.com";
function FetchTest(props) {
  const [data, setData] = useState("");

  //1. fetch - 브라우저 내장 API,네트워크 에러만(서버 다운, 인터넷 끊김, 서버가 cross-origin 요청 허용 안함) catch됨
  // //(HTTP에러는 직접확인,404, 500))

  const postClick = () => {
    //const headers = {};
    //const body = JSON.stringify({});
    fetch(`${baseURL}/posts`, { method: "get" }) //, { headers, body })
      .then((response) => {
        console.log("res.ok:", response.ok); // false
        if (!response.ok) throw new Error(" HTTP 에러 발생!");
        return response.json();
      })
      .then((data) => setData(data))
      .catch((error) => console.error("네트워크 또는 throw된 에러 :", error))
      .finally(() => console.log("fetch 완료"));
  };

  //2. Promise : 비동기 처리 표준 객체, 비동기 흐름 제어
  const f_promise = () => {
    return new Promise((resolve, reject) => {
      fetch(`https://jsonplaceholder.typicode.com/users`)
        .then((res) => {
          if (!res.ok) throw new Error("데이터를 찾을 수 없음");
          return res.json();
        })
        .then(resolve)
        .catch(reject);
    });
  };
  const usersClick = () => {
    f_promise()
      .then((data) => setData(data))
      .catch((error) => console.error("Promise error:", error));
  };
  //3.실무에서는 보통 axios 사용, 자동으로 JSON 파싱됨
  const albumsClick = () => {
    const body = {};
    const headers = { headers: {} };
    axios(`${baseURL}/albums`, body, headers)
      .then((response) => setData(response.data))
      .catch((error) => {
        console.log("에러 상태 코드:", error.response?.status); // 404
        console.error("axios 에러:", error.message);
      })
      .finally(() => console.log("axios 완료"));
  };
  //
  const albumsClick2 = async () => {
    const body = {};
    const headers = { headers: {} };
    const response = await axios(`${baseURL}/albums`, body, headers);
    try {
      setData(response.data);
    } catch (error) {
      console.log("에러 상태 코드:", error.response?.status); // 404
      console.error("axios 에러:", error.message);
    } finally {
      console.log("axios 완료");
    }
  };

  return (
    <div>
      <button onClick={postClick}>posts</button>
      <button onClick={usersClick}>users</button>
      <button onClick={albumsClick}>albums</button>
      <button onClick={albumsClick2}>albums2</button>
      <pre>{data && JSON.stringify(data, null, 2)}</pre>
    </div>
  );
}

export default FetchTest;
