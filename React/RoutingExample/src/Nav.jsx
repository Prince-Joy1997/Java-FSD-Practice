import React from 'react'
import { Link } from 'react-router-dom'
import './App.css'

function Nav() {
  return (
    <div>
        <nav>
            <p><Link to="/">Home</Link></p>
            <p><Link to="/about">About</Link></p>
        </nav>
    </div>
  )
}

export default Nav