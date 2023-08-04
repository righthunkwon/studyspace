// Array Helper method
// 배열에서 활용하기 좋은 미리 구현된 함수들
// .forEach , .map , .find , .filter , .some , .every , .reduce , ...

// js style guide (airbnb, google, ...)
const arr = [1, 2, 3];

// (1) .forEach(cb)
// cb : callback
// readonly -> return 값 X
arr.forEach(function (num) { // 배열의 요소를 순회하면서 각 요소에 function을 수행하겠다는 의미
    console.log(num); // 1 2 3
});

// querySelector 사용 권장
document.getElementsByClassName("className"); // HTMLCollection
document.querySelectorAll(".className"); // NodeList


// (2) .map(cb)
// callback 함수의 리턴값으로 만든 배열을 return
// 기존 배열 수정 X, 새로운 배열 생성 후 반환 O
arr.map(function (num) {
    return num ** 2; // (3) [1, 4, 9]
});

const contents = ["apple", "banana", "orange"];
const fruits = contents.map(function (name) {
    return `<h2>${name}</h2>` // (3) ['<h2>apple</h2>', '<h2>banana</h2>', '<h2>orange</h2>']
});


// (3) .find(cb)
// 콜백함수의 리턴값이 true인 첫번째 요소 반환
arr.find(function (num) {
    return num === 2; // 2
});

arr.find(function (num) {
    return num === 5; // undefined
});

arr.find(function (num) {
    return num % 2; // 1 (true)
});


// (4) .filter(cb)
// 콜백함수의 리턴값이 true인 요소들을 배열로 반환
arr.filter(function (num) {
    return num % 2; // (2) [1, 3]
});
