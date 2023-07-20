const isStrPresent = (str1, str2) =>{
    if(str1.includes(str2)){
        return true;
    }
    return false;
}

console.log(isStrPresent("Hello, world!", "Hello"))
console.log(isStrPresent("Hello, world!", "hey"))
