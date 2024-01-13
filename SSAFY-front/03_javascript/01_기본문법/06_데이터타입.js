// js의 데이터
let num1 = 10;
let num2 = 10.2;
let msg = "hi";
let bool = true;
let nullVal = null;
let unVal;
let obj = {};
let obj2 = new Object();
let symbol = Symbol();

console.log(num1); // 10
console.log(num2); // 10.2
console.log(msg); // hi
console.log(bool); // true
console.log(nullVal); // null
console.log(unVal); // undefined
console.log(obj); // {}
console.log(obj2); // {}
console.log(symbol); // Symbol()

console.log('-----------------')

// js의 데이터 타입 확인: typeof 변수명
let a = "haha";
console.log(typeof a); // string
a = 123;
console.log(typeof a); // number
a = false;
console.log(typeof a); // boolean
a = {
  a: 123,
};
console.log(typeof a); // object
a = [1, 2, 3, 4];
console.log(typeof a); // object
a = null;
console.log(typeof a); // object
a = undefined;
console.log(typeof a); // undefined

// undefined는 undefined 타입이지만 null은 object 타입이다.
// typeof null이 object로 나오는 건 설계에서의 실수이다.
// js의 변수 타입은 현재 가진 값으로 바뀐다(동적 타입).