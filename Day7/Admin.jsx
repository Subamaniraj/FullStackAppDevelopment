// Dashboard.js

import React from 'react';
import { Bar } from 'react-chartjs-2';

const Dashboard = () => {
  // Sample data for the chart
  const chartData = {
    labels: ['January', 'February', 'March', 'April', 'May'],
    datasets: [
      {
        label: 'Projects Completed',
        data: [12, 19, 3, 5, 2],
        backgroundColor: 'rgba(75, 192, 192, 0.2)',
        borderColor: 'rgba(75, 192, 192, 1)',
        borderWidth: 1,
      },
    ],
  };

  // Sample data for the latest projects
  const latestProjects = [
    { name: 'Project 1', status: 'Completed' },
    { name: 'Project 2', status: 'In Progress' },
    { name: 'Project 3', status: 'Completed' },
    { name: 'Project 4', status: 'Pending' },
  ];

  return (
    <div className="dashboard">
      <h1>Welcome to ArtNest Admin Dashboard</h1>

      <div className="chart-container">
        <h2>Projects Overview</h2>
        <Bar data={chartData} />
      </div>

      <div className="latest-projects">
        <h2>Latest Projects</h2>
        <ul>
          {latestProjects.map((project, index) => (
            <li key={index}>
              {project.name} - <span className={project.status.toLowerCase()}>{project.status}</span>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default Dashboard;
