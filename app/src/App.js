import React, { Component } from 'react';
import './App.css';
import Selections from "./components/Selections";

class App extends Component {
  render() {
    return (
      <div>
        <h1>footy predictor</h1>
        <Selections/>
      </div>
    );
  }
}

export default App;
