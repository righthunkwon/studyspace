function fn() {
    console.log(1);
}

function fn() {
    console.log(2);
}

function fn(num) {
    console.log(num);
}

// js에서는 동일한 함수를 만들면 덮어쓰기가 된다.
fn(); // undefined
fn(3); // 1