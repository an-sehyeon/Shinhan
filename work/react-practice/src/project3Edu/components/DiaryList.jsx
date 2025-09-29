import React, { useEffect, useState } from "react";
import Button from "./Button";
import { useNavigate } from "react-router-dom";
import "project3Edu/css/DiaryList.css";
import DiaryItem from "project3Edu/components/DiaryItem";
import { useLayoutEffect } from "react";
import { useDebounce } from "final/Debounce";

const sortOptionList = [
  { value: "latest", name: "최신순" },
  { value: "oldest", name: "오래된 순" },
];

function DiaryList({ data }) {
  const [sortType, setSortType] = useState("latest");
  const [sortedData, setSortedData] = useState([]);
  const onChangeSortType = (e) => {
    setSortType(e.target.value);
  };
  const navigate = useNavigate();
  const onClickNew = () => {
    navigate("new");
  };
  useEffect(() => {
    const compare = (a, b) => {
      if (sortType === "latest") {
        return Number(b.date - a.date);
      } else {
        return Number(a.date - b.date);
      }
    };
    const copyList = [...data];
    copyList.sort(compare);
    setSortedData(copyList);
  }, [data, sortType]);

  //
  const [search, setSearch] = useState("");
  const searchChangeHandler = (e) => setSearch(e.target.value);

  const getSearchResult = () => {
    console.log("getSearchResult....");
    return search === ""
      ? sortedData
      : sortedData.filter((it) =>
          it.content.toLowerCase().includes(search.toLowerCase())
        );
  };

  //초기작업
  const [result, setResult] = useState([]);
  useEffect(() => {
    setResult(sortedData);
  }, [sortedData]);

  //연속적으로 같은 이벤트가 발생
  //이벤트발생시마다 함수호출하고있다.
  //그러나 마지막 이벤트 발생시에만 호출하고자한다.
  //Debounce기술
  //1)직접작성..Custom Hook으로 변경예정
  // const [debounceInput, setDebounceInput] = useState(search);

  // useEffect(() => {
  //   let timerId = setInterval(() => {
  //     setDebounceInput(search);
  //   }, 1000);
  //   return () => {
  //     clearTimeout(timerId);
  //   };
  // }, [search]);

  //2)Custom Hook으로 변경
  const debounceInput = useDebounce(search, 300);
  useEffect(() => {
    //console.log("debounceInput:" + debounceInput);
    setResult(getSearchResult());
  }, [debounceInput]);

  return (
    <div className="DiaryList">
      <div className="menu_wrapper">
        <div className="left_col">
          <select onChange={onChangeSortType}>
            {sortOptionList.map((it, index) => (
              <option key={index} value={it.value}>
                {it.name}
              </option>
            ))}
          </select>
          <span>
            <label htmlFor="search2">검색:</label>
            <input id="search2" onChange={searchChangeHandler} />
          </span>
        </div>

        <div className="right_col">
          <Button text="새 일기 쓰기!!" onClick={onClickNew}></Button>
        </div>
      </div>
      <div className="list_wrapper">
        {result.map((it) => (
          <DiaryItem key={it.id} {...it}></DiaryItem>
        ))}
      </div>
    </div>
  );
}

export default DiaryList;
