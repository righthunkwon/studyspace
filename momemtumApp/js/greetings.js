// 변수
const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");
const logoutForm = document.querySelector("#logout-form");
const greeting = document.querySelector("#greeting");

// 변수(String)
const HIDDEN_CLASS_NAME = "hidden";
const USERNAME_KEY = "username";


// (1) Login, paint Greetings
function onLoginSubmit(event) {
    event.preventDefault();
    loginForm.classList.add(HIDDEN_CLASS_NAME);
    const username = loginInput.value;
    localStorage.setItem(USERNAME_KEY, username);
    paintGreetings(username);
    paintLogOutBtn();
}
function paintGreetings(username) {
    greeting.innerText = `Hello ${username} !`;
    greeting.classList.remove(HIDDEN_CLASS_NAME);
}
function paintLogOutBtn() {
    logoutForm.classList.remove(HIDDEN_CLASS_NAME);
}
loginForm.addEventListener("submit", onLoginSubmit);


// (2) Logout
function onLogoutSubmit() {
    loginForm.classList.remove(HIDDEN_CLASS_NAME);
    loginInput.classList.add(HIDDEN_CLASS_NAME);
    window.localStorage.clear();
}
logoutForm.addEventListener("submit", onLogoutSubmit);


// localStorage
// localStorage.setItem("Key", "Value");
// localStorage.getItem("Key");
// localStorage.removeItem("Key");

const savedUsername = localStorage.getItem(USERNAME_KEY);


if (savedUsername === null) {
    // show the login-form
    loginForm.classList.remove(HIDDEN_CLASS_NAME);
    loginForm.addEventListener("submit", onLoginSubmit);
} else {
    // show the greetings & logout-form
    paintGreetings(savedUsername);
    logoutForm.classList.remove(HIDDEN_CLASS_NAME);
}
