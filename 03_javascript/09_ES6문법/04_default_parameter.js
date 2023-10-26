// 기본 파라미터(default parameter)
// 함수 파라미터의 기본값을 지정할 수 있다.
function myInfo1(name, age = 0, address = "x", email = "x") {
  console.log(
    `이름 : ${name}, 나이 : ${age}, 주소 : ${address}, email=${email}`
  );
}

myInfo1("권정훈");
myInfo1("권정훈", 28);
myInfo1("권정훈", 28, "신림");
myInfo1("권정훈", 28, "신림", "kwon@ssafy.com");

// 데이터가 동적 타입이기 때문에
// 타입을 자동으로 바꾸어 나이가 신림이 된다는 문제 발생
myInfo1("권정훈", "신림");

// 기본 파라미터를 지정하지 않고
// 함수 호출에서 인자로도 넣어주지 않았을 경우
function myInfo2(name, age = 0, address, email) {
  console.log(
    `이름 : ${name}, 나이 : ${age}, 주소 : ${address}, email=${email}`
  );
}

myInfo2("권정훈", 28, "역삼"); // email=undefined