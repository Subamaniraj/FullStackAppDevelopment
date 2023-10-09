import React from 'react';
import '../assets/css/Home.css';
import img1 from '../assets/images/Best-Online-Collaboration-Tools.jpg';
import img2 from '../assets/images/createart.jpg';
import img3 from '../assets/images/showcase.jpg';
import img4 from '../assets/images/connect.jpg';

const Home = () => {
  return (
    <div className="home">
      <section className="hero">
        <div className="hero-content">
          <h1 className="hero-title">Welcome to ArtNest</h1>
          <p className="hero-subtitle">An Online Artistic Collaboration Platform</p>
          <button className="btn hero-btn">Get Started</button>
        </div>
        <img src={img1} alt="Artistic Collaboration" className="hero-image" />
      </section>

      <section className="features">
        <div className="feature">
          <img src={img2} alt="Feature 1" className="feature-image" />
          <h2 className="feature-title">Create Art Together</h2>
          <p className="feature-description">Collaborate with artists worldwide on creative projects.</p>
        </div>
        <div className="feature">
          <img src={img3} alt="Feature 2" className="feature-image" />
          <h2 className="feature-title">Showcase Your Work</h2>
          <p className="feature-description">Display your art portfolio and gain recognition.</p>
        </div>
        <div className="feature">
          <img src={img4} alt="Feature 3" className="feature-image" />
          <h2 className="feature-title">Connect with Artists</h2>
          <p className="feature-description">Connect, chat, and exchange ideas with fellow artists.</p>
        </div>
      </section>
    </div>
  );
};

export default Home;
