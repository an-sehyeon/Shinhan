import React, { useCallback, useEffect, useState } from "react";
import "project3Edu/css/Editor.css";
import { emotionList, getFormattedDate } from "project3Edu/util/diaryUtil";
import Button from "project3Edu/components/Button";
import { useNavigate } from "react-router-dom";
import EmotionItem from "project3Edu/components/EmotionItem";

function Editor({ initData, onSubmit }) {
  const navigate = useNavigate();
  const [state, setState] = useState({ date: new Date().getTime() });
  const handleChangeDate = (e) => {
    setState({ ...state, date: e.target.value });
  };
  const handleChangeContext = (e) => {
    setState({ ...state, content: e.target.value });
  };

  const handleSubmit = () => {
    onSubmit(state);
    //navigate("..");
    navigate("/mydiary");
    //navigate("/");
  };
  const handleGoBack = () => {
    navigate(-1);
  };
  const handleClickEmotion = useCallback((emotionId) => {
    setState((pre) => ({ ...pre, emotionId }));
  }, []);
  useEffect(() => {
    if (initData) {
      setState({
        ...initData,
        date: getFormattedDate(new Date(parseInt(initData.date))),
      });
    }
  }, [initData]);
  return (
    <div className="Editor">
      <div className="eitor_section">
        <h4>오늘의 날짜</h4>
        <div className="input_wrapper">
          <input type="date" value={state.date} onChange={handleChangeDate} />
        </div>
      </div>
      <div className="eitor_section">
        <h4>오늘의 감정</h4>
        <div className="input_wrapper emotion_list_wrapper">
          {emotionList.map((it) => (
            <EmotionItem
              key={it.id}
              {...it}
              onClick={handleClickEmotion}
              isSelected={state.emotionId === it.id}
            />
          ))}
        </div>
      </div>
      <div className="editor_section">
        <h4>오늘의 일기</h4>
        <div className="input_wrapper">
          <textarea
            placeholder="오늘은 어땠나요?"
            value={state.content}
            onChange={handleChangeContext}
          />
        </div>
      </div>
      <div className="editor_section bottom_section">
        <Button text="취소하기" onClick={handleGoBack} />
        <Button text="작성완료!!" type="positive" onClick={handleSubmit} />
      </div>
    </div>
  );
}

export default Editor;
