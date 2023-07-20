# JS additional problems

## Problem Statements

### Exists a higher number

Write a function that accepts an array and a number `n` and returns `true` if there exists at least one number that is larger than or equal to `n`. Save the file as `existsHigherNumber.js`.

```js
    existsHigherNumber([1, 2, 3, 4, 5], 3) // true
    existsHigherNumber([1, 2, 3, 4, 5], 6) // false
```

### Sum of all numbers

Write a function that accepts an array of numbers and returns the sum of all numbers. Save the file as `sumOfAllNumbers.js`.

```js
    sumOfAllNumbers([1, 2, 3, 4, 5]) // 15
    sumOfAllNumbers([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]) // 55
```

### Sum of all even numbers

Write a function that accepts an array of numbers and returns the sum of all even numbers. Save the file as `sumOfAllEvenNumbers.js`.

```js
    sumOfAllEvenNumbers([1, 2, 3, 4, 5]) // 6
    sumOfAllEvenNumbers([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]) // 30
```

### Shortest word

Write a function that accepts an array of words and returns the shortest word. Save the file as `shortestWord.js`.

```js
    shortestWord(['hello', 'world', 'this', 'is', 'a', 'test']) // 'a'
    shortestWord(['hello', 'world', 'this', 'is', 'a', 'test', 'of', 'the', 'shortest', 'word']) // 'of'
```

### Shuffle names

Create a method that accepts a string (of a person's first and last name) and returns a string with the first and last name swapped. Save the file as `shuffleNames.js`.

```js
    shuffleNames('Donald Trump') // 'Trump, Donald'
    shuffleNames('Rosie O'Donnell') // 'O'Donnell, Rosie'
```

### Many Operators

Write a function that accepts two numbers and returns the result of the first number multiplied by the second number, divided by the first number, and then subtracted by the second number. Save the file as `manyOperators.js`.

```js
    manyOperators(5, 10) // 5
    manyOperators(10, 5) // 0
```

### Custom operation

Some basic arithmetic operators are `+`, `-`, `*`, `/`, and `%`. In this challenge you will be given three parameters, `num1`, `num2`, and an operator. Use the operator on parameters `num1` and `num2`. Save the file as `customOperation.js`.

```js
    customOperation(5, 10, '+') // 15
    customOperation(10, 5, '-') // 5
    customOperation(5, 10, '*') // 50
    customOperation(10, 5, '/') // 2
    customOperation(10, 5, '%') // 0
```

### Sum of all numbers in a string

Write a function that accepts a string and returns the sum of all numbers in the string. Save the file as `sumOfAllNumbersInString.js`.

```js
    sumOfAllNumbersInString('hello world') // 0
    sumOfAllNumbersInString('hello 1 world 2') // 3
    sumOfAllNumbersInString('1hello 1 world 2') // 4
```

### Get Sum of People's Budget

Create the function that takes an array with objects and returns the sum of people's budgets. Save the file as `getSumOfPeopleBudget.js`.

```js
    getSumOfPeopleBudget([
      { name: "John", age: 21, budget: 23000 },
      { name: "Steve", age: 32, budget: 40000 },
      { name: "Martin", age: 16, budget: 2700 }
    ]) // 65700
    getSumOfPeopleBudget([
      { name: "John", age: 21, budget: 29000 },
      { name: "Steve", age: 32, budget: 32000 },
      { name: "Martin", age: 16, budget: 1600 }
    ]) // 62600
```