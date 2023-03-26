// JavaScript 내장 기능 (interval, timeout )
// (1) interval : '매번' 일어나야 하는 무언가
function sayHello() {
    console.log("hello");
}
setInterval(sayHello, 5000); // 5초마다 sayHello 실행

// (2) timeout  : 
function sayHi() {
    console.log("hi");
}



const clock = document.querySelector("h2#clock");
