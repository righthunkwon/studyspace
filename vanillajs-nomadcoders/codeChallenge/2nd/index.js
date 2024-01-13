const body = document.querySelector("body");
const h1 = document.querySelector("body h1");
function resizeTest() {
    let width = window.innerWidth;
    if(width >= 900) {
        h1.classList.add("active");
        body.style.backgroundColor = "#EEBC11";
    } else if (width < 900 && width >= 600) {
        h1.classList.add("active");       
        body.style.backgroundColor = "#904EAC";
    } else if (width < 600) {
        h1.classList.add("active");        
        body.style.backgroundColor = "#2D8ED6";
    }
}
window.addEventListener("resize", resizeTest);