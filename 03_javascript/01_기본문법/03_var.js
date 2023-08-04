/* var */
console.log(bottom); // 호이스팅 때문에 실행은 되지만 undefined 출력
var bottom = "Hello";
console.log(bottom); // Hello 출력

// 재선언, 재할당 가능(var)
var bottom = "Hi";
console.log(bottom); // Hi 출력
bottom = "Hola";
console.log(bottom); // Hola 출력

// var는 함수 스코프는 따르지만 블록 스코프는 따르지 않는다.

// 함수 스코프
var age = 30;
function printAge() {
    var age = 28;
    console.log(age); // 28
}
printAge();
console.log(age); // 30

// 블록 스코프
var height = 175;
{
    var height = 176;
}
console.log(height); // 176