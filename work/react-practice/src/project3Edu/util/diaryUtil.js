import emotion1 from "project3Edu/img/emotion1.png";
import emotion2 from "project3Edu/img/emotion2.png";
import emotion3 from "project3Edu/img/emotion3.png";
import emotion4 from "project3Edu/img/emotion4.png";
import emotion5 from "project3Edu/img/emotion5.png";
import { createContext } from "react";

export const getEmotionImgById = (emotionId) => {
  switch (emotionId) {
    case 1:
      return emotion1;
    case 2:
      return emotion2;
    case 3:
      return emotion3;
    case 4:
      return emotion4;
    case 5:
      return emotion5;
    default:
      return null;
  }
};

export const getFormattedDate = (targetDate) => {
  let year = targetDate.getFullYear();
  let month = targetDate.getMonth() + 1;
  let date = targetDate.getDate();
  if (month < 10) {
    month = `0${month}`;
  }
  if (date < 10) {
    date = `0${date}`;
  }
  return `${year}-${month}-${date}`;
};

export const emotionList = [
  { id: 1, name: "완전좋음", img: getEmotionImgById(1) },
  { id: 2, name: "좋음", img: getEmotionImgById(2) },
  { id: 3, name: "그럭저럭", img: getEmotionImgById(3) },
  { id: 4, name: "나쁨", img: getEmotionImgById(4) },
  { id: 5, name: "끔찍함", img: getEmotionImgById(5) },
];

export const mockData = [
  {
    id: "mock1",
    date: new Date().getTime() - 1,
    content: "mock1",
    emotionId: 1,
  },
  {
    id: "mock2",
    date: new Date().getTime() - 2,
    content: "mock2",
    emotionId: 2,
  },
  {
    id: "mock3",
    date: new Date().getTime() - 3,
    content: "mock3",
    emotionId: 3,
  },
];

export const diaryReducer = (state, action) => {
  switch (action.type) {
    case "INIT":
      return action.data;
    case "CREATE": {
      const newState = [action.data, ...state];
      //localStorage.setItem("diary", JSON.stringify(newState));
      return newState;
    }
    case "UPDATE": {
      const newState = state.map((it) =>
        String(it.id) === String(action.data.id) ? { ...action.data } : it
      );
      //localStorage.setItem("diary", JSON.stringify(newState));
      return newState;
    }
    case "DELETE":
      const newState = state.filter((it) => it.id !== action.targetId);
      //localStorage.setItem("diary", JSON.stringify(newState));
      return newState;
    default:
      return state;
  }
};

export const DiaryStateContext = createContext();
export const DiaryDispatchContext = createContext();

export const getMonthRangeByDate = (date) => {
  const beginTimeStamp = new Date(
    date.getFullYear(),
    date.getMonth(),
    1
  ).getTime();

  const endTimeStamp = new Date(
    date.getFullYear(),
    date.getMonth() + 1,
    0,
    23,
    59,
    59
  ).getTime();
  //console.log(beginTimeStamp, endTimeStamp);
  return { beginTimeStamp, endTimeStamp };
};
