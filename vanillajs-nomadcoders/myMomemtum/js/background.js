/*
const images = [
    "1.jpg",
    "2.jpg",
    "3.jpg",
    "4.jpg",
    "5.jpg",
    "6.jpg",
    "7.jpg",
    "8.jpg",
    "9.jpg",
    "10.jpg"
];
const chosenImage = images[Math.floor(Math.random() * images.length)];
const bgImage = document.createElement("img");
bgImage.src = `img/${chosenImage}`;
document.body.appendChild(bgImage);
*/

const body = document.querySelector("body");

const IMG_NUMBER = 10;

function handleImgLoad(){
    console.log("Finished Loading");
}

function paintImage(imgNumber){
    const image = new Image();
    image.src = `img/${imgNumber}.jpg`;
    image.classList.add('bgImage');
    body.prepend(image);
    image.addEventListener("loadend", handleImgLoad);

}

function genRandom(){
    const number = Math.floor(Math.random() * IMG_NUMBER) + 1;
    return number;
}

function init(){
    const randomNumber = genRandom();
    paintImage(randomNumber);
}

init();