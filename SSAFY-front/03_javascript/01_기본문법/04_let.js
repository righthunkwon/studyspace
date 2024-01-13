/* let */

// let은 재선언이 불가하지만 재할당은 가능하다.
// let은 블록 스코프를 따른다.
let height = 175;
{
    // let 입장에서 블록은 다른 세계이다.
    // 따라서 let은 재선언이 불가능하지만 블록 내에서는 재선언이 된다.
    let height = 176;
}
console.log(height); // 175

// 블록 스코프는 함수 스코프를 포함하기에 let은 함수 내에서도 재선언이 가능하다.
function printHeight() {
    let height = 177;
    console.log(height); // 177
}
console.log(height); // 175