import React from 'react'

class Clock extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            message : props.heading,
            date : new Date()
        }
    }

    updateClock(){
        this.setState({date : new Date()})
    }


    componentDidMount(){
        this.timerID = setInterval(() => 
            this.updateClock(), 1000);
        }
    

    componentWillUnmount(){
        clearInterval(this.timerID)
    }

    render(){
        return(
            <main>
                <h3>{this.state.message}</h3>
                <h2>{this.state.date.toLocaleTimeString("en-US")}</h2>
            </main>
        )
    }
}

export default Clock