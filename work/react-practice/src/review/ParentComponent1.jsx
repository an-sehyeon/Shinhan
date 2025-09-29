import React from "react";
import { useState } from "react";
import ChildComponent1 from "review/ChildComponent1";
import HobbyInput from "./HobbyInput";
import HobbyDisplay from "./HobbyDisplay";
import { useCallback } from "react";
import { useMemo } from "react";
import { useRef } from "react";
import { Outlet } from "react-router-dom";

function ParentComponent1(props) {
  console.log("부모 Rendering");

  //부모에서만 사용되는 상태값
  const [trip, setTrip] = useState("미국");
  const tripChangehadler = (event) => {
    setTrip(event.target.value);
  };

  //부모에서 자식에 전달되는 상태값 , hobby, hobbyArr
  const [hobby, setHobby] = useState({ id: 1, title: "수영", price: 50000 }); //id, title, price
  const [hobbyArr, setHobbyArr] = useState([hobby]); //[{},{},{}]

  //부모가 Rendering시에 함수를 재생성하고있다.
  //함수를 메모하기 : useCallback(함수, [의존배열])
  //의존하는 값이 바뀌면 함수가 재생성된다.

  const [count, setCount] = useState(0);
  const longTimeFunction = (su) => {
    console.log("작업중.......");
    let total = 0;
    for (let i = 1; i <= su; i++) {
      total += i;
    }
    return total;
  };
  //Hook : react가 함수로 만들어 제공
  //useMemo()는 값을 memo, 의존배열의 값이 변경되면 다시 수행
  const computeResult = useMemo(() => longTimeFunction(count), [count]);

  //다시 렌더링되어도 값이 유지되기를 원함, 값변경이 rending하지않길 원함?
  //useRef()를 이용한다.
  const [id1, setId1] = useState(2); //값이변경되면 다시 rending,
  var id2 = 2; //값이변경되면 다시 rending안됨, 컴포넌트가 Rending시 다시초기화()
  const id3 = useRef(2); //값이변경되면 다시 rending안됨

  const hobbyChangeHandler = useCallback(
    (e) => {
      setHobby({ ...hobby, [e.target.name]: e.target.value });
    },
    [hobby]
  );
  const addClickHandler = useCallback(() => {
    const newHobby = { ...hobby, id: id3.current };
    //setHobby({ ...hobby, id: id3.current }); //주의 :set은 비동기이다
    //setHobby((pre) => ({ ...pre, id: id3.current }));
    id3.current++;
    setHobbyArr([...hobbyArr, newHobby]);
  }, [hobbyArr, hobby]);
  return (
    <div>
      <h1>
        부모Component:{trip} 여행중..... computeResult:{computeResult}
      </h1>
      <h2>
        {id1}...{id2}....{id3.current}
      </h2>
      <input onChange={tripChangehadler} />
      <input
        type="number"
        onChange={(e) => {
          setCount(e.target.value);
        }}
      />
      <hr />
      <HobbyInput
        hobbyChangeHandler={hobbyChangeHandler}
        addClickHandler={addClickHandler}
      />
      <HobbyDisplay hobbyArr={hobbyArr} aa="김" />

      {/* <ChildComponent1 money={1000} house="33평">
        자식1
      </ChildComponent1>
      <ChildComponent1>자식2</ChildComponent1> */}
    </div>
  );
}

export default ParentComponent1;
