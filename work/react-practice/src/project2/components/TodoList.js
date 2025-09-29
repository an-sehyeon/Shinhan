import { useState } from "react";
import TodoItem from "project2/components/TodoItem";
import "project2/css/TodoList.css";
import { useContext } from "react";
import { TodoContext, TodoStateContext } from "context/TodoContext";
import { useEffect } from "react";
import { useCallback } from "react";
import { useDebounce } from "final/Debounce";

//1.선언적 함수 선언부
//function TodoList({ todo, onUpdate, onDelete }) {

//2.리터럴함수
//const f = ({a,b,c})=>{};

const TodoList = () => {
  const { todo } = useContext(TodoStateContext);

  const [search, setSearch] = useState("");
  const onChangeSearch = (e) => {
    setSearch(e.target.value);
  };

  const getSearchResult = () => {
    console.log("getSearchResult....");
    return search === ""
      ? todo
      : todo.filter((it) =>
          it.content.toLowerCase().includes(search.toLowerCase())
        );
  };

  //Debounce(디바운스) : 리엑트에서 빈번하게 발생하는 이벤트를 제어하여 성능을 취적화하는 기술이다.
  //사용자의 연속적인 입력에 대해 즉시 반응하지않고 일정 시간 동안의 간격을 두고 마지막 입력에 대해서만 처리하도록 한다.
  //검색, 자동완성고 같은 사용자의 입력을 실시간으로 처리해야할 때 유용하다.
  // const [debounceInput, setDebounceInput] = useState(search);
  // const [result, setResult] = useState([]);
  // useEffect(() => {
  //   let timerId = setTimeout(() => {
  //     setDebounceInput(search);
  //   }, 1000);
  //   return () => clearTimeout(timerId);
  // }, [search]);

  const [result, setResult] = useState([]);
  const debounceInput = useDebounce(search, 300);
  useEffect(() => {
    setResult(getSearchResult(debounceInput));
  }, [debounceInput]);

  return (
    <div className="TodoList">
      <h4>Todo List 🌱</h4>
      <input
        value={search}
        onChange={onChangeSearch}
        className="searchbar"
        placeholder="검색어를 입력하세요"
      />
      <div className="list_wrapper">
        {result.map((it) => (
          <TodoItem key={it.id} {...it} />
        ))}
      </div>
    </div>
  );
};
export default TodoList;
