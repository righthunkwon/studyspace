// JavaScript는 HTML에 접근하고 읽을 수 있고, 심지어 바꿀 수도 있다.
// 이것의 시작은 document이다. (document = DOM, document = website, document = HTML)

// document
// document.title
// document.body
// document.title = "Hi"
// document.getElementById("title")

// getElementById
const got = document.getElementById("title");
console.log(got);
console.dir(got);
got.innerText = "Got you!"; // HTML의 Grab me!를 JavaScript에 의해 변경

// getElementsByClassName
const hellos = document.getElementsByClassName("hello");
console.log(hellos); // 배열로 출력

// querySelector : element를 CSS 방식으로 검색 (. = class, # = id)
const content = document.querySelector(".content h1");
console.log(content); // 값 하나만 출력

// querySelectorAll
const contents = document.querySelectorAll(".content h1");
console.log(contents); // 배열로 출력

// Event
function handleTitleClick() {
    got.style.color = "blue";
    console.log("title was clicked!");
}
function handleMouseEnter() {
    got.innerText = "Mouse is here!";
    console.log("mouse is here!");
}
function handleMouseLeave() {
    got.innerText = "Mouse is gone!";
}
// HTML Element (ex. title)
got.addEventListener("click", handleTitleClick);
got.addEventListener("mouseenter", handleMouseEnter);
got.addEventListener("mouseleave", handleMouseLeave);

// title.onclick = handleTitleClick;
// title.onmouseenter = handleMouseEnter
// title.onmouseleave = handleMouseLeave
// 단, .addEventListener를 사용할 경우 이후
// .removeEventListener로 데이터를 지울 수 있으므로 더 편리하다.

// Window (기본 제공)
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