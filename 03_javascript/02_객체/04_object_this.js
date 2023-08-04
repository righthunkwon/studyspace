// 함수 안에서 this는 함수를 호출한 객체이다.
// 함수에서 this는 해당 메소드를 가지고 있는 객체를 나타낸다.

let m1 = { name: "홍길동" };
let m2 = { name: "배수지" };

function msg() {
  console.log(this);
  console.log(this.name + "님이 입장합니다.");
}

m1.msg = msg; // m1의 msg라는 key에 msg함수 추가
m2.msg = msg; // m2의 msg라는 key에 msg함수 추가
m1.msg();
m2.msg();
