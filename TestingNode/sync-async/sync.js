const fs = require('fs');

console.log("1");

const res = fs.readFileSync('test.txt', 'utf-8');

console.log(res);

console.log("2");