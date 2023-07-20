# Java Practice Questions

## Round to millions

Create a java program that will accept a `List` of cities, each city having a name and population, and will return a list that contains the cities rounded to the nearest million. Round down to 0 if the population of a city is below 500,000.

### Requirements

- `City` must be created as a `record`
- `City` will have two properties `cityName` and `population` both of type `String`
- Create a class called `RoundToMillionMain` that will contain the `main` method and the `roundToMillion` method.

### Sample Data

Sample Input

```java
    ["Nice", 942208],
    ["Abu Dhabi", 1482816],
    ["Naples", 2186853],
    ["Vatican City", 572]
```

Sample Output

```java
    ["Nice", 1000000],
    ["Abu Dhabi", 1000000],
    ["Naples", 2000000],
    ["Vatican City", 0]
```

## Numbered Cards

You have a pack of 5 randomly numbered cards, which can range from 0-9. You can win if you can produce a higher two-digit number from your cards than your opponent. Return `true` if your cards win that round. Return `false` if you and your opponent reach the same maximum number (see example #2).

Create a java program to complete this challenge. Create it in a class named `NumberedCards`

### Sample Data

Sample Data

```java
    winRound([2, 5, 2, 6, 9], [3, 7, 3, 1, 2]) 
    // sample 1 returns true
    // Your cards can make the number 96
    // Your opponent can make the number 73
    // You win the round since 96 > 73

    winRound([4, 3, 4, 4, 5], [3, 2, 5, 4, 1])
    // sample 2 returns false
    // both you and your opponent makes the
    // number 54 hence false is returned

    winRound([2, 5, 2, 6, 9], [3, 7, 3, 1, 2])
    // sample 3 return true
    // your cards can make the number 96
    // your opponent can make the number 73

    winRound([1, 2, 3, 4, 5], [9, 8, 7, 6, 5])


```