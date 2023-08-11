/* var */
console.log(bottom); // 호이스팅 때문에 실행은 되지만 undefined 출력
var bottom = "Hello";
console.log(bottom); // Hello 출력

// 재선언, 재할당 가능(var)
var bottom = "Hi"; // 재선언 & 재할당
console.log(bottom); // Hi 출력
bottom = "Hola";
console.log(bottom); // Hola 출력

// var는 함수 스코프는 따르지만 블록 스코프는 따르지 않는다.
// 함수도 {}(블록)으로 이루어지므로 블록 스코프 안에 함수 스코프가 포함된다.

// 함수 스코프
var age = 30;
function printAge() {
    var age = 28; // 함수의 변수값은 함수 내에서만 사용된다(함수 스코프를 따른다)
    console.log(age); // 28
}
printAge();
console.log(age); // 30

// 블록 스코프
var height = 175;
{
    var height = 176; // 블록값이 블록 안에서만 사용되는 게 아니라 빠져나온다.
}
console.log(height); // 176