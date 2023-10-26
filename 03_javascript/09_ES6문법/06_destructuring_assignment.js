// 구조 분해 할당
// 배열, 객체, 함수의 값들을 추출하여 한번에 여러 변수에 할당할 수 있다.

///////////////////////////////////////////////////////////////////////////////
// ex1. 배열
// 변수 a,b,c에 1,2,3이라는 값 구조 분해 할당
// let arr = [1,2,3,4];
// let [a,b,c] = arr;

// 원래는 이런 코드였다.
// let a = arr[0];
// let b = arr[1];
// let c = arr[2];

///////////////////////////////////////////////////////////////////////////////
// ex2. 객체
// let user = {
//   id: "ssafy",
//   name: "권정훈",
//   age: 28,
// };

// (1) ES6 이전
// let id = user.id;
// let name = user.name;
// let age = user.age;

// console.log(`${id}님의 이름은 ${name} 이고, 나이는 ${age}살 입니다.`);

// (2) ES6 이후
// let { id, name, age } = user;
// console.log(`${id}님의 이름은 ${name} 이고, 나이는 ${age}살 입니다.`);

///////////////////////////////////////////////////////////////////////////////
// ex.3 함수
// 함수 객체 리턴
// function getUser() {
//   return {
//     id: "ssafy",
//     name: "권정훈",
//     age: 28,
//   };
// }

// (1) ES6 이전
// let user = getUser();
// let id = user.id;
// let name = user.name;
// let age = user.age;
// console.log(`${id}님의 이름은 ${name} 이고, 나이는 ${age}살 입니다.`);

// (2) ES6 이후
// let { id, name, age } = getUser();
// console.log(`${id}님의 이름은 ${name} 이고, 나이는 ${age}살 입니다.`);
///////////////////////////////////////////////////////////////////////////////


// 배열
let arr = [5, 6, 7, 8];
let [a, b, c] = arr;
console.log(a);
console.log(b);
console.log(c);

// 객체
let member = {
  id: "admin",
  name: "관리자",
  age: 50,
};

function showMember1(member) {
  console.log("showMember1");
  console.log("아이디 :", member.id);
  console.log("이름 :", member.name);
  console.log("나이 :", member.age);
}

function showMember2({ id, name, age }) {
  console.log("showMember2");
  console.log("아이디 :", id);
  console.log("이름 :", name);
  console.log("나이 :", age);
}

showMember1(member);
showMember2(member);


