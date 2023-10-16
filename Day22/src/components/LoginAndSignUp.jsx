import * as React from 'react'
import { useState } from 'react'
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import '../assets/css/loginAndSignUp.css'
import { useDispatch } from 'react-redux';
import { Login } from './Redux/UserSlice';
import {BsFillPersonFill} from 'react-icons/bs'
import { useUser } from './context/UserContext';
import { Userlogin } from './Services/Api';

const LoginAndSignUp=()=>{
    const navigate = useNavigate();
    const {login: userLogin}=useUser();
    const [isFlipped, setIsFlipped] = useState(false);

    const flipForm = () => {
        setIsFlipped(!isFlipped);
    };
    const dispatch=useDispatch();

    const[loginFormData,setLoginFormData]=React.useState({
        name:"",
        pwd:""
    })
    const[signUpFormData,setSignUpFormData]=React.useState({
        email:"",
        newName:"",
        newPwd:""
    })

    
    const handleLoginFormChange=(e)=>{
        const [name,value]=[e.target.name,e.target.value];
        setLoginFormData({
            ...loginFormData,
            [name]: value
        })
    }
    
    const handleSignUpFormChange=(e)=>{
        const [name,value]=[e.target.name,e.target.value];
        setSignUpFormData({
            ...signUpFormData,
            [name]: value
        })
    }

    const submitLoginForm = async (e) => {
        e.preventDefault();
        if(!loginFormData.name || !loginFormData.pwd){
            console.log("Please enter details");
        }
        else {
            try{
            const res=await Userlogin(loginFormData).then((response)=>{
        const token=response.data.token;
        const id=response.data.id;
        localStorage.setItem('token',token);
        localStorage.setItem('id',id);
        
            });
            navigate('/HomePage ');
            userLogin();
        dispatch(Login({ 
            name:loginFormData.name,
            pwd: loginFormData.pwd
        }));
    }
    catch (err){
        console.error(err);
    }
    }
        if(loginFormData.name=="Admin"||loginFormData.name=="admin"){

            navigate('/BarChart');
            userLogin();
        }
      }

    const submitSignUpForm = (e) => 
    {
       e.preventDefault();
        console.log(signUpFormData);
    }
    
    return(
        <div className='loginAndSignUpPage'>
            <div className={`forms-container ${isFlipped ? 'flipped' : ''}`}>
                <div className='form-box login'>
                    <h1>Login</h1>
                    <BsFillPersonFill className='user-icon'></BsFillPersonFill>
                    <form onSubmit={submitLoginForm} className='loginForm'>
                        <div className='name'>
                            <input type="text" name="name" id="name" placeholder='username' autoComplete="current-username" onChange={handleLoginFormChange}/>
                        </div>
                        <div className='pwd'>
                            <input type="password" name="pwd" id="pwd" placeholder="password" autoComplete="current-password" onChange={handleLoginFormChange}/>
                        </div>
                        <div className='loginButton'>
                            <button className='login-button' type="submit">Login</button>
                        </div> 
                        <Link to="#" onClick={flipForm} className='linkText'>If you don't have an account? Sign Up</Link>                   
                    </form>
                </div>
            <div className='form-box signup'>
                <h1>SignUp</h1>
                    <BsFillPersonFill className='user-icon'></BsFillPersonFill>
                <form onSubmit={submitSignUpForm} className='signUpForm'>
                    <div className='email'>
                        <input type='email' name='email' id='email' placeholder='email' onChange={handleSignUpFormChange}></input>
                    </div>
                    <div className='newName'>
                        
                        <input type="text" name="newName" id="newName" placeholder='username' autoComplete="current-username"    onChange={handleSignUpFormChange}/>
                    </div>
                    <div className='newPwd'>
                        <input type="password" name="newPwd" id="newPwd" placeholder="password" autoComplete="current-password" onChange={handleSignUpFormChange}/>
                    </div>
                    <div className='signUpButton'>
                        <button className='login-button' type="submit">SignUp</button>
                    </div>
                    <Link to="#" onClick={flipForm} className='linkText'>If you have an account? Login</Link>
                </form>
            </div>
            </div>
        </div>
    )
}
export default LoginAndSignUp;