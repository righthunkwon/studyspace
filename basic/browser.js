// JavaScript는 HTML에 접근하고 읽을 수 있고, 심지어 바꿀 수도 있다.
// 이것의 시작은 document이다. (document = DOM, document = website, document = HTML)

// document 
// document.title                   - 접근
// document.body                    - 접근
// document.title = "Hi";           - 수정
// document.getElementById("title") - 접근

// getElementById
const title = document.getElementById("title");
console.log(title); // 콘솔에 프린트
console.dir(title); // 상세보기
title.innerText = "Got you!"; // HTML의 Grab me!를 JavaScript를 통해 변경

// getElementsByClassName
const hellos = document.getElementsByClassName("hello");
console.log(hellos); // 배열로 출력(HTML Collection)

// querySelector : element를 CSS 방식으로 검색 (. = class, # = id)
const content = document.querySelector(".content h1");
console.log(content); // 값 하나만 출력(Node)

// querySelectorAll
const contents = document.querySelectorAll(".content h1");
console.log(contents); // 배열로 출력(NodeList)

// addEventListener : 이벤트 발생 시 처리할 일 지정
// (1) 이벤트 처리 함수 정의
function handleTitleClick() {
    title.style.color = "blue";
    console.log("title was clicked!");
}
function handleMouseEnter() {
    title.innerText = "Mouse is here!";
    console.log("mouse is here!");
}
function handleMouseLeave() {
    title.innerText = "Mouse is gone!";
}

// (2) 이벤트 발생 시 처리할 일 지정(addEventListener)
// 함수를 인자로 받아 표기할 때는 괄호를 붙이지 않는다.
title.addEventListener("click", handleTitleClick); // event: click
title.addEventListener("mouseenter", handleMouseEnter); // event: mouseenter
title.addEventListener("mouseleave", handleMouseLeave); // event: mouseleave

// addEventListener와 동일한 기능
// title.onclick = handleTitleClick;
// title.onmouseenter = handleMouseEnter
// title.onmouseleave = handleMouseLeave

// 단, .addEventListener를 사용할 경우 이후
// .removeEventListener로 데이터를 지울 수 있으므로 더 편리하다.

// Window (기본 제공 객체)
function handleWindowResize() {
    document.body.style.backgroundColor = "tomato";
}
function handleWindowCopy() {
    alert("copier!");
}
function handleWindowOffline() {
    alert("SOS no WIFI!");
}
function handleWindowOnline() {
    alert("ALL GOOD!");
}
window.addEventListener("resize", handleWindowResize);
window.addEventListener("copy", handleWindowCopy);
window.addEventListener("offline", handleWindowOffline);
window.addEventListener("online", handleWindowOnline);