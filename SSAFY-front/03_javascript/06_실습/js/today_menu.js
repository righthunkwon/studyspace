// data (파일명과 음식명을 한 번에 관리)
let foods = [
    "burger 햄버거",
    "cake 케이크",
    "sandwich 샌드위치",
    "steak 스테이크"
];

// init
// thumbnail 표시
function init() {
    let imageThumb = document.querySelector(".img-thumb");
    let html = "";
    for (let i = 0; i < foods.length; i++) {
        let data = foods[i].split(" ");
        let fileName = data[0];
        let foodName = data[1];
        html += `<img src="./images/${fileName}.jpg" id="${i}" onclick="viewImage(${i})">`;
    }
    imageThumb.innerHTML = html;
}
init();

// view image by imageThumb
function viewImage(i) {
    let imageView = document.querySelector(".img-view");
    let fileName = foods[i].split(" ")[0];
    imageView.innerHTML = `<img src="./images/${fileName}.jpg" width="200", height="150">`;
}

// add image by btn
function addImage() {
    let imageView = document.querySelector(".img-view");
    let randomIdx = Math.floor(Math.random() * foods.length);
    let fileName = foods[randomIdx].split(" ")[0];
    let randomImage = `<img src="./images/${fileName}.jpg" width="200", height="150">`
    imageView.innerHTML = randomImage;
}

// btn
let addBtn = document.querySelector("#addBtn");
addBtn.addEventListener("click", addImage);