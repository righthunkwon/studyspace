let arr = ["kim", "lee", "kwon", "jeon"];
let arrStr = JSON.stringify(arr);
console.log(arrStr);

console.log(typeof arr); // object
console.log(typeof arrStr); // string

// for in : 객체 순회
// for of : 배열 순회
for (student of arr) {
    console.log(student);
}

// forEach(function())
// 함수의 매개변수에 값이 하나씩 삽입
arr.forEach(function (student) {
    console.log(student);
});

// forEach(function())
// 일반적으로 화살표 함수 형태로 사용(간결성)
// return만 구현한다면 {}와 return 생략 가능
arr.forEach((student) => {
    console.log(student);
});

// 다양한 화살표 함수의 형태
let add = function (a, b) {
    return a + b;
}

let add2 = (a, b) => {
    return a + b;
}

let add3 = (a, b) => a + b;
