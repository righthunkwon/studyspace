const form = document.querySelector(".numForm");
const range = document.querySelector(".inputRange");
const inputNum = document.querySelector(".inputNum");
const paintChose = document.querySelector(".paintChose");
const paintResult = document.querySelector(".paintResult");

function gameResult(myNum, randomNum) {
    paintChose.innerText = `You chose: ${myNum}, the machine chose ${randomNum}.`;
    myNum = parseInt(myNum);
    if (myNum === randomNum) {
        paintResult.innerText = `You won!`;
    }
    else {
        paintResult.innerText = `You lose!`;
    }
}

function makeRandomNum(e) {
    e.preventDefault();
    const myNum = inputNum.value;
    const maxValue = range.value;
    const randomNum = Math.ceil(Math.random() * maxValue);

    gameResult(myNum, randomNum);
}

function handleInput() {
    form.addEventListener("submit", makeRandomNum);
}

function init() {
    range.oninput = handleInput;
}
init();