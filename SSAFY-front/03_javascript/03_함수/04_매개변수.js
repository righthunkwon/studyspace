function fn(num) {
  console.log(num);
}

fn(); // undefined
fn(100); // 100
fn(100, 100); // 100, js는 함수 호출 시 매개변수의 개수가 일치하지 않아도 상관 없다.