const fs = require('fs');
const input = fs.readFileSync('in.txt', { encoding: 'utf-8' });
const numbers = input
   .split(' ')
   .map((s) => parseInt(s, 10))

console.log(numbers[0] + numbers[1]);
