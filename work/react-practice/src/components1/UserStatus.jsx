import React from "react";

function UserStatus({ isLoggin, name }) {
  return (
    <div>
      <div>
        전달받은 값 :{" "}
        {isLoggin ? (
          <span>{name}님 환영합니다.</span>
        ) : (
          <span>{name} Login필요</span>
        )}
      </div>
    </div>
  );
}

export default UserStatus;
