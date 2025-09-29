import Header from "project2/components/Header";
import TodoEditor from "project2/components/TodoEditor";
import TodoList from "project2/components/TodoList";
import { useRef, useState } from "react";
import "project2/css/TodoListApp.css";
import { mockTodo } from "project2/data/mockData";

function TodoListApp() {
  const [todo, setTodo] = useState(mockTodo); //배열

  const idRef = useRef(3); //Re Rendering되어도 다시 초기화안함, 값이변경되어도 Rendering안함

  const onCreate = (content) => {
    const newItem = {
      id: idRef.current,
      content,
      isDone: false,
      createdDate: new Date().getTime(),
    };

    setTodo([newItem, ...todo]); //신규를 앞쪽에 추가, 배열복사
    idRef.current += 1;
  };

  const onUpdate = (targetId, colname, value) => {
    const mappedList = todo.map((it) =>
      //it.id === targetId ? { ...it, isDone: !it.isDone } : it
      {
        if (it.id === targetId) {
          if (colname === "isDone") {
            return { ...it, isDone: !it.isDone };
          } else {
            return { ...it, content: value };
          }
        } else {
          return it;
        }
      }
    );
    setTodo(mappedList);
  };

  const onDelete = (targetId) => {
    setTodo(todo.filter((it) => it.id !== targetId));
  };

  return (
    <div className="todo-container">
      <Header />
      <TodoEditor onCreate={onCreate} />
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default TodoListApp;
