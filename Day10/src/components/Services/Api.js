import axios from 'axios'
import react from 'react'

const uri='http://localhost:8181'
const authHeader=localStorage.getItem('token')
const headers={
    'Authorization':`Bearer ${authHeader}`,
    'Content-Type':'application/json'
}

//Authentication
export const login=(data)=> axios.post(`${uri}/api/v1/auth/authenticate`, data);
export const register=(data)=>axios.post(`${uri}/api/v1/auth/register`,data);

//Artwork
export const getArtwork=()=>axios.post(`${uri}/api/v1/artwork/allartworks`,headers);
//export const postArtwork=()=>axios.post(`${uri}/api/v1/artwork/saveartwork`,data,headers);
export const updateartwork=(id,data)=>axios.put(`${uri}/api/v1/artwork/updateartwork/${id}`,data,headers);
