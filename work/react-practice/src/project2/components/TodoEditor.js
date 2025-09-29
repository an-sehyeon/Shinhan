import { useState, useRef } from "react";
import "project2/css/TodoEditor.css";
import { useContext } from "react";
import { TodoDispatchContext } from "context/TodoContext";
import { useEffect } from "react";

const TodoEditor = () => {
  const { onCreate } = useContext(TodoDispatchContext);

  const [content, setContent] = useState("");
  const inputRef = useRef(); //DOM접근

  const onChangeContent = (e) => {
    setContent(e.target.value);
  };

  const onSubmit = () => {
    if (!content) {
      inputRef.current.focus();
      return;
    }
    onCreate(content);
    setContent(""); //content=""
  };
  const onKeyDown = (e) => {
    if (e.keyCode === 13) {
      //enter키를 누름
      onSubmit();
    }
  };

  return (
    <div className="TodoEditor">
      <h4>새로운 Todo 작성하기 ✏ </h4>
      <div className="editor_wrapper">
        <input
          ref={inputRef}
          value={content}
          onChange={onChangeContent}
          onKeyDown={onKeyDown}
          placeholder="새로운 Todo..."
        />
        <button onClick={onSubmit}>추가</button>
      </div>
    </div>
  );
};
export default TodoEditor;
