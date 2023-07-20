const arrayOfMultiples = (num,lgth)=>{

    let res = [];
    for(i=1;i<=lgth;i++){
        res.push(num*i);
    }
    return res;
}

console.log(arrayOfMultiples(7, 5))
console.log(arrayOfMultiples(12, 10))
console.log(arrayOfMultiples(17, 6))