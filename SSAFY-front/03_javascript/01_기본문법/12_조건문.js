if ("") {
    console.log("빈 문자열 실행"); // X (빈 문자열은 falsy한 값)
}

if (" ") {
    console.log("공백 문자열 실행"); // O
}

if (undefined) {
    console.log("undefined 실행"); // X (undefined는 falsy한 값)
}

if (null) {
    console.log("null 실행"); // X (null은 falsy한 값)
}

if (NaN) {
    console.log("NaN 실행"); // X (NaN은 falsy한 값)
}

if (Boolean()) {
    console.log("Boolean() 실행"); // X (Boolean()은 기본값인 false 반환)
}

if (0) {
    console.log("숫자 0 실행"); // X (빈 문자열은 falsy한 값)
}

if ("0") {
    console.log("문자열 실행"); // O
}