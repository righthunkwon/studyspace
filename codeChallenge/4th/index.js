const clockTitle = document.querySelector(".js-clock");

function getD_day() {
    const targetDate = new Date("2023-12-25T00:00:00"); // 목표날짜(크리스마스)
    const currentDate = new Date(); // 현재날짜
    const dateDiff = targetDate.getTime() - currentDate.getTime(); // 날짜 차이
    
    // 디데이(단위 : 밀리초)
    const days = String(Math.floor(dateDiff/(1000*60*60*24)));
    const minutes = String(Math.floor((dateDiff%(1000*60*60))/(1000*60))).padStart(2, '0');
    const seconds = String(Math.floor((dateDiff%(1000*60))/1000)).padStart(2, '0');
    const hours = String(Math.floor((dateDiff%(1000*60*60*24))/(1000*60*60))).padStart(2, '0');

    clockTitle.innerText = `${days}d ${hours}h ${minutes}m ${seconds}s`;
}

getD_day();
setInterval(getD_day, 1000);
