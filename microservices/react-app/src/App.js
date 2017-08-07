import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {

    function handleClick(e) {
        //ref: https://github.com/facebookincubator/create-react-app/blob/master/packages/react-scripts/template/README.md#adding-temporary-environment-variables-in-your-shell
        let url=process.env.REACT_APP_API_HEALTH
        fetch(url).then(
          res => res.text()).then(
            txt => alert("Health: " + txt)).catch(
              e => alert("Error: " + e))
      }

    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
          <button onClick={handleClick}>
            Request Message
          </button>                
      </div>
    );
  }
}

export default App;
