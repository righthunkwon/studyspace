// 숫자 자료형
let num1 = 10;
let num2 = 3.14;
let num3 = 1e9; // 1 * 10^9 : 1000000000
let num4 = Infinity;
let num5 = -Infinity;
let num6 = NaN; // Not a Number도 숫자 자료형이다.
let num7 = 0b01000001; // 2진수 binary
let num8 = 0o101; // 8진수 octal
var num9 = 0x41; // 16진수 hex

let numbers = [num1, num2, num3, num4, num5, num6, num7, num8, num9];
for (let i = 0; i < numbers.length; i++) {
    console.log("num" + (i + 1) + ": " + numbers[i]);
}
console.log("-------------------------")
let x = 0.3 - 0.2;
let y = 0.2 - 0.1;
console.log(x == y); // false
console.log(x); // 0.09999999999999998
console.log(y); // 0.1

// 부동소수점은 정수로 바꿔서 계산해야 정확하다.
let a = 0.3;
let b = 0.2;
console.log((a * 10 - b * 10) / 10 == 0.1); // true