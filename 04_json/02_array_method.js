// Array Method (map, filter, ...)
let arr = [1, 2, 3, 4];
let newArr = arr.map((num) => num * 2);
console.log(arr); // (4) [1, 2, 3, 4]
console.log(newArr); // (4) [2, 4, 6, 8]

// newArr은 하단의 코드와 동일
// let newArr = arr.map(function (num) {
//     return num * 2;
// });


let filterArr = arr.filter((num) => num % 2 === 0);
console.log(arr); // (4) [1, 2, 3, 4]
console.log(filterArr); // (2) [2, 4]

// 자료형
let num1 = '123';
console.log(typeof num1); // string

num1++;
console.log(typeof num1); // number

let num2 = '123';
console.log(typeof num2); // string
console.log(typeof +num2); // number