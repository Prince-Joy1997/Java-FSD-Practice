import React from 'react'
import './Login.css'

function Login() {

    const [username, setUserName] = React.useState('username')
    const [password, setPassword] = React.useState('password')

    const [formData, setFormData] = React.useState({
        'username': 'username',
        'password': 'password',
        'gender': 'Male',
        'isRobot': false
    })

    function login() {
        console.log('login')
    }

    function valueChange(event) {

        const { name, value, type, checked } = event.target

        // if(event.target.name == 'username'){
        //     setUserName(event.target.value)
        // }
        // else if(event.target.name == 'password'){
        //     setPassword(event.target.value)
        // }

        setFormData(prevData => {
            return {
                ...prevData,
                [name]: type === 'checkbox' ? checked : value
                // [event.target.name] : event.target.value
            }
        })
    }

    return (
        <form className="main">
            <h1>Login</h1>
            <div className="mb-3">
                <label className="form-label">Username</label>
                <input type="text" className="form-control" name='username' onChange={valueChange} value={formData.username} />

            </div>
            <div className="mb-3">
                <label className="form-label">Password</label>
                <input type="password" className="form-control" name='password' onChange={valueChange} value={formData.password} />

            </div>
            <div className="form-check">
                <input className="form-check-input" type="radio" name="gender" value="Male"
                    onChange={valueChange} checked={formData.gender === 'Male'} />
                <label className="form-check-label" htmlFor="gender">
                    Male
                </label>
            </div>
            <div className="form-check">
                <input className="form-check-input" type="radio" name="gender" value="Female"
                    onChange={valueChange} checked={formData.gender === 'Female'} />
                <label className="form-check-label" htmlFor="gender">
                    Female
                </label>
            </div>
            <div className='form-check p-2'>
                <input type="checkbox" name="isRobot" id='checkbox' checked={formData.isRobot} onChange={valueChange} />
                <label htmlFor="checkbox">I am Not a ROBOT</label>
            </div>
            {formData.isRobot &&
                <button type="submit" className="btn btn-primary" onClick={login}>LogIn</button>
            }

            <p>username : {formData.username}</p>
            <p>password : {formData.password}</p>
            <p>gender : {formData.gender}</p>
        </form>
    )
}

export default Login