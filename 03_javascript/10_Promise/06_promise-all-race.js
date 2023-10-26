function TaskHasDuration(duration) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      // 해당 작업을
      resolve(duration);
    }, duration); // duration이 경과하면 수행
  });
}



// 여러 선택지 중에서 가장 빠른 작업만 시행
Promise.race([
  TaskHasDuration(1000), // task 1
  TaskHasDuration(2000), // task 2
  TaskHasDuration(3000), // task 3
  TaskHasDuration(4000), // task 4
  TaskHasDuration(5000), // task 5
]).then((message) => {
  console.log(message);
});
