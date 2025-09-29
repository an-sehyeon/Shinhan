const canvas = document.getElementById("lightCanvas");
const ctx = canvas.getContext("2d");

function resizeCanvas() {
  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;
}
resizeCanvas();

const particles = [];
const particleCount = 100;

// 초기 입자 설정
for (let i = 0; i < particleCount; i++) {
  particles.push({
    x: Math.random() * canvas.width,
    y: Math.random() * canvas.height,
    r: Math.random() * 2 + 1,
    d: Math.random() * particleCount
  });
}

let angle = 0;

function drawParticles() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  ctx.fillStyle = "rgba(255, 255, 255, 0.6)";
  ctx.shadowColor = "#ffffff";
  ctx.shadowBlur = 10;

  for (let i = 0; i < particleCount; i++) {
    const p = particles[i];
    ctx.beginPath();
    ctx.arc(p.x, p.y, p.r, 0, Math.PI * 2, true);
    ctx.fill();
  }

  updateParticles();
}

function updateParticles() {
  angle += 0.001;
  for (let i = 0; i < particleCount; i++) {
    const p = particles[i];
    p.y += Math.cos(angle + p.d) + 0.5;
    p.x += Math.sin(angle) * 0.3;

    if (p.y > canvas.height) {
      p.y = 0;
      p.x = Math.random() * canvas.width;
    }
  }
}

setInterval(drawParticles, 30);

window.addEventListener("resize", resizeCanvas);
