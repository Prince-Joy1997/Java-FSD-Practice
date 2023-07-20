import isPrime from '../src/numbers.js'
import { assert } from "chai"

const num1 = 13;
const num2 = 12;

describe('isPrime', () => {
    it('should return true for prime numbers', () => {
        assert.equal(isPrime(num1),true);
    })

    it('should return false for non-prime numbers', () => {
        assert.equal(isPrime(num2),false);
    })
})