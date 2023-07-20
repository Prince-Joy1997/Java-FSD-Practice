import React from 'react'
import './PasswordGenerator.css'

function PasswordGenerator() {
    

    const [password, setPassword] = React.useState('Click to Generate Password')


    function generate(){

        const upper = 'ZXCVBNMASDFGHJKLQWERTYUIOP'
        const num = '1234567890'
        const special = '!@#$%^&*()'
        const lower = 'qwertyuiopasdfghjklzxcvbnm'
    
        
    
        function getRandomChar(type){
            const random = Math.floor(Math.random()*type.length)
            return type.charAt(random)
        }
    
        const getLower = getRandomChar(lower)
        const getUpper = getRandomChar(upper)
        const getNum = getRandomChar(num)
        const getSpecial = getRandomChar(special)
        let rem = ''

        for(let i = 0; i < 4; i++){
             rem += getRandomChar(getLower + getUpper + getNum + getSpecial)
        }
        
        const pass = getLower + rem + getUpper + getNum + getSpecial
        console.log(pass)
        setPassword(pass)
    }

  return (
   <div className='main'>
       <div>
           <h1>Password Generator</h1>
       </div>
       <div className='textbox'>
           <input type="text" value={password}/>
       </div>
       <div className='button'>
           <button type="submit" onClick={generate}>Generate</button>
       </div>
   </div>
  )
}

export default PasswordGenerator