const startWord = () => {
    let myword = document.getElementById("myword").value // 입력어
    let word = document.getElementById("word").innerText // 제시어

    let lastword = word[word.length - 1] // 제시어의 마지막 글자
    let firstword = myword[0] // 입력어의 첫글자

    if(lastword === firstword) {
        // 정답일 때
        document.getElementById("result").innerText = "정답입니다!"
        document.getElementById("word").innerText = myword
        document.getElementById("myword").value = ""
    } else {
        document.getElementById("result").innerText = "땡!"
        document.getElementById("myword").value = ""
    }
}