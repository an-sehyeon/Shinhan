import React from "react";
import ReactDOM from "react-dom/client";
import "index.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter } from "react-router-dom";

import AppRoutes from "review/AppRoutes";
import ErrorBoundary from "components4Final/ErrorBoundary";
import { AuthProvider } from "board/AuthContext";
import App from "App";

const root = ReactDOM.createRoot(document.getElementById("root"));
//basename="/"
root.render(
  <>
    {/* <ErrorBoundary>
      <BrowserRouter>
        <AppRoutes />
      </BrowserRouter>
    </ErrorBoundary> */}

    <ErrorBoundary>
      <BrowserRouter>
        <AuthProvider>
          <App></App>
        </AuthProvider>
      </BrowserRouter>
    </ErrorBoundary>
  </>
);
