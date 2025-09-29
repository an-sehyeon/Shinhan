<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>낙첨자 페이지</title>
<link rel="stylesheet" type="text/css" href="${cpath}/lottoresult/losingpage.css">
</head>
<body>
  <canvas id="rainCanvas"></canvas>
  <div class="message">
  	<br><br><br><br><br><br>
    <h1>아쉽지만 ${office.name}님은 당첨에 실패하셨습니다.</h1>
    <p>아쉽지만 다음 기회를 노리세요.</p>
    <br>
    <c:set var="rankDiff" value="${office.area_rank - 30}"/>
    <p>현재 ${office.name}님의 예비순위는 ${rankDiff}번입니다.</p>
    <br><br><br><br><br><br>
    <button class="losingbtn" style="vertical-align:middle" onclick="location.href='${cpath}/mainpage'"><span>나가기 </span></button>
    <br><br><br><br><br><br><br><br>
  </div>

  <script>
    const canvas = document.getElementById('rainCanvas');
    const ctx = canvas.getContext('2d');

    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    const raindrops = [];
    const maxDrops = 500;

    for (let i = 0; i < maxDrops; i++) {
      raindrops.push({
        x: Math.random() * canvas.width,
        y: Math.random() * canvas.height,
        length: Math.random() * 20 + 10,
        opacity: Math.random(),
        speed: Math.random() * 5 + 2
      });
    }

    function drawRain() {
      ctx.clearRect(0, 0, canvas.width, canvas.height);
      ctx.strokeStyle = 'rgba(174,194,224,0.5)';
      ctx.lineWidth = 1;
      ctx.lineCap = 'round';

      for (let i = 0; i < raindrops.length; i++) {
        const drop = raindrops[i];
        ctx.beginPath();
        ctx.moveTo(drop.x, drop.y);
        ctx.lineTo(drop.x, drop.y + drop.length);
        ctx.stroke();

        drop.y += drop.speed;
        if (drop.y > canvas.height) {
          drop.y = -drop.length;
          drop.x = Math.random() * canvas.width;
        }
      }

      requestAnimationFrame(drawRain);
    }

    drawRain();

    window.addEventListener('resize', () => {
      canvas.width = window.innerWidth;
      canvas.height = window.innerHeight;
    });
  </script>
</body>
</html>
</html>