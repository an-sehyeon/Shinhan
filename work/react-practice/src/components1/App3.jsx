import React from "react";
import Header from "components1/Header";
import Body from "components1/Body";
import Footer from "components1/Footer";
import RenderingTest from "components1/RenderingTest";
import UserStatus from "components1/UserStatus";
import multiply, { PI, add, substract } from "utils/math";

function App3(props) {
  console.log(PI);
  console.log(add(1, 2));
  console.log(substract(3, 4));
  console.log(multiply(5, 6));

  //환경변수에 접근하기
  console.log("publuc URL :" + process.env.PUBLIC_URL);
  console.log("REACT_APP_CHANNEL_ID :" + process.env.REACT_APP_CHANNEL_ID);
  console.log("REACT_APP_IMAGE_PATH :" + process.env.REACT_APP_IMAGE_PATH);
  console.log("REACT_APP_SPRING_URL :" + process.env.REACT_APP_SPRING_URL);

  return (
    <React.Fragment>
      {/* React.Fragment는 실제로 태그가 만들어지지않음. 즉 빈Tag와 같다 */}

      <Header />
      <Body></Body>
      <UserStatus isLoggin={true} name="바다"></UserStatus>
      <RenderingTest message="렌더링연습"></RenderingTest>
      <Footer></Footer>
    </React.Fragment>
  );
}

export default App3;
