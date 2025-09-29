import React, { useEffect, useReducer, useRef, useState } from "react";

import { Link, Route, Routes } from "react-router-dom";

import {
  DiaryDispatchContext,
  diaryReducer,
  DiaryStateContext,
  mockData,
} from "project3Edu/util/diaryUtil";
import Home from "project3Edu/components/Home";
import Diary from "project3Edu/components/Diary";
import New from "project3Edu/components/New";
import Edit from "project3Edu/pages/Edit";
import DiaryLayout from "./DiaryLayout";

function AppDiary(props) {
  const [data, dispatch] = useReducer(diaryReducer, []); //app에서 초기data로딩후 특정page사용가능
  const [isDataLoaded, setisDataLoaded] = useState(false);
  const idRef = useRef(4);

  useEffect(() => {
    var rawData = localStorage.getItem("diary");
    /*if (!rawData) {
      dispatch({ type: "INIT", data: mockData });
    } else {
      dispatch({ type: "INIT", data: JSON.parse(rawData) });
    }*/
    dispatch({ type: "INIT", data: mockData });
    setisDataLoaded(true);
  }, []);

  const onCreate = (date, content, emotionId) => {
    const newData = {
      id: idRef.current,
      date: new Date(date).getTime(),
      content,
      emotionId,
    };
    dispatch({ type: "CREATE", data: newData });
    idRef.current++;
  };

  // // onUpdate(id, date, content, emotionId);
  const onUpdate = (targetId, date, content, emotionId) => {
    const newData = {
      id: targetId,
      date: new Date(date).getTime(),
      content,
      emotionId,
    };
    dispatch({ type: "UPDATE", data: newData });
  };
  const onDelete = (targetId) => {
    dispatch({ type: "DELETE", targetId });
  };

  if (!isDataLoaded) {
    return <div>데이터를 불러오는 중입니다.</div>;
  } else {
    return (
      <DiaryStateContext.Provider value={data}>
        <DiaryDispatchContext.Provider value={{ onCreate, onUpdate, onDelete }}>
          <div className="App">
            <Routes>
              <Route path="/" element={<DiaryLayout />}>
                <Route index element={<Home />} />
                <Route path="new" element={<New />} />
                <Route path="diary/:id" element={<Diary />} />
                <Route path="edit/:id" element={<Edit />} />
              </Route>
            </Routes>
          </div>
        </DiaryDispatchContext.Provider>
      </DiaryStateContext.Provider>
    );
  }
}

export default AppDiary;
