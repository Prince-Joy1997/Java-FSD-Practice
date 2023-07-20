const numberFormat = function(num){
    let res = "";
    let count = 0;
    let value = num.toString();
    let val1 = value.split(".")[1];
    value = value.split(".")[0];

    for(i = 0; i < value.length; i++){
        if((value.length - i) % 3 == 0 && i != 0){
            res += ",";
        }

        res += value[i];
    }
    
    console.log("$" + res + "." +val1);
}
numberFormat(1234567.89);