import { Navbar } from "./components/Navbar";
import { Jumbotron } from "./components/Jumbotron";
import { Cards } from "./components/Cards";
import { Hero } from "./components/Hero";

function App() {
  return (
    <>
      <header>
        <Navbar></Navbar>
      </header>
      <main>
        <div className="masthead">
          <div className="overlay">
            <Jumbotron></Jumbotron>
          </div>
        </div>
        <Cards></Cards>
      </main>
    </>
  );
}

export default App;
