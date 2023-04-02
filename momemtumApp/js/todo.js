const toDoForm = document.getElementById("todo-form");
const toDoInput = document.querySelector("#todo-form input");
const toDoList = document.getElementById("todo-list");
const TODOS_KEY = "todos";
let toDos = [];

function saveToDos() {
    localStorage.setItem(TODOS_KEY, JSON.stringify(toDos));
}

function deleteTodo(event) {
    // 버튼 중 어느 버튼이 클릭되었는지 확인
    // → parentNode 혹은 parentElement 확인
    const li = event.target.parentElement;
    li.remove();
    toDos = toDos.filter(toDo => toDo.id !== parseInt(li.id));
    saveToDos();
    localStorage.removeItem(TODOS_KEY);
    localStorage.setItem(TODOS_KEY, JSON.stringify(toDos));
}

function paintToDo(newTodoObj) {
    // 조건
    const li = document.createElement("li"); // li 생성
    li.id = newTodoObj.id;
    const span = document.createElement("span"); // span 생성
    span.innerText = newTodoObj.text; // span에 newTodo 삽입

    const button = document.createElement("button"); // button 생성
    button.innerText = " ✅ "; // button에 test 삽입
    button.addEventListener("click", deleteTodo);

    li.appendChild(span); // li 안에 span 삽입 (이후에 delete를 위함)
    li.appendChild(button); // li 안에 button 삽입

    // li 생성
    toDoList.appendChild(li);
}

function handleToDoSubmit(event) {
    event.preventDefault();
    const newTodo = toDoInput.value; // ToDo의 값을 저장
    toDoInput.value = ""; // ToDo input을 비움

    // Object
    const newTodoObj = {
        text:newTodo,
        id: Date.now(),
    }
    toDos.push(newTodoObj); // array에 저장
    paintToDo(newTodoObj);
    saveToDos();
}
toDoForm.addEventListener("submit", handleToDoSubmit);

const savedToDos = localStorage.getItem(TODOS_KEY);

if(savedToDos !== null) {
    const parsedToDos = JSON.parse(savedToDos);
    toDos = parsedToDos;
    parsedToDos.forEach(paintToDo);
}
