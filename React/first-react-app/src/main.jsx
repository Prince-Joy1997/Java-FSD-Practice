import React from 'react'
import ReactDOM from 'react-dom/client'
import Features from './components/Features'
import Introduction from './components/Introduction'
import Title from './components/Title'
import './index.css'

const reactFeatures = [ 'How to create and nest components', 'How to add markup and styles','How to display data','How to render conditions and lists',
                        'How to respond to events and update the screen','How to share data between components']

ReactDOM.createRoot(document.getElementById('root')).render(
 
    <>
      <Title></Title>
      <Introduction></Introduction>
      <Features list = {reactFeatures}></Features> 
    </>
)

// function Title(){
//   return(
//     <h1>Welcome to React</h1>
//   )
// }
// function Introduction(){
//   return(
//     <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates inventore veniam rem pariatur nostrum ducimus voluptatem optio quo sed velit qui quam deleniti voluptas ratione ut earum iste suscipit eveniet repellat officia omnis, illo possimus. Animi necessitatibus explicabo in corrupti commodi nisi ipsum laboriosam fugiat incidunt porro vel deserunt molestias illum fugit aut quibusdam alias quisquam reprehenderit eligendi, provident rerum perspiciatis, libero at. Odit laboriosam deserunt veniam tenetur, optio quibusdam, dolorem itaque a labore explicabo excepturi suscipit error dolorum. Debitis id iusto repudiandae nisi molestias suscipit, tenetur natus rerum, ab libero, beatae architecto asperiores numquam ipsum officia omnis? Vero, dolore?</p>
//   )
// }
// function Features(){
//   return(
//     <ul>
//         <li>Fast Library</li>
//         <li>Easy to Learn</li>
//         <li>High Adoption rate</li>
//         <li>Large Community</li>
//       </ul>
//   )
// }

