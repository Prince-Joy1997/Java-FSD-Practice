
let orderArray = '[{"pId": 1200,"unitCost": 50,"Quantity": 2},{"pId": 1232,"unitCost": 30,"Quantity": 4}]'

function finalPrice(orderArray){
    // code here
    let result = 0;
    let tot = JSON.parse(orderArray);
    
    for(let i = 0; i < tot.length ; i++) {
        let price = tot[i];
        // console.log(price);
        result = result + price.unitCost * price.Quantity;
    }
    return result;   
}

console.log(finalPrice(orderArray))
