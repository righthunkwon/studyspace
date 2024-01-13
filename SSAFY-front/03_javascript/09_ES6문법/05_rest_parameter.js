// 가변 파라미터(Rest Parameter, ...)
// 여러 개의 파라미터 값을 배열로 받을 수 있다.
function myInfo(name, age, ...hobbies) {
  console.log(`이름 : ${name}, 나이 : ${age}`);
  console.log(hobbies);
}

myInfo("권정훈", 28, "공부"); // ['공부']
myInfo("권정훈", 28, "공부", "수면", "식사"); // (3) ['공부', '수면', '식사']
