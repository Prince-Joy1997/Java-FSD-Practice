# JS additional problems

## Problem Statements

### The 3n + 1 problem

Consider the following algorithm to generate a sequence of numbers. Start with an integer `n`. If `n` is even, divide by 2. If `n` is odd, multiply by 3 and add 1. Repeat this process with the new value of `n`, terminating when `n` = 1. For example, the following sequence of numbers will be generated for `n` = 22: 
`22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1`

It is conjectured (but not yet proven) that this algorithm will terminate at `n` = 1 for every integer `n`. Still, the conjecture holds for all integers up to at least 1, 000, 000.

### Array of Multiples

Create a function that takes two numbers as arguments `(num, length)` and returns an array of multiples of `num` until the array length reaches `length`.

```js
    arrayOfMultiples(7, 5) ➞ [7, 14, 21, 28, 35]

    arrayOfMultiples(12, 10) ➞ [12, 24, 36, 48, 60, 72, 84, 96, 108, 120]

    arrayOfMultiples(17, 6) ➞ [17, 34, 51, 68, 85, 102]
```

### Special Arrays

An array is special if every even index contains an even number and every odd index contains an odd number. Create a function that returns `true` if an array is special, and `false` otherwise.

```js
    isSpecialArray([2, 7, 4, 9, 6, 1, 6, 3]) ➞ true
    // Even indices: [2, 4, 6, 6]; Odd indices: [7, 9, 1, 3]

    isSpecialArray([2, 7, 9, 1, 6, 1, 6, 3]) ➞ false
    // Index 2 has an odd number 9.

    isSpecialArray([2, 7, 8, 8, 6, 1, 6, 3]) ➞ false
// Index 3 has an even number 8.
```

### Ageing the Population...

Given an object of people and their ages, return how old the people would be after `n` years have passed. Use the absolute value of `n`.

```js
    afterNYears({
    "Joel" : 32,
    "Fred" : 44,
    "Reginald" : 65,
    "Susan" : 33,
    "Julian" : 13
    }, 1) ➞ {
    "Joel" : 33,
    "Fred" : 45,
    "Reginald" : 66,
    "Susan" : 34,
    "Julian" : 14
    }

    afterNYears({
    "Baby" : 2,
    "Child" : 8,
    "Teenager" : 15,
    "Adult" : 25,
    "Elderly" : 71
    }, 19) ➞ {
    "Baby" : 21,
    "Child" : 27,
    "Teenager" : 34,
    "Adult" : 44,
    "Elderly" : 90
    }

    afterNYears({
    "Genie" : 1000,
    "Joe" : 40
    }, 5) ➞ {
    "Genie" : 1005,
    "Joe" : 45
    }
```