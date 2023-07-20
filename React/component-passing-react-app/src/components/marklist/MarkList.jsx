import React from 'react'

function MarkList(props) {
  return (
    <table border="1" className='MarkTable'>  
   <thead>  
       <tr>  
        <th>Name</th>  
        <th>Age</th>  
        <th>Marks</th>     
       </tr>  
   </thead>  
 <tbody>  
     {
         props.list.map((item,index) => 
         <tr key = {index}>  
        <td>{item.name}</td>  
        <td>{item.age}</td>     
        <td>{item.marks}</td>  
      </tr>)
     }
      {/* <tr>  
        <td>121</td>  
        <td>John</td>  
        <td>john123@gmail.com</td>  
      </tr>        */}
   </tbody>  
</table>  
  )
}

export default MarkList