const fs = require("fs");

console.log("1");

fs.readFile("test.txt", (error, data) => console.log(data.toString()));

console.log("2");
