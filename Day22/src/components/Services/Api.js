import axios from 'axios';

const BASE_URL = 'http://localhost:8222'; // Replace with your backend URL
const token = localStorage.getItem('token');
const headers = {
  'Authorization': `Bearer ${token}`,
  'Content-Type': 'application/json',
};

// Authentication
export const Userlogin = (data) => axios.post(`${BASE_URL}/api/v1/auth/authenticate`, data);
export const userRegister = (data) => axios.post(`${BASE_URL}/api/v1/auth/register`, data);

// Get all followers
export const getAllFollowers = () => axios.get(`${BASE_URL}/api/followers`, { headers });

// Toggle follow
export const toggleFollow = (id) => axios.put(`${BASE_URL}/api/followers/${id}/toggle-follow`, null, { headers });
