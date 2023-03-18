// 숫자와 문자
console.log(123);
console.log('hello');
console.log("hello");
console.log("==========");

// 연산
console.log(5 + 2); // 7
console.log(5 * 2); // 10
console.log(5 / 2); // 2.5
console.log("==========");

// Variable
// (1) const(상수) : 변하지 않는 수, 값 변경 불가
const a = 5;
const b = 2;
console.log(a + b); // 7
console.log(a * b); // 10
console.log(a / b); // 2.5
console.log("==========");

const myName = "kwon";
console.log("hello " + myName);
console.log("==========");
// veryLongVariableName : camelCase
// very_long_variable_name : snake_case


// (2) let : 값 변경 가능
let c = 5;
let d = 2;
console.log(a + b); // 7
console.log(a * b); // 10
console.log(a / b); // 2.5
console.log("==========");

let myNickname = "hippoDev";
console.log("hello " + myNickname);

// const와 달리 let은 값 변경 가능
myNickname = "HTML Programmer";
console.log("hello " + myNickname);


// (3) var : ES5 버전에서 사용하던 변수먕, 변경 가능
// const와 let은 ES6 버전에서 추가
// 기본적으로 const를 쓰고, 필요할 때만 let을 쓰되, var은 쓰지 말 것.
// 항상 const, 가끔 let, 노노 var!