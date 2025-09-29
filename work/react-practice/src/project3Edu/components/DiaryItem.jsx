import React from "react";
import "project3Edu/css/DiaryItem.css";
import { getEmotionImgById } from "project3Edu/util/diaryUtil";
import { useNavigate } from "react-router-dom";
import Button from "project3Edu/components/Button";
function DiaryItem({ id, emotionId, content, date }) {
  const navigate = useNavigate();
  const goDetail = () => {
    navigate(`diary/${id}`);
  };
  const goEdit = () => {
    navigate(`edit/${id}`);
  };
  return (
    <div className="DiaryItem">
      <div
        onClick={goDetail}
        className={["img_section", `img_section_${emotionId}`].join(" ")}
      >
        <img alt={`emotion${emotionId}`} src={getEmotionImgById(emotionId)} />
      </div>
      <div className="info_section" onClick={goDetail}>
        {new Date(parseInt(date)).toLocaleDateString()}
      </div>
      <div className="info_section">{content.slice(0, 25)}</div>

      <div className="button_section">
        <Button onClick={goEdit} text="수정하기!!" />
      </div>
    </div>
  );
}

export default DiaryItem;
