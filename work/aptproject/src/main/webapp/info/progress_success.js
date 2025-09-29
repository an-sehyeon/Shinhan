// 연속적인 축포 효과
let duration = 10 * 1000; // 10초간 실행
let animationEnd = Date.now() + duration;
let defaults = { startVelocity: 30, spread: 360, ticks: 60, zIndex: 9999 };

function randomInRange(min, max) {
	return Math.random() * (max - min) + min;
}

let interval = setInterval(function() {
	let timeLeft = animationEnd - Date.now();

	if (timeLeft <= 0) {
		return clearInterval(interval);
	}

	confetti({
		...defaults,
		particleCount: 5,
		origin: {
			x: randomInRange(0.1, 0.3),
			y: Math.random() - 0.2
		}
	});
	confetti({
		...defaults,
		particleCount: 5,
		origin: {
			x: randomInRange(0.7, 0.9),
			y: Math.random() - 0.2
		}
	});
}, 250);