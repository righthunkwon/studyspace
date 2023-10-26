// Template Literal : ``(역따옴표, backtick)
// ``로 묶여진 문자열에 ${} 를 이용하여 동적으로 문자열을 끼워 구성 가능
const vin = "KMHXX00XXXX000000";
const modelName = "소나타";
let color = "Blue";
let mileage = 120000;

let info = `내 자동차는 ${modelName}이고, 색상은 ${color}입니다. 오늘까지 ${mileage}km 주행했습니다.`;
console.log(info);
