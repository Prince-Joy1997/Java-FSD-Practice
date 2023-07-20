import isPalindrome, { countConsonants, countVowels } from '../src/strings.js'
import { assert } from "chai"

const str1 = "racecar"
const str2 = "hello"

describe('test cases for isPalindrome', () => {

    it('should return true if string is a palindrome', () => {
        assert.equal(isPalindrome(str1), true)
    })

    it('should return false if string is not a palindrome', () => {
        assert.equal(isPalindrome(str2), false)
    })
})

describe('test cases for countVowels', () => {

    it('should return the number of vowels in a string', () => {
        assert.equal(countVowels(str2), 2)
    })

    it('should return 0 if there are no vowels in a string', () => {
        assert.equal(countVowels('str1'), 0)
    })
})

describe('test cases for countConsonants', () => {

    it('should return the number of consonants in a string', () => {
        assert.equal(countConsonants(str2), 3)
    })

    it('should return 0 if there are no consonants in a string', () => {
        assert.equal(countConsonants('aeiou'), 0)
    })
})
