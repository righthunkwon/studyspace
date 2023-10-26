// Promise 객체는 변수를 만드는 순간 생성된다.
// let TaskPromise = new Promise(); (Promise 객체 생성)
// 만약, 어떤 동작을 하면서 그 동작 시에 Promise 객체를 만들고 싶다면
// Promise 객체를 함수 안에 넣음으로써 함수가 Promise 객체를 리턴하게 만들면 된다.

let task = false;

function TaskPromise() {
  return new Promise((resolve, reject) => {
    console.log("Task 작업 수행 중입니다.");
    if (task) {
      resolve("작업이 완료됐어요.");
    } else {
      reject("작업이 실패했어요");
    }
  });
}

// p.then
TaskPromise()
  .then((response) => { // 성공 시
    console.log(response);
  })
  .catch((response) => { // 실패 시
    console.log(response);
  })
  .finally(() => { // 무조건 실행
    console.log("나는 무조건 실행됩니다.");
  });
