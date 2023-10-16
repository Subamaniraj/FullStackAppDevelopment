import React, { useEffect, useState } from 'react';
import { UseSelector, useSelector } from 'react-redux/es/hooks/useSelector';
import '../assets/css/FollowersPage.css';

function FollowersPage() {
    const [users, setUsers] = useState([]);
    const [following, setFollowing] = useState([]); // To keep track of followed users
   const [followerId, setFollowerId] = useState(); // Replace yourFollowerId with the actual value

    useEffect(() => {
        // Replace this with your actual API endpoint
        fetch('http://localhost:8222/api/v1/auth/allusers')
            .then((response) => response.json())
            .then((data) => setUsers(data))
            .catch((error) => console.error('Error fetching user data:', error));
    }, []);
    const currentId=localStorage.getItem('id');
    const handleFollow = (userId) => {
        if (!following.includes(userId)) {
            const followingId = userId;
            const followerId=currentId;
            const requestDto = {
                followerId: followerId,
                followingId: followingId,
            };

            // Send a request to follow the user using the new API endpoint
            fetch('http://localhost:8222/api/v1/followers/follow', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(requestDto),
            })
                .then((response) => {
                    if (response.status === 200) {
                        // Successfully followed the user, update the state
                        setFollowing([...following, userId]);
                    } else {
                        // Handle error cases here
                        console.error('Error following user:', response.statusText);
                    }
                })
                .catch((error) => console.error('Error following user:', error));
        }
    };

    return (
        <div>
            <h1>Followers</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Follow</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user) => (
                        <tr key={user.id}>
                            <td>{user.id}</td>
                            <td>{user.name}</td>
                            <td>
                                <button
                                    onClick={() => handleFollow(user.id)}
                                    disabled={following.includes(user.id)}
                                >
                                    {following.includes(user.id) ? 'Following' : 'Follow'}
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default FollowersPage;
