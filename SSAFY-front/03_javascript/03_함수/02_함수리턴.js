// 함수의 실행 결과로 함수를 반환할 수도 있다.
function func() {
  return function (num1, num2) {
    return num1 + num2;
  };
}

function func2() { }

console.log(func()(100, 200)); // 300
console.log(func2()); // undefined
console.log(func()(100)); // NaN(100 + ?)
