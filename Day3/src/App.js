import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginForm from './components/LoginForm'; 
import Signup from './components/Signup'; 

const App = () => {
  return (
    <Router>
      
      <div className="App">
        <Routes>
          <Route exact path="/" element=<LoginForm/> />
          <Route path="/signup" element=<Signup/> />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
