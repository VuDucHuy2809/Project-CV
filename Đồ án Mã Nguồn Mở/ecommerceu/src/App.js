import React from "react";
import {BrowserRouter as Router} from 'react-router-dom';
import { DataProvider } from "./GlobalState";
import Header from './components/header/Header'
import Footer from "./components/header/Footer";
import Pages from "./components/mainpages/Pages";

function App() {
  return (
    <DataProvider>
      <Router>
        <div className="App">
          <Header></Header>
          <Pages></Pages>
          <Footer></Footer>
        </div>
      </Router>
    </DataProvider>
  );
}

export default App;