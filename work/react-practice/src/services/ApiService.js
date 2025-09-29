import axios from "axios";

// API 서비스용 Axios 인스턴스 생성

const path = process.env.REACT_APP_SPRING_BOOT_URL;

//전역적으로 모든 요청에 withCredentials 적용
axios.defaults.withCredentials = true;
const ApiService = axios.create({
  baseURL: path,
  headers: {
    "Content-Type": "application/json",
  },
});

// 요청 인터셉터: 로컬 스토리지에서 토큰을 가져와 헤더에 추가
ApiService.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

export default ApiService;
