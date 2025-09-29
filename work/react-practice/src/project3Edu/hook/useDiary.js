import { DiaryStateContext } from "project3Edu/util/diaryUtil";
import { useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const useDiary = (id) => {
  const data = useContext(DiaryStateContext);
  const [diary, setDiary] = useState();

  const navigate = useNavigate();
  useEffect(() => {
    const matchDiary = data.find((it) => String(it.id) === String(id));
    if (matchDiary) {
      setDiary(matchDiary);
    } else {
      alert("일기가 존재하지않습니다.");
      navigate("/mydiary"); //페이지이동후 다시 돌아올 수 없도록 뒤로가기 비활성화
    }
  }, [id]);
  return diary;
};

export default useDiary;
