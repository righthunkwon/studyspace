// 모듈(Module)
// 독립성을 가진 재사용이 가능한 코드 블록
// 여러 코드 블록을 각각의 파일로 분리 후 필요한 모듈을 조합하여 사용 가능(import/export)

import { title, add, sub } from "./08_module1.js"; // 구조분해할당으로 변수에 값 할당
import calc from "./08_module2.js"; // 객체를 가져와 사용

console.log(title);
console.log(calc.title);

document.querySelector("#calc").addEventListener("click", () => {
  // 문자열을 숫자로 바꿔주기 위해 +를 붙여준다.
  let num1 = +document.querySelector("#num1").value; 
  let num2 = +document.querySelector("#num2").value;

  // 모듈1
  console.log(add(num1, num2));
  console.log(sub(num1, num2));

  // 모듈2
  console.log(calc.add(num1, num2));
  console.log(calc.sub(num1, num2));
});
