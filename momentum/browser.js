// JavaScript는 HTML에 접근하고 읽을 수 있고, 심지어 바꿀 수도 있다.
// 이것의 시작은 document이다. (document = website, document = HTML)

// document
// document.title
// document.body
// document.title = "Hi"
// document.getElementById("title")

// getElementById
const title = document.getElementById("title");
console.log(title);
console.dir(title);
title.innerText = "Got you!"; // HTML의 Grab me!를 JavaScript에 의해 변경

// getElementsByClassName
const hellos = document.getElementsByClassName("hello");
console.log(hellos); // 배열로 출력

// querySelector : element를 CSS 방식으로 검색 (. = class, # = id)
const content = document.querySelector(".content h1");
console.log(content); // 값 하나만 출력

// querySelectorAll
const contents = document.querySelectorAll(".content h1");
console.log(contents); // 배열로 출력