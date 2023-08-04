// 함수의 매개변수로 함수가 들어갈 수 있다.
function func(callFn) {
  callFn("hello");
}

function fn(msg) {
  console.log(msg);
}

func(fn);