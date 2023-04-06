// 데아터 타입, 연산자 실습

1 + 1
// 2
1 + "만원"
// '1만원'
1 + "1"
// '11'
1 - "1"
// 0
"코드" + "캠프"
// '코드캠프'
"123" == 123
// true
"123" === 123
// false
true && true
// true
true && false
// false
false || true
// true
!false
// true
!true
// false


// 조건문 실습 1
if(1 + 1 == 2) {
    console.log("정답입니다")
} else {
    console.log("틀렸습니다")
}
// VM645:2 정답입니다
// undefined
if(true) {
    console.log("정답입니다")
} else {
    console.log("틀렸습니다")
}
// VM689:2 정답입니다
// undefined
if(!true) {
    console.log("정답입니다")
} else {
    console.log("틀렸습니다")
}
// VM732:4 틀렸습니다
// undefined
if(0) {
    console.log("정답입니다")
} else {
    console.log("틀렸습니다")
}
// VM749:4 틀렸습니다
// undefined


// 조건문 실습 2
// 철수의 나이가 20세 이상이면 성인입니다, 
// 8세 이상 19세 이하면 학생입니다, 7세 이하면 어린이입니다를 나타내시오.
const profile = {
    name: "철수",
    age: 12,
    school: "다람쥐초등학교",
}

if(profile.age >= 20) {
    console.log("성인입니다")
} else if(profile.age >= 8) { // 코드 최적화
    console.log("학생입니다")
} else if(profile.age > 0) { // 코드 최적화
    console.log("어린이입니다")
} else { // 예외 처리
    console.log("잘못 입력하셨습니다")
}