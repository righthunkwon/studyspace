/* const */

// const는 재선언과 재할당 모두 불가하다.
// const는 선언 시 선언시 값을 할당해야 한다.
// const는 블록 스코프를 따른다.
// const는 대문자 스네이크 케이스르 사용하고 상수로 사용한다.

const ID = "kwon";
console.log(ID);
// ID = "lee"; 에러 발생
// console.log(ID);


const TEST_ALPHA = "aaa";
console.log(TEST_ALPHA); // aaa
{
  const TEST_ALPHA = "bbb";
  console.log(TEST_ALPHA); // bbb
}
console.log(TEST_ALPHA); // aaa
