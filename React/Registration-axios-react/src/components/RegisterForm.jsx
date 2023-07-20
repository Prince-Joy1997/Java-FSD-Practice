import React from 'react'

const RegisterForm = ({click, change, data}) => {
  return (
    <form>
            <div className="mb-3">
                <h2 className="text-center">Signup for a new account</h2>
            </div>
            <div className="mb-3">
                <label htmlFor="fullName" className="form-label">Full name</label>
                <input type="text"
                    className="form-control"
                    name="fullName"
                    aria-describedby="nameHelp"
                    onChange={change} />
                <div id="nameHelp" className="form-text">Please provide your fullname.</div>
            </div>
            <div className="mb-3">
                <label htmlFor="email" className="form-label">Email address</label>
                <input type="email"
                    className="form-control"
                    name="email"
                    aria-describedby="emailHelp"
                    onChange={change} />
                <div id="emailHelp" className="form-text">Please provide your email.</div>
            </div>
            <div className="mb-3">
                <label htmlFor="password" className="form-label">Password</label>
                <input type="password"
                    className="form-control"
                    name="password"
                    aria-describedby="passHelp"
                    onChange={change} />
                <div id="passHelp" className="form-text">Please provide your password.</div>
            </div>
            <div className="mb-3 form-check">
                <input type="checkbox"
                    className="form-check-input"
                    name="accepted"
                    onChange={change}
                    checked={data.accepted} />
                <label className="form-check-label" htmlFor="accepted">I agree to the terms and conditions</label>
            </div>
            {data.accepted &&
                <button type="button" className="btn btn-primary" onClick={click}>Submit</button>
            }
        </form>

  )
}

export default RegisterForm