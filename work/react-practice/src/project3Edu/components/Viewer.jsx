import { emotionList } from "project3Edu/util/diaryUtil";
import React from "react";
import "project3Edu/css/EmotionItem.css";
import "project3Edu/css/Viewer.css";

function Viewer({ content, emotionId }) {
  const emotionItem = emotionList.find((it) => it.id === emotionId);

  return (
    <div className="Viewer">
      <section>
        <h4>오늘의 감정</h4>
        <div
          className={[
            "emotion_img_wrapper",
            `emotion_img_wrapper_${emotionId}`,
          ].join(" ")}
        >
          <img src={emotionItem.img} alt={emotionItem.name} />
          <div className="emotion_description">{emotionItem.name}</div>
        </div>
      </section>
      <section className="content_wrapper">
        <h4>오늘의 일기</h4>
        <p>{content}</p>
      </section>
    </div>
  );
}

export default Viewer;
