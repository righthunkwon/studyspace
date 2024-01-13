let task1 = true;
let task2 = false;

function task1Promise() {
  return new Promise((resolve, reject) => {
    if (task1) {
      resolve("task1이 성공했습니다.");
    } else {
      reject("task1이 실패했습니다");
    }
  });
}

function task2Promise() {
  return new Promise((resolve, reject) => {
    if (task2) {
      resolve("task2가 성공했습니다.");
    } else {
      reject("task2가 실패했습니다.");
    }
  });
}

task1Promise()
  .then((response) => {
    console.log(response);
    return task2Promise();
  })
  .then((response) => {
    console.log(response);
  })
  .catch((response) => console.log(response));
