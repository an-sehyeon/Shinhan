import { TodoDispatchContext } from "context/TodoContext";
import "project2/css/TodoItem.css";
import React from "react";
import { useContext } from "react";
import { useState } from "react";

const TodoItem = ({ id, content, isDone }) => {
  const { createdDate, onUpdate, onDelete } = useContext(TodoDispatchContext);

  console.log(`${id} item변경`);
  const onChangeCheckbox = () => {
    onUpdate(id, "isDone", null);
  };
  const onClickDelete = () => {
    onDelete(id);
  };
  const [updateContent, setUpdateContext] = useState(content);
  const contentHandler = (e) => {
    setUpdateContext(e.target.value);
    //onUpdate(id, "content", e.target.value);
  };
  const onClickUpdate = (e) => {
    onUpdate(id, "content", updateContent);
  };

  return (
    <div className="TodoItem">
      <div className="checkbox_col">
        <input onChange={onChangeCheckbox} checked={isDone} type="checkbox" />
      </div>
      <div className="title_col">
        <input value={updateContent} name="content" onChange={contentHandler} />
        <button onClick={onClickUpdate}>수정</button>
      </div>
      <div className="date_col">
        {new Date(createdDate).toLocaleDateString()}
      </div>
      <div className="btn_col">
        <button onClick={onClickDelete}>삭제</button>
      </div>
    </div>
  );
};
//TodoItem이 여러개인 경우이다.  변경된 Item만 Rendering해야한다.
//그러나 부모가 자식에게 (TodoItem) 함수를 속성으로 제공하고있다.
//속성으로 제공되고있는 함수가 부모 Rendering시에 재생성된다면 바뀐함수객체가 오므로 변경되지않아도 Rendering된다
//이를 막기위해 함수를 useCallback()으로 Memo한다.
export default React.memo(TodoItem);
