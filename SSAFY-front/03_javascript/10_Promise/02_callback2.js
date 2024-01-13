let flag1 = true; // 작업1의 성공여부
let flag2 = false; // 작업2의 성공여부

function task(successCallback, failureCallback) {
  if (flag1) {
    successCallback();
  } else {
    failureCallback();
  }
}

function onTask1Success(successCallback, failureCallback) {
  console.log("work1 작업이 성공했습니다.");
  if (flag2) {
    successCallback();
  } else {
    failureCallback();
  }
}

function onTask1Failure() {
  console.log("work1 작업이 실패했습니다.");
}

function onTask2Success() {
  console.log("work2 작업이 성공했습니다");
}

function onTask2Failure() {
  console.log("work2 작업이 실패했습니다");
}

task(() => onTask1Success(onTask2Success, onTask2Failure), onTask1Failure);
