// 전개 연산자
// 가변 파라미터와 동일한 기호(...) 사용

// 깊은 복사 시 자주 사용
// 배열/객체를 연산자와 함께 객체리터럴/배열리터럴에서 사용하면
// 객체/배열 내의 값을 분해된 형태로 전달

// 배열에 전개 연산자 활용
let arr1 = [1, 2, 3, 4]; // (4) [1, 2, 3, 4]
let arr2 = [100, ...arr1, 200]; // (6) [100, 1, 2, 3, 4, 200]

console.log(arr1);
console.log(arr2);

// 객체에 전개 연산자 활용
let user1 = {
  id: "ssafy",
  name: "권정훈",
  age: 28,
};

let user2 = user1; // 얕은 복사(객체와 같은 주소값 공유)
let user3 = { ...user1 }; // 깊은 복사(값을 전부 복사하며 별도의 객체 생성)

user2.age = 50;
console.log(user1); // age 50
console.log(user2); // age 50
console.log(user3); // age 28
console.log(user1 == user2); // true
console.log(user1 == user3); // false