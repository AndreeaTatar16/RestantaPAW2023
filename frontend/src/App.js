import './App.css';
import Home from "./homepage/home";
import {useEffect} from "react";
import {Route, Routes} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {

  return (
      <Routes>
      <Route path="/" element={<Home/>}/>
      </Routes>
  );
}

export default App;
