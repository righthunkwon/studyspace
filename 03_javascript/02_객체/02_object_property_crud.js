let student = {
  name: "김싸피",
  age: 25,
  hobby: ["공부", "숙면"],
  "favorite singer": "아이유",
};

// 프로퍼티 읽기
console.log(student.name);
console.log(student[name]); // undefined
console.log(student["name"]);

// 프로퍼티 생성
student.major = "Java";
console.log(student); // Object 형태로 출력

// 프로퍼티 수정
student.age = 28;
console.log(student); // Object 형태로 출력

// 프로퍼티 제거
delete student.hobby;
console.log(student); // Object 형태로 출력