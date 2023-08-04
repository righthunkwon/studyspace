let member1 = { id: "hong", email: "hong@a.com" };
let member2 = member1; // 주소 복사
let member3 = { ...member1 }; // 값 복사

member2.id = "yang"; // 원래 객체인 member1에도 반영(주소 복사)
member3.id = "kwon"; // 원래 객체인 member1에는 미반영(값 복사)

console.log(member1.id);
console.log(member2.id);
console.log(member3.id);
