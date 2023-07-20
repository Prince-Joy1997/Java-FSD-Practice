const x = function oddOrEvenNumber(n){
    if (n % 2 == 0) {
       return "Even";
    }
    else{
        return "Odd";
    }
}

let out = [];
const y = function oddOrEvenArray(arr) {
    for (i = 0; i < arr.length; i++) {
        out.push(x(arr[i]));
    }

    return out;
}

console.log(y([1,2,3,4,5]));
