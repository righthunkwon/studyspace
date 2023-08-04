// JS의 Array는 Java의 ArrayList의 속성을 가지고 있다.
let arr = [];
arr[0] = 10;
arr[2] = 20;
console.log(arr); // (3) [10, empty, 20]
console.log(arr[1]); // undefined
console.log(arr[3]); // undefined

// 다양한 타입을 넣을 수 있는 js의 배열
arr["msg"] = "가능"; // key : value, 독립적으로 존재
console.log(arr);

arr.push(30); // 맨 뒤에 값 추가
console.log(arr);

arr.pop(); // 맨 뒤의 값 제거
console.log(arr);

arr.unshift(0); // 맨 앞에 값 추가
console.log(arr);

console.log(arr.includes(20)); // true