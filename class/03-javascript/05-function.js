const sendVerificationCode = () => {
    const token = String(Math.floor(Math.random() * 1000000)).padStart(6, "0")
    document.getElementById("verification__code").innerText = token
    document.getElementById("verification__code").style.color = "#" + token
}
