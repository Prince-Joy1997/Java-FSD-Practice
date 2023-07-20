const customOperation = (num1,num2,optr)=>{
    let result = 0;
    switch(optr){
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            result = num1 / num2;
            break;
        case '%':
            result = num1 % num2;
            break;
        default:
            console.log("Wrong Expression");
    }

    return console.log(result);
}


customOperation(5, 10, '+') // 15
customOperation(10, 5, '-') // 5
customOperation(5, 10, '*') // 50
customOperation(10, 5, '/') // 2
customOperation(10, 5, '%') // 0
