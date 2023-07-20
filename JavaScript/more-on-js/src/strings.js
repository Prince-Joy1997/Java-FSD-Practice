const isPalindrome = (str) => {
    const reversedStr = str.split('').reverse().join('');
    return str === reversedStr;
}

const countVowels = (str) => {
    const vowels = ['a', 'e', 'i', 'o', 'u'];
    const strArr = str.toLowerCase().split('');
    return strArr.filter((char) => vowels.includes(char)).length;
}

const countConsonants = (str) => {
    const consonants = ['b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
        'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'];
    const strArr = str.toLowerCase().split('');
    return strArr.filter((char) => consonants.includes(char)).length;
}

// ESM
export { countVowels, countConsonants }
export default isPalindrome