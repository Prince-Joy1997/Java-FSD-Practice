const sequenceOfNumbers = (n)=>{
    let arr=[];
    arr.push(n);

        while(n!=1){
            if(n%2===0){
                n=n/2;
                arr.push(n);
                
            }
            else{
                n = n*3 + 1;
                arr.push(n);
            }
        }
    
         console.log(arr);
    }
    
sequenceOfNumbers(22);