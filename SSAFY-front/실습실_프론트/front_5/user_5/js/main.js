window.onload = function () {
  if (!document.querySelector(".content-user-list-ul")) return;
  // 비동기 통신을 위해 새로운 xmlhttp 요청 생성
  const xhr = new XMLHttpRequest();
  // 요청 method
  const method = "GET";
  // 파일 위치
  const url = "./data/user.json";

  // 경로 특강
  // /   : 루트폴더
  // ./  : 현재폴더(보통 사용)
  // ../ : 상위폴더

  // 위의 method 와 url 로 비동기 요청 초기화
  xhr.open(method, url, true);
  // 요청 헤더 설정
  xhr.setRequestHeader("Content-Type", "application/text");
  // 요청 동작 설정
  xhr.onreadystatechange = function () {
    if (xhr.readyState === xhr.DONE) {
      // 요청 상태가 OK 이면
      if (xhr.readyState === XMLHttpRequest.DONE) {
        // Json 객체 형태로 응답 받기
        const resJson = JSON.parse(xhr.responseText);
        const userData = resJson.users;
        // 사용자 data 삽입할 html 요소 찾기
        let userList = document.querySelector(".content-user-list-ul");
        for (let i = 0; i < userData.length; i++) {
          let carItem = `
            <li>
              <div class="list-item">
                <div>
                  <img src="${userData[i]["img"]}" alt="" />
                </div>
                <div class="user-info">
                  <div>
                    <div>${userData[i]["id"]}</div>
                    <div>${userData[i]["name"]}</div>
                    <div>${userData[i]["email"]}</div>
                    <div>${userData[i]["age"]} 세</div>
                  </div>
                </div>
              </div>
            </li>
            `;
          userList.innerHTML += carItem;
        }
      }
    }
  };

  // 요청 보내기
  xhr.send();
};

function regist() {
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let age = document.getElementById("age").value;

  if (!id || !password || !name || !email || !age) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const user = {
      id: id,
      password: password,
      name: name,
      email: email,
      age: age,
    };

    localStorage.setItem("user", JSON.stringify(user));
    alert("사용자 등록 성공!");
    window.location.replace("login.html");
  }
}

function login() {
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;

  const user = JSON.parse(localStorage.getItem("user"));

  if (
    user.id &&
    user.password &&
    user.id === id &&
    user.password === password
  ) {
    alert("로그인 성공 !");
    window.location.replace("index.html");
  } else {
    alert("로그인 실패 !");
  }
}
