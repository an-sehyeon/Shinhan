import React, { createContext, useState, useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import ApiService from "services/ApiService";

const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  const [user, setUser] = useState(null);
  const [token, setToken] = useState(localStorage.getItem("token"));
  const navigate = useNavigate();

  useEffect(() => {
    const storedUser = localStorage.getItem("user");
    if (token && storedUser) {
      setUser(JSON.parse(storedUser));
    }
  }, [token]);

  const login = async (mid, mpassword) => {
    try {
      const response = await ApiService.post("/login", { mid, mpassword });
      const { token, login } = response.data;
      const userData = { mid: login };
      localStorage.setItem("token", token);
      localStorage.setItem("user", JSON.stringify(userData));
      setToken(token);
      setUser(userData);
      navigate("/");
    } catch (error) {
      console.error("Login failed:", error);
      alert("mid 또는 비밀번호를 확인해주세요.");
    }
  };
  const logout = () => {
    setUser(null);
    setToken(null);
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    navigate("/");
  };
  //자바스크립트에서 truthy/falsy 값을 명확하게 boolean으로 변환할 때 사용하는 방식, user값은 boolean
  const authValue = { user, token, login, logout, isLoggedIn: !!user };
  return (
    <AuthContext.Provider value={authValue}>{children}</AuthContext.Provider>
  );
}
export const useAuth = () => {
  return useContext(AuthContext);
};
