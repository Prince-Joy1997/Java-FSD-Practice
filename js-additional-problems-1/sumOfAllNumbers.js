const sumOfAllNumbers = (arr) => {
    let sum = 0;
    for(i=0;i<arr.length;i++){
        sum += arr[i];
    }
    return console.log(sum);
}

sumOfAllNumbers([1, 2, 3, 4, 5])
sumOfAllNumbers([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])