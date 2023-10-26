// (1) let 블록스코프 
// 재선언 X 재사용 O
let a = 100;
{
  // 블록 안에 있으므로 외부의 a와는 별개의 a
  let a = 200;
  console.log(a);
}
console.log(a);

// (2) const 블록스코프 
// 재선언 X 재사용 X
let b = 100;
function info() {
  // 블록 안에 있으므로 외부의 b와는 별개의 b
  let b = 200;
}