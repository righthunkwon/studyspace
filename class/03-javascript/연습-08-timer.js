// 10초 타이머
// 10, 9, 8, ... , 1, 0
// let time = 10
// setInterval(function() {
//     if(time >= 0) {
//         console.log(time)
//         time = time -1
//     }
// }, 1000)

// 3분 타이머 (형식은 3:00(분:초))
let time = 180
setInterval(function() {
    if(time >= 0) {
        let min = Math.floor( time / 60 )
        let sec = String(time % 60).padStart(2, "0")
        console.log(min + ":" + + sec)
        time = time -1
    }
}, 1000)