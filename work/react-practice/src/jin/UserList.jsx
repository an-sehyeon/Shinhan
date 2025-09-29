import React, { useState, useMemo, useCallback } from 'react';
import './UserList.css';

// 1. React.memo를 사용하여 자식 컴포넌트 최적화
const UserInfo = React.memo(({ user, onUpdate }) => {
  console.log(`${user.name}의 UserInfo 컴포넌트 렌더링됨`);
  return (
    <div className="user-info-card">
      <p>이름: {user.name}</p>
      <p>나이: {user.age}</p>
      <button className="update-age-button" onClick={() => onUpdate(user.id)}>나이 1살 추가</button>
    </div>
  );
});

// 부모 컴포넌트
function UserList() {
  const [users, setUsers] = useState([
    { id: 1, name: '철수', age: 20 },
    { id: 2, name: '영희', age: 22 },
  ]);
  const [theme, setTheme] = useState('light'); // 리렌더링 유발용 state

  // 2. useMemo를 사용하여 복잡한 연산 결과 메모이제이션
  // '평균 나이'는 users 배열이 변경될 때만 다시 계산됩니다.
  const averageAge = useMemo(() => {
    console.log("평균 나이 계산 중...");
    const sum = users.reduce((acc, user) => acc + user.age, 0);
    return (sum / users.length).toFixed(1);
  }, [users]);

  // 3. useCallback을 사용하여 함수 메모이제이션
  // 이 함수는 users 배열이 변경될 때만 새로 생성됩니다.
  const handleUpdateUser = useCallback((id) => {
    setUsers(
      users.map(user =>
        user.id === id ? { ...user, age: user.age + 1 } : user
      )
    );
  }, [users]);

  const toggleTheme = () => {
    setTheme(prev => (prev === 'light' ? 'dark' : 'light'));
  };

  return (
    <div className={`user-list-container ${theme}`}>
      <div className="header-section">
        <h2>사용자 목록 (성능 최적화 예제)</h2>
        <button className="theme-button" onClick={toggleTheme}>
            {theme === 'light' ? '다크' : '라이트'} 테마 변경
        </button>
      </div>
      <p className="average-age">평균 나이: {averageAge}</p>
      <hr />
      <div className="user-info-list">
        {users.map(user => (
          <UserInfo key={user.id} user={user} onUpdate={handleUpdateUser} />
        ))}
      </div>
    </div>
  );
}

export default UserList;
