import React from 'react'
import './Login.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import {ThemeContext} from './ThemeContext'


function Login() {

    const {textColor, setTextColor,bgColor, setBgColor} = React.useContext(ThemeContext);

    return (
        <div className={`container border border-dark p-3 mt-5 bg-${bgColor} text-${textColor}`}>
            <h2 >Login Page</h2>
            <form>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email:</label>
                    <input type="email" id="email" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password:</label>
                    <input type="password" id="password" className="form-control" required />
                </div>
                <button type="submit" className="btn btn-primary">Login</button>
                <button type="button" className="btn btn-primary" onClick={() =>{
                    if(textColor == 'dark'){
                        setBgColor('dark');
                        setTextColor('light');
                    }
                    else{
                        setBgColor('light');
                        setTextColor('dark');
                    }
                }}>Change</button>
            </form>
        </div>
    )
}

export default Login