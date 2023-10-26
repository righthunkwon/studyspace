// 화살표 함수
// 함수를 간결하게 정의할 수 있도록 도움을 준다.

// 작성순서
// 1. function 키워드 삭제
// 2. ( ) 안에 함수가 사용할 파라미터 이름 작성
//    - 인자가 한개라면 괄호 생략가능
// 3. 화살표 ( => ) 추가
// 4. { } 를 작성하고 블록 안에 함수가 실행할 코드 작성
//    - 함수가 return 문 하나라면 return 생략 가능

// 표현식
let add1 = function (a, b) {
  return a + b;
};

// 화살표 함수
let add2 = (a, b) => {
  return a + b;
};

// 화살표 함수
let add3 = (a, b) => a + b;

// 위의 메서드는 모두 같은 기능을 하는 메서드
console.log(add1(10, 20));
console.log(add2(10, 20));
console.log(add3(10, 20));