const msgContainer = document.querySelector('#d-day-message');
const container = document.querySelector('#d-day-container');
// container.style.display = 'none';
msgContainer.innerHTML = 'D-Day를 입력해 주세요.';

const dateFormMaker = function () {
    const inputYear = document.querySelector('#target-year-input').value;
    const inputMonth = document.querySelector('#target-month-input').value;
    const inputDate = document.querySelector('#target-date-input').value;

    // const dateFormat = inputYear + '-' + inputMonth + '-' + inputDate;
    const dateFormat = `${inputYear}-${inputMonth}-${inputDate}`;
    // return : 함수의 종료, 지역변수를 꺼내쓸 수 있다.
    return dateFormat;
}

const counterMaker = function () {
    const targetDateInput = dateFormMaker(); // dateFormat 반환
    const nowDate = new Date();
    const targetDate = new Date(targetDateInput).setHours(0, 0, 0, 0); // setHours(0, 0, 0, 0) : 기준 시간은 09시인데 이를 0시로 초기화
    const remaining = (targetDate - nowDate) / 1000;
    if (remaining <= 0) {
        msgContainer.innerHTML = '유효한 시간대가 아닙니다.';
    } else if (isNaN(remaining)) {
        msgContainer.innerHTML = '유효한 시간대가 아닙니다.';
    }

    const remainingObj = {
        remainingDate: Math.floor(remaining / 3600 / 24),
        remainingHours: Math.floor(remaining / 3600) % 24,
        remainingMin: Math.floor(remaining / 60) % 60,
        remainingSec: Math.floor(remaining) % 60
    }

    const documentObj = {
        days: document.getElementById('days'),
        hours: document.getElementById('hours'),
        min: document.getElementById('min'),
        sec: document.getElementById('sec')
    }

    const timeKeys = Object.keys(remainingObj);
    const docKeys = Object.keys(documentObj);

    for (let i = 0; i < 10; i = i + 1) {
        documentObj[docKeys[i]].textContent = remainingObj[timeKeys[i]];
    }

}