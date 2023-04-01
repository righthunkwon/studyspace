////////////////////////////////////////////////////////////////////
// JavaScript 내장 기능 (interval, timeout )
// (1) interval : '매번' 일어나야 하는 무언가
/*
function sayHello() {
    console.log("hello");
}
setInterval(sayHello, 5000); // 5초마다 sayHello 실행
*/


////////////////////////////////////////////////////////////////////
// (2) timeout  : 일정 시간이 흐른 뒤에 무언가를 '한번' 실행
/*
function sayHi() {
    console.log("hi");
}
setTimeout(sayHi, 5000); // 5초 뒤에 sayHi 실행
*/


////////////////////////////////////////////////////////////////////// Date
// Date
/*
const date = new Date();
date.getDate();
date.getDay();
date.getFullYear();
date.getHours();
date.getMinutes();
date.getSeconds();
*/


//////////////////////////////////////////////////////////////////////
// String.padStart(문자열의 길이, 채울 문자열)
const str = '123';
const paddedStr = str.padStart(5, '0'); // '00123'


////////////////////////////////////////////////////////////////////
// Clock
const clock = document.querySelector("h2#clock");


function getClock() {
    const date = new Date();
    
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');
    const seconds = String(date.getSeconds()).padStart(2, '0');
    
    clock.innerText = `${hours}:${minutes}:${seconds}`; // ` : 백틱 (작은 따옴표가 아니다!)
}

getClock();
setInterval(getClock, 1000);




