// 무작위 여섯 자리 숫자 생성(핸드폰 문자 인증번호)
String(Math.floor(Math.random() * 1000000)).padStart(6, "0")