const readInput = () =>{
    let number = prompt();
  
    inputValidator(number);
    
  }
  
  const inputValidator = (str) =>{
    
    if(checkForConsecutive(str) === true){
      console.log("Given numbers are Consecutive")
    }
    else{
      console.log("Given numbers are not Consecutive")
    }
  
  }
  
  const checkForConsecutive = (str) =>{
    
    let arr = str.split(",").map((ele)=>parseInt(ele)).sort((a,b)=>a-b);
    
    if(((arr.length-1)+arr[0])===arr[arr.length-1]){
      return true;
    }
    else{
      return false;
    }
      
  }
  
  readInput();