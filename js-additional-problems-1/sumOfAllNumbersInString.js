const sumOfAllNumbersInString = (str)=>{
    const regex = /\d+/g;
    let matched = str.match(regex);
    let sum = 0;
    if(matched === null){
        return console.log(0);
    }
    else{

        for(i=0;i<matched.length;i++){
            sum+=parseInt(matched[i]);
        }
    }
    return console.log(sum);
}

sumOfAllNumbersInString('hello world') // 0
sumOfAllNumbersInString('hello 1 world 2') // 3
sumOfAllNumbersInString('1hello 1 world 2') // 4
