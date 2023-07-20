import React from 'react'



function Features(props) {
  const styles={
    fontWeight:"bolder"
  }
  return (
    <div id='features'>
        <h2>You will learn</h2>
        <ul>
          
          {props.list.map((item,index) => <li key = {index} style = {styles}>{item}</li>)}
            {/* <li>How to create and nest components</li>
            <li>How to add markup and styles</li>
            <li>How to display data</li>
            <li>How to render conditions and lists</li>
            <li>How to respond to events and update the screen</li>
            <li>How to share data between components</li> */}
        </ul>
    </div>
  )
}

export default Features