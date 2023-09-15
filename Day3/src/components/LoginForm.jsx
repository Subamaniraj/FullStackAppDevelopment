import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../assets/css/App.css'

const LoginForm = () => {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
  });

  const handleOnChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const submitForm = (e) => {
    e.preventDefault();
    console.log(formData); // You can add your login logic here
  };

  return (
    <div className='login-container'>
      <form className="login-form" onSubmit={submitForm}>
        <h2>Login</h2>
        <input
          type="text"
          name="username"
          id="username"
          placeholder="Username"
          value={formData.username}
          onChange={handleOnChange}
        />
        <input
          type="password"
          name="password"
          id="password"
          placeholder="Password"
          value={formData.password}
          onChange={handleOnChange}
        />
        <button type="submit">Login</button>
      <p>
        Don't have an account? <Link to="/signup">Sign Up</Link>
      </p>
      </form>
    </div>
  );
};

export default LoginForm;
