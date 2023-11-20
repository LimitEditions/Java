const uuid = require('uuid');
const hello = require ('./hello');
const math = require('alex_math_package');
const id = uuid.v4();
console.log(id);
hello.sayHello();


const addResult = math.add(3, 8);
const subResult = math.subtract(9, 3);

console.log(addResult);
console.log(subResult);