// Type(1) ///////////////////////////////////////////////////////////////////////
// 숫자와 문자(number, string)
console.log(123);
console.log('hello');
console.log("hello");
console.log("============================================================");

// 연산
console.log(5 + 2); // 7
console.log(5 * 2); // 10
console.log(5 / 2); // 2.5
console.log("============================================================");

// 변수(Variable) ///////////////////////////////////////////////////////////////////////
// (1) const(상수) : 변하지 않는 수, 값 변경 불가
const a = 5;
const b = 2;
console.log(a + b); // 7
console.log(a * b); // 10
console.log(a / b); // 2.5
console.log("============================================================");

const myName = "kwon";
console.log("hello " + myName);
console.log("============================================================");
// veryLongVariableName : camelCase (JavaScript)
// very_long_variable_name : snake_case (Python)

// (2) let : 값 변경 가능
let c = 5;
let d = 2;
console.log(a + b); // 7
console.log(a * b); // 10
console.log(a / b); // 0.4
console.log("============================================================");

let myNickname = "hippoDev";
console.log("hello " + myNickname);

// const와 달리 let은 값 변경 가능
myNickname = "HTML Programmer"; // 재할당 가능, 재선언은 불가
console.log("hello " + myNickname);
console.log("============================================================");

// (3) var : ES5 버전에서 사용하던 변수명, 변경 가능
// const와 let은 ES6 버전에서 추가
// 기본적으로 const를 쓰고, 필요할 때만 let을 쓰되, var은 쓰지 말 것!

// 항상 const, 가끔 let, 노노 var!


// Type(2) ///////////////////////////////////////////////////////////////////////
// boolean : true, false
const amIFat1 = true;
const amIFat2 = false;
const amIFat3 = "true"; // String

// null : nothing
// null은 false와 다르다.
// null은 자연발생적으로 발생하지 않는다.
// null은 variable 안에 어떤 것이 없다는 것을 확실히 하기 위해 사용한다.
const amIFat4 = null;

// undefined : no value
let something;
console.log(something); // undefined
console.log("============================================================");

// 배열(Arrays) ///////////////////////////////////////////////////////////////////////
// 주석은 영어로 comment라 한다.
// array 안에는 이후에 만들 todo list 를 넣을 수도 있다.  

// (1) World without Arrays
const mon = "mon";
const tue = "tue";
const wen = "wen";
const thu = "thu";
const fri = "fri";
const sat = "sat";
const sun = "sun";

const daysOfWeek = mon + tue + wen + thu + fri + sat + sun;
console.log(daysOfWeek); // montuewenthufrisatsun
console.log("============================================================");

// (2) World with Arrays
// JS의 array 안에는 다양한 타입을 동시에 담을 수 있다.
const nonsense = [1, 2, 3, "hello", true, false, undefined, null];
console.log(nonsense);

const daysOfWeekArray = [mon, tue, wen, thu, fri, sat, sun];
console.log(daysOfWeekArray); // (7) ['mon', 'tue', 'wen', 'thu', 'fri', 'sat', 'sun']
console.log(daysOfWeekArray[0]); // mon
console.log(daysOfWeekArray[1]); // tue
console.log(daysOfWeekArray[2]); // wen
console.log(daysOfWeekArray[6]); // sun
console.log(daysOfWeekArray[10]); // undefined
console.log("============================================================");

// 배열에 데이터 추가
const toBuy = ["potato", "tomato", "pizza"];
console.log(toBuy);
toBuy.push("milk");
console.log(toBuy);
console.log("============================================================");

// 객체(Object) ///////////////////////////////////////////////////////////////////////
const player = {
    name: "jeonghun",
    points: 100,
    fat: true,
};
console.log(player);
console.log(player.name); // jeonghun
console.log(player.points); // 100
console.log(player.fat); // true

// const는 값을 변경할 수 없지만, object 내에 속성을 추가하거나 바꿀 수 있다.
player.lastName = "kwon"; // 속성 추가
console.log(player);
player.fat = false; // 속성 변경
console.log(player);
player.points += 50; // 속성 변경
console.log(player);
console.log("============================================================");

// 함수(Function) ///////////////////////////////////////////////////////////////////////
function sayHello(nameOfPerson, age) {
    console.log("Hello " + nameOfPerson + "(" + age + ")!")
}
sayHello("Kwon", 28);
sayHello("Kim", 23);
sayHello("Lee", 25);
console.log("============================================================");

function plus(firstNumber, secondNumber) {
    console.log(firstNumber + secondNumber); // firstNumber, secondNumber는 function plus 내부에서만 존재한다.
}
plus(); // NaN : not a number
plus(8, 60); // 68
console.log("============================================================");

// 객체 내부의 함수
const studyMember = {
    studyName: "JSstudy",
    sayHelloToMember: function (otherPersonName) { // 매개변수(선언 시) : otherPersonName
        console.log("Hello " + otherPersonName + ". nice to meet you!");
    }
};
studyMember.sayHelloToMember("Kim"); // 인자(호출 시) : "Kim"
studyMember.sayHelloToMember("Lee"); // 인자(호출 시) : "Lee"
console.log("============================================================");


// 계산기 ///////////////////////////////////////////////////////////////////////
const calculator = {
    add: function (a, b) {
        return a + b; // return 이 실행되는 시점에서 함수는 종료된다.
        console.log("hi!"); // 해당 코드는 출력되지 않는다.
    },
    minus: function (a, b) {
        return a - b;
    },
    div: function (a, b) {
        return a / b;
    },
    multi: function (a, b) {
        return a * b;
    },
    power: function (a, b) {
        return a ** b;
    },
};

const plusResult = calculator.add(4, 2);
const minusResult = calculator.minus(4, 2);
const timesResult = calculator.div(4, 2);
const divideResult = calculator.multi(4, 2);
const powerResult = calculator.power(4, 2);
console.log("============================================================");


// 반환(return) ///////////////////////////////////////////////////////////////////////
const age = 26;
function calculateKrAge(ageOfForeigner) {
    return ageOfForeigner + 2;
};

const krAge = calculateKrAge(age);
console.log(krAge);
console.log("============================================================");


// 조건문(conditionals) ///////////////////////////////////////////////////////////////////////
const askAge = parseInt(prompt("How old are you?")); // prompt 현재는 사용하지 않는 방법, 웹페이지 일시정지, 디자인 문제 등
console.log(askAge); // 질문에 대한 입력값 콘솔에 출력

// typeof : 타입 확인
// 원래 prompt는 입력값을 string으로 내놓기에 숫자를 입력해도 string이라고 입력되지만,
// 앞서 parseInt로 string을 int로 바꿔줬으므로 type은 int로 출력된다.
console.log(typeof askAge);
if (isNaN(askAge) || age <= 0) { // NaN : not a number
    console.log("Please write a real positive number.");
} else if (askAge < 20) {
    console.log("You are too young to drink.");
} else if (askAge >= 20 && askAge <= 50) {
    console.log("You can drink.");
} else {
    console.log("You'd better not drink.");
}

// ==나 != 보다 ===와 !==를 사용하자.