import { Navbar } from "./components/Navbar";
import { Jumbotron } from "./components/Jumbotron";
import { Cards } from "./components/Cards";

import { BrowserRouter, Routes, Route } from "react-router";
import Admin from "./pages/Admin";
import Homepage from "./pages/Homepage";

function App() {
  return (
    <BrowserRouter basename="technofix">
      <Routes>
        <Route path="/admin" element={<Admin />}></Route>
        <Route path="/" element={<Homepage />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
