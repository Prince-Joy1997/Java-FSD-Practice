import React from 'react'
import './RockPaperScissor.css'

function RockPaperScissor() {

    const [userScore, setUserScore] = React.useState(0)
    const [computerScore, setComputerScore] = React.useState(0)
    const [noResult, setNoResult] = React.useState(0)
    const [message, setMessage] = React.useState('Lets Start the Play !!!!')
    const [messageStyle, setMessageStyle] = React.useState({
        color: 'Blue'
    })
    const [counter,setCounter] = React.useState(0)

    function computerChoice(){
        const options = ['R', 'P', 'S']
        const random = Math.floor(Math.random()*3)
        return options[random]
    }

    function play(userChoice){
        console.log(counter)
        if(counter<11){
        const machineChoice = computerChoice()
        const result = machineChoice + userChoice

        switch(result){
            case 'RS':
            case 'SP':
            case 'PR':
                console.log("Machine wins")
                setComputerScore(computerScore+1)
                setMessage('Computer Wins !!!')
                setMessageStyle({color:'Red'})
                setCounter(counter+1)
                break;
            case 'PS':
            case 'RP':
            case 'SR':
                console.log("User Wins")
                setUserScore(userScore+1)
                setMessage('User Wins !!!')
                setMessageStyle({color:'Green'})
                setCounter(counter+1)
                break;
            default:
                console.log("Draw")
                setNoResult(noResult+1)
                setMessage('Draw !!!')
                setMessageStyle({color:'Yellow'})
                setCounter(counter+1)
        }
    }
    }

  return (
    <div className='rps'>
        <h1>ROCK PAPER SCISSORS</h1>
        <div className='options'>
            <button onClick={() => play('R')}>
                <img src="src\assets\icon-rock.svg" alt="rock" />
            </button>
            <button onClick={() => play('P')}>
                <img src="src\assets\icon-paper.svg" alt="paper" />
            </button>
            <button onClick={() => play('S')}>
                <img src="src\assets\icon-scissors.svg" alt="scissors" />
            </button>
        </div>

        <div className='scores'>
            <div className='user'>
                <h2>User</h2>
                <span>{userScore}</span>
            </div>
            <div className='draw'>
                <h2>Draw</h2>
                <span>{noResult}</span>
            </div>
            <div className='computer'>
                <h2>Computer</h2>
                <span>{computerScore}</span>
            </div>
        </div>
        <div className='message'>
            <span style={messageStyle}>{message}</span>
        </div>
    </div>
  )
}

export default RockPaperScissor