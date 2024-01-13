// falsy한 값들
// !! : 원래의 typeof 출력
console.log(!!0); // false
console.log(!!""); // false
console.log(!!null); // false
console.log(!!undefined); // false
console.log(!!NaN); // false
console.log(!!"0"); // true(문자열)
console.log(!!Number("0")); // false
console.log(Boolean()); // false

let id;
console.log(id);
if (id) {
  console.log("id 값이 있는 경우.");
} else {
  console.log("id 값이 없는 경우");
}
