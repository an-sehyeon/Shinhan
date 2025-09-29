import Button from "project3Edu/components/Button";
import Editor from "project3Edu/components/Editor";
import Header from "project3Edu/components/Header";
import useDiary from "project3Edu/hook/useDiary";
import { DiaryDispatchContext } from "project3Edu/util/diaryUtil";
import React, { useContext } from "react";
import { useNavigate, useParams } from "react-router-dom";

function Edit(props) {
  const { id } = useParams();
  const navigate = useNavigate();
  const goBack = () => {
    navigate(-1);
  };
  const { onDelete, onUpdate } = useContext(DiaryDispatchContext);
  const onClickDelete = () => {
    if (window.confirm("일기를 정말 삭제??")) {
      onDelete(id);
    }

    navigate("/", { replace: true });
  };
  const onSubmit = (data) => {
    if (window.confirm("일기를 정말 수정?")) {
      const { date, content, emotionId } = data;
      onUpdate(id, date, content, emotionId);
      navigate("/", { replace: true });
    }
  };
  const data = useDiary(id);
  if (!data) {
    <div>일기를 불러오고있습니다.</div>;
  } else {
    return (
      <div>
        <Header
          title="일기 수정하기"
          leftChild={<Button text="뒤로가기" onClick={goBack} />}
          rightChild={
            <Button text="삭제하기" type="negative" onClick={onClickDelete} />
          }
        />
        <Editor initData={data} onSubmit={onSubmit} />
      </div>
    );
  }
}

export default Edit;
