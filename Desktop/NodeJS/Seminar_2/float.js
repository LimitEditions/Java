const colors = require('colors');
const { calculateResultSum } = require('./calculateResultSum');
const total = calculateResultSum([ 12.2, 43.1], 0.9);


if (total >= 50) {
    console.log(colors.green("Общая стоимость покупок: " + total + " рублей"));
}
else {
    console.log(colors.red("Общая стоимость покупок: " + total + " рублей"));
}