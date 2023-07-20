# js-order-processing

You’re writing the business logic for an online e-commerce company to calculate the final pricing during shopping checkout. You’re given an array of JSON objects representing an order containing pId, unitCost and Quantity. You need to calculate the total payable amount.

```js
For example, for below order as JSON object output shall be 110.

    [
        {pId: 2312, unitCost: 30, Quantity: 3},
        {pId: 3312, unitCost: 10, Quantity: 2}
    ]
```

Create the finalPrice function that will accept an array of orders and return the total cost of all the items.

|   Name|Type  	|Description	|
|---	|---	|---	|
|   orderArray	|  STRING ARRAY 	|  The array of JSON object orders as a string 	|

