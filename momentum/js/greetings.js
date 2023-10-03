// 변수 선언
const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");
const greeting = document.querySelector("#greeting");
const link = document.querySelector("a");

// string은 실수(오타)를 방지하기 위해 변수로 선언하고 사용하는 걸 권장
const HIDDEN_CLASSNAME = "hidden";
const USERNAME_KEY = "username";


// 동일한 코드
// 1. greeting.innerText = `Hello ${username}`;  // ` : 백틱
// 2. greeting.innerText = "Hello " + username;

// addEventListener를 통해 호출된 함수는 첫 번째 인자에 event에 대한 정보를 담는다.
function onLoginSubmit(event) {
    event.preventDefault(); // event의 기본 행동 방지(여기서는 submit시 새로고침을 방지하기 위함)
    loginForm.classList.add(HIDDEN_CLASSNAME);
    const typedUsername = loginInput.value;
    localStorage.setItem(USERNAME_KEY, typedUsername); // localStorage.setItem()는 정보를 (key, value) 형식으로 저장
    paintGreetings(typedUsername);
}
function handleLinkClick(event) {
    event.preventDefault();
    console.dir(event);
}
loginForm.addEventListener("submit", onLoginSubmit);
link.addEventListener("click", handleLinkClick)


// localStorage
// localStorage.setItem("Key", "Value");
// localStorage.getItem("Key");
// localStorage.removeItem("Key");

const savedUsername = localStorage.getItem(USERNAME_KEY);

// 반복의 제거 : 초급 수준에서 프로그래밍을 잘 하는 단 한 가지의 방법
function paintGreetings(username) {
    greeting.innerText = `Hello ${username}`;
    greeting.classList.remove(HIDDEN_CLASSNAME);
}

if (savedUsername === null) {
    // show the login-form
    loginForm.classList.remove(HIDDEN_CLASSNAME);
    loginForm.addEventListener("submit", onLoginSubmit);
} else {
    // show the greetings
    paintGreetings(savedUsername);
}
