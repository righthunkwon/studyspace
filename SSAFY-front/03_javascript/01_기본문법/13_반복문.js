
for (let i = 0; i < 10; i++) {
  console.log(i)
}
console.log("------------------")

let j = 0;
while (j < 10) {
  console.log(j);
  j++;
}
console.log("------------------")
do {
  j++;
} while (j < 10);

// js 객체
let student = {
  name: "김싸피",
  age: 20,
  hobby: ["공부", "숙면"],
  "favorite singer": "아이유",
  studentMethod: function () {
    console.log("st method 출력");
  }
};

// 객체의 속성 순회
for (key in student) {
  // template literal
  console.log(`${key} => ${student[key]}`)
}
console.log("------------------")

// js 배열
let food = ["김밥", "사이다"];
for (val of food) {
  console.log(`음식 : ${val}`)
}
