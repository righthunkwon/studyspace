// 객체 속성 표기법 개선(shorthand properties)
// member1 객체와 member2 객체의 표기는 동일하다.
const id = "ssafy";
const name = "권정훈";
const age = 28;

const member1 = {
  id: id,
  name: name,
  age: age,
  info: function () {
    console.log("info");
  },
};

const member2 = {
  id, // id: id,
  name, // name: name,
  age, // age: age,
  info() {                  //  info: function () {
    console.log("info");    //    console.log("info");
  },                        //  },
};

console.log(member1);
console.log(member2);