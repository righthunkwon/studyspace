// CSS in JavaScript
const grabMe = document.querySelector("#title");

// (1) 기본 코드
/*
function handleTitleClick() {
    if(grabMe.style.color === "blue") {
        grabMe.style.color = "tomato";
    } else {
        grabMe.style.color = "blue";
    }
}
grabMe.addEventListener("click", handleTitleClick);
*/

// (2) 개선된 코드 : 변수 활용
/*
function handleTitleClick() {
    const currentColor = got.style.color;
    let newColor;
    if(currentColor === "blue") {
        newColor = "tomato";
    } else {
        newColor = "blue";
    }
    grabMe.style.color = newColor;
}
grabMe.addEventListener("click", handleTitleClick);
*/

// (3) 더 개선된 코드 : className 활용
// CSS는 디자인에, JS는 상호작용에 - 단 애니메이션은 JS로
/*
function handleTitleClick() {
    if(grabMe.className === "active"){
        grabMe.className = "";
    } else {
        grabMe.className = "active";
    }
}
grabMe.addEventListener("click", handleTitleClick);
*/

// (4) 더욱 더 개선된 코드 : classList 활용
// classList는 className처럼 모든 class를 대체하지 않는다.
// classList는 contains, add, remove와 같은 다양한 메소드를 갖는다.
/*
function handleTitleClick() {
    const clickedClass = "clicked";
    if(grabMe.classList.contains(clickedClass)){
        grabMe.classList.remove(clickedClass);
    } else {
        grabMe.classList.add(clickedClass);
    }
}
grabMe.addEventListener("click", handleTitleClick);
*/

// (5) 최종 코드 : toggle
// toggle : clicked class가 있는지 확인하고 없으면 add, 있으면 remove
// toggle이 등장한 역사를
function handleTitleClick() {
    const clickedClass = "clicked";
    grabMe.classList.toggle("clicked");
}
grabMe.addEventListener("click", handleTitleClick);