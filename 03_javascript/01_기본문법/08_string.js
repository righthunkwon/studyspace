/**
 * 자바스크립트 문자열 
 *
 * - ""로 감싼다.
 * - ''로 감싼다.
 * - ``(backtick)으로 감싼다.
 */

/*
    Template literals
    ``은 ${}과 결합시켜 변수를 편리하게 출력할 수 있게 한다.
*/

// deprecated
// 중요도가 떨어져 더 이상 사용되지 않고 앞으로는 사라지게 될 변수라는 뜻
let name = "권정훈";
let age = 28;
let msg = `이름은 ${name}이고, 나이는 ${age}세입니다.`
console.log(msg);