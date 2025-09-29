import React, { useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Header from "project3Edu/components/Header";
import Button from "project3Edu/components/Button";
import { DiaryDispatchContext } from "project3Edu/util/diaryUtil";
import Editor from "project3Edu/components/Editor";

function New(props) {
  const navigate = useNavigate();
  const goBack = () => {
    navigate(-1);
  };
  const { onCreate } = useContext(DiaryDispatchContext);
  const onSubmit = (data) => {
    const { date, emotionId, content } = data;
    onCreate(date, content, emotionId);
    //navigate("..");
    navigate("/mydiary");
  };

  return (
    <div>
      <Header
        title="새일기쓰기"
        leftChild={<Button text="< 뒤로가기" onClick={goBack} />}
      />
      <Editor onSubmit={onSubmit} />
    </div>
  );
}

export default New;
