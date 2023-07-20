const existsHigherNumber = (arr,num) => {
    for(i = 0; i < arr.length; i++){
        if(num <= arr[i]){
            return console.log ("true");
           
        }
    }
    return console.log("false");
}

existsHigherNumber([1, 2, 3, 4, 5], 6)