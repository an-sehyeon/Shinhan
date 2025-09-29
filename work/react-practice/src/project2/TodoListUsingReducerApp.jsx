import Header from "project2/components/Header";
import TodoEditor from "project2/components/TodoEditor";
import TodoList from "project2/components/TodoList";
import { useReducer, useRef, useState } from "react";
import "project2/css/TodoListApp.css";
import { mockTodo } from "project2/data/mockData";
import { todoReducer } from "project2/todoReducer";
import { useCallback } from "react";
import {
  TodoContext,
  TodoDispatchContext,
  TodoStateContext,
} from "context/TodoContext";
import { useMemo } from "react";

/*
hook --- 함수 
useState() - 상태값이 바뀌면 Reredering 
useRef() - redering시에 초기화하지않음, 값이 변경되어도 rendering안함  
useCallback() - function memo
useMemo() - data memo
useReducer() - 상태관리와 기능이 컴푸넌트 외부 
useEffect() - lifeCycle관리 
useContext - data공유 
*/

function TodoListUsingReducerApp() {
  //1)useState()로 상태관리 : Component내부에서 값의 변경을 관리 , 로직이 내부에있음
  //const [todo, setTodo] = useState(mockTodo); //배열
  //2)useReducer로 상태관리 : Component외부에서 값의 변경을 관리 , 로직이 외부에있음
  // [현재상태값, 외부로직의 이벤트발생유발(함수호출임)] = useReducer(외부로직, 초기값)
  const [todo, dispatch] = useReducer(todoReducer, mockTodo); //배열

  const idRef = useRef(3); //Re Rendering되어도 다시 초기화안함, 값이변경되어도 Rendering안함

  const onCreate = useCallback((content) => {
    const newItem = {
      id: idRef.current,
      content,
      isDone: false,
      createdDate: new Date().getTime(),
    };

    //setTodo([newItem, ...todo]); //신규를 앞쪽에 추가, 배열복사
    dispatch({ type: "CREATE", newItem });
    idRef.current += 1;
  }, []);

  const onUpdate = useCallback((targetId, colname, value) => {
    dispatch({ type: "UPDATE", targetId, colname, value });
  }, []);

  const onDelete = useCallback((targetId) => {
    dispatch({ type: "DELETE", targetId });
  }, []);

  //컴포넌트가 Rendering되면 다시 생성된다.

  const memoizedDispatches = useMemo(() => {
    return { onCreate: onCreate, onUpdate, onDelete };
  }, [onCreate, onUpdate, onDelete]);

  return (
    <div className="todo-container">
      <Header />
      <TodoStateContext.Provider value={{ todo }}>
        <TodoDispatchContext.Provider value={memoizedDispatches}>
          <TodoEditor />
          <TodoList />
        </TodoDispatchContext.Provider>
      </TodoStateContext.Provider>
    </div>

    // <div className="todo-container">
    //   <Header />
    //   <TodoContext.Provider value={{ todo, onCreate, onUpdate, onDelete }}>
    //     <TodoEditor />
    //     <TodoList />
    //   </TodoContext.Provider>
    // </div>
  );
}

export default TodoListUsingReducerApp;
