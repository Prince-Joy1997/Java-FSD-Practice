import isPalindrome, { countConsonants, countVowels } from './src/strings.js'
import Book from './src/book.js';

console.log(isPalindrome('racecar')); // true
console.log(isPalindrome('hello')); // false
console.log(countConsonants('hello')); // 3
console.log(countVowels('hello')); // 2

let animalFarm = new Book('Animal Farm', 'George Orwell', '978-0451526342');
console.log(animalFarm);

let student = {
    name: 'John Doe',
    age: 16,
    gender: 'Male',
    courses: ['English', 'Math', 'Science'],
    address: {
        street: '123 Main St.',
        city: 'Boston',
        state: 'MA'
    }
}
console.log(typeof student); // object
console.log(student);
console.log(student.address);
// John Doe is 16 years old. He/She lives in Boston, MA at 123 Main St.
console.log(`
            ${student.name} is ${student['age']} years old. 
            ${student.gender === 'Male' ? 'He' : 'She'} lives in ${student.address.city}, ${student.address.state} at ${student.address.street}
            `)
for (const prop in student) {
   console.log(`${prop}: ${student[prop]}`);
}
