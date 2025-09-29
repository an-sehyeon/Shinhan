import React from "react";
import { Link, Route, Routes } from "react-router-dom";
import KeyList from "review/KeyList";
import ParentComponent1 from "review/ParentComponent1";
import AppCSR from "review/AppCSR";
import TodoListUsingReducerApp from "project2/TodoListUsingReducerApp";
import VarCompare from "components2/VarCompare";
import CounterReducerTest from "components3/CounterReducerTest";
import { Container, Nav, Navbar } from "react-bootstrap";
import NotFoundPage from "review/NotFoundPage";
import HomePage from "./HomePage";
import CounterApp from "components2/CounterApp";
import Counter from "components2/Counter";
import EmpListPage from "emp/EmpListPage";
import EmpDetailPage from "emp/EmpDetailPage";
import EmpInsertPage from "emp/EmpInsertPage";
import EmpLayout from "emp/EmpLayout";
import AppDiary from "project3Edu/components/AppDiary";
import APITest from "emp/APITest";
import EmpDeletePage from "emp/EmpDeletePage";

function AppRoutes(props) {
  const ulStyle = {
    listStyle: "none",
    padding: 0,
    display: "flex",
    gap: "20px",
  };

  return (
    <div>
      <ul style={ulStyle}>
        <li>
          <Link to="/parent">parent이동</Link>
        </li>
        <li>
          <Link to="/todo">todo이동</Link>
        </li>
        <li>
          <Link to="/mydiary">diary이동</Link>
        </li>
      </ul>

      <Navbar bg="primary" data-bs-theme="dark" className="mb-3">
        <Container>
          <Navbar.Brand href="/">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link as={Link} to="/parent">
              parent/child
            </Nav.Link>
            <Nav.Link as={Link} to="/todo">
              todo
            </Nav.Link>
            <Nav.Link as={Link} to="/key">
              Key!!
            </Nav.Link>
            <Nav.Link as={Link} to="/counter1">
              counter
            </Nav.Link>
            <Nav.Link as={Link} to="/counter2">
              counter2
            </Nav.Link>
            <Nav.Link as={Link} to="/emp">
              EMP(Axios이용)
            </Nav.Link>
            <Nav.Link as={Link} to="/mydiary">
              diary
            </Nav.Link>
            <Nav.Link as={Link} to="/api">
              API
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/key" element={<KeyList />} />
        <Route path="/counter1" element={<CounterApp />} />
        <Route path="/counter2" element={<Counter />} />
        <Route path="/parent" element={<ParentComponent1 />} />
        <Route path="/csr" element={<AppCSR />} />
        <Route path="/todo" element={<TodoListUsingReducerApp />} />
        <Route path="/compare" element={<VarCompare />} />
        <Route path="/reducer" element={<CounterReducerTest />} />

        <Route path="/mydiary/*" element={<AppDiary />} />

        <Route path="/emp" element={<EmpLayout />}>
          <Route path="list" element={<EmpListPage />} />
          <Route path="detail/:empid" element={<EmpDetailPage />} />
          <Route path="insert" element={<EmpInsertPage />} />
          <Route path="delete/:empid" element={<EmpDeletePage />} />
        </Route>
        <Route path="/api" element={<APITest />} />

        <Route path="*" element={<NotFoundPage />} />
      </Routes>
    </div>
  );
}

export default AppRoutes;
