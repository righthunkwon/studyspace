// Promise 객체
// 비동기 작업을 마치 도익 작업처럼 값을 반환해서 사용하는 형태
// 미래의 완료 또는 실패와 그 결과 값을 나타냄, 미래의 어떤 상황에 대한 약속

// Promise 생성
// Promise 생성자에 (resolve, reject) 파라미터로 성공함수, 실패함수를 삽입
const p = new Promise((resolve, reject) => {
  console.log("p 작업이 수행 중입니다.");
  // 1. 작업을 수행
  // 성공할 수도 실패할 수도 있는 작업을 수행
  // 시간이 오래 걸리는 작업(ex.비동기 작업)일 수도 있음
  let task = true; 

  // 2. 작업의 수행 결과를 결정
  // 작업의 수행은 성공 또는 실패로 끝맺음
  // resolve(msg) 함수를 호출하면 성공하고 종료
  // reject(msg, object, array...) 함수를 호출하면 실패하고 종료
  // resolve, reject 함수의 파라미터로 작업의 결과를 전달할 수 있다.
  if (task === true) {
    resolve("p 작업이 성공했습니다.");
  } else {
    reject("p 작업이 실패했습니다.");
  }
});

// .then()  : resolve된 결과(response)가 넘어오는곳
// .catch() : reject된 결과(response)에 대응하는 코드 작성
p.then((response) => {
  console.log(`p 프라미스가 resolve됨: ${response}`);
}).catch((response) => {
  console.log(`p 프라미스가 reject됨: ${response}`);
});
