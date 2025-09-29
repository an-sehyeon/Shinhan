//1번째 arg : 상태관리를 하기위한 값 useReducer(todoReducer, 초기값), 상태값이 변경되면 계속 관리됨
//2번째 arg : action안에 어떤 동작을 해야되는지(type), 동작에서 사용될 값(동작에따라 다르다. )
export function todoReducer(state, action) {
  switch (action.type) {
    case "CREATE":
      return [action.newItem, ...state];
    //dispatch({type:"CREATE",newItem:{id:1,content:"," isDone:true} })
    case "UPDATE":
      const mappedList = state.map((it) =>
        //it.id === targetId ? { ...it, isDone: !it.isDone } : it
        {
          if (it.id === action.targetId) {
            if (action.colname === "isDone") {
              return { ...it, isDone: !it.isDone };
            } else {
              return { ...it, content: action.value };
            }
          } else {
            return it;
          }
        }
      );
      return mappedList;
    case "DELETE":
      return state.filter((it) => it.id !== action.targetId);
    default:
      return state;
  }
}
