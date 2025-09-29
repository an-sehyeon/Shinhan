import useDiary from "project3Edu/hook/useDiary";
import React from "react";
import { useNavigate, useParams } from "react-router-dom";
import Header from "project3Edu/components/Header";
import { getFormattedDate } from "project3Edu/util/diaryUtil";
import Button from "project3Edu/components/Button";
import Viewer from "project3Edu/components/Viewer";

function Diary(props) {
  const { id } = useParams();
  const data = useDiary(id); //useDiary수행 아직 불러오지않은 상태에서 이 페이지가 Rendering되면 오류발생
  const navigate = useNavigate();
  if (!data) {
    return <div>일기를 불러오는 중입니다.</div>;
  } else {
    const { date, emotionId, content } = data;
    const title = `${getFormattedDate(new Date(Number(date)))}기록`;

    const goBack = () => {
      navigate(-1);
    };
    const goEdit = () => {
      navigate(`edit/${id}`);
    };
    return (
      <div>
        <Header
          title={title}
          leftChild={<Button text="<뒤로가기" onClick={goBack} />}
          rightChild={<Button text="수정하기**" onClick={goEdit} />}
        />

        <Viewer content={content} emotionId={emotionId} />
      </div>
    );
  }
}

export default Diary;
