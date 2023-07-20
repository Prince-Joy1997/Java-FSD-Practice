import React from 'react'
import Content from './Content'

function Navbar() {
  return (
    <main>
        <div className='nav'>
            <div className='left'>
                <img src="src\assets\image.png" alt="logo" />
                <p className='logo'>ReactFacts</p>
            </div>
            <div className='right'>
                <p>React Course - Project 1</p>
            </div>
        </div>
        <Content></Content>
    </main>    
  )
}

export default Navbar