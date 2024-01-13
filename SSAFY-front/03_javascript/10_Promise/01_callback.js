// 콜백(Callback)
// 함수를 매개변수로 전달하여, 나중에 실행하도록 하는 것
// 콜백이 중첩되면 콜백지옥이 되어 해석하고 유지보수하기 힘든 코드가 될 수 있다.

// 조건문 임시 변수
// flag는 특정한 작업이라 생각
let flag = true; 

function task(successCallback, failureCallback) {
  if (flag) {
    successCallback(); // 작업 성공 시 실행
  } else {
    failureCallback(); // 작업 실패 시 실행
  }
}

function onTaskSuccess() {
  console.log("작업이 성공하면 이 콜백함수를 실행합니다.");
}

function onTaskFailure() {
  console.log("작업이 실패하면 이 콜백함수를 실행합니다.");
}

// 실행(호출)
task(onTaskSuccess, onTaskFailure);

// 실행2(호출)
task(()=>{
  console.log("작업이 성공하면 이 콜백함수를 실행합니다.");
}, ()=>{
  console.log("작업이 실패하면 이 콜백함수를 실행합니다.");
})