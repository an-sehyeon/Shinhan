import Header from "project3Edu/components/Header";
import React, { useContext, useEffect, useState } from "react";
import Button from "project3Edu/components/Button";
import {
  DiaryStateContext,
  getMonthRangeByDate,
} from "project3Edu/util/diaryUtil";
import DiaryList from "project3Edu/components/DiaryList";

function Home(props) {
  const data = useContext(DiaryStateContext);
  const [pivotDate, setPivotDate] = useState(new Date());
  const [filteredData, setFilteredData] = useState([]);
  useEffect(() => {
    if (data.length >= 1) {
      const { beginTimeStamp, endTimeStamp } = getMonthRangeByDate(pivotDate);

      setFilteredData(
        data.filter(
          (it) => beginTimeStamp <= it.date && it.date <= endTimeStamp
        )
      );
    } else {
      setFilteredData([]);
    }
  }, [data, pivotDate]);

  const onIncreaseMonth = () => {
    setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth() + 1));
  };
  const onDecreaseMonth = () => {
    setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth() - 1));
  };
  const headerTitle = `${pivotDate.getFullYear()}년 ${
    pivotDate.getMonth() + 1
  }월 `;
  return (
    <div>
      <Header
        title={headerTitle}
        rightChild={<Button text={">"} onClick={onIncreaseMonth} />}
        leftChild={<Button text={"<"} onClick={onDecreaseMonth} />}
      ></Header>
      <DiaryList data={filteredData}></DiaryList>
    </div>
  );
}

export default Home;
