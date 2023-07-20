// import React from 'react'
// import './Counter.css'

// class Counter extends React.Component {
//   constructor(props){
//     super(props)

//     this.state = {
//       count : 0
//     }
//   }

//    increment = () => {
//     this.setState(nxt => ({ count: nxt.count + 1 }))
//   }

//   decrement = () => {
//     this.setState(prev => ({ count: prev.count - 1 }))
//   }

//   render(){
//     return(
//       <div>
//         Counter App
//         <div>
//           {this.state.count}
//         </div>
//         <div className="buttons">
//           <button onClick={this.decrement}>-</button>
//           <button onClick={this.increment}>+</button>
//         </div>
//       </div>
//     )
//   }


// }
// export default Counter



import React from 'react'
import './Counter.css'

function Counter() {


  const [counter,setcounter]=React.useState(0);

  function decrement(){
    setcounter(counter - 1)
  }
  function increment(){
    setcounter(counter + 1)
  }
  return (
    <div>
      Counter App
      <div>
        {counter}
      </div>
      <div className="buttons">
        <button onClick={decrement}>-</button>
        <button onClick={increment}>+</button>
      </div>
    </div>
  )
}

export default Counter