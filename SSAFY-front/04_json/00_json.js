// Object
let student = {
    name: "권정훈",
    age: 28,
    hobbies: ["유튜브", "커피", "맛집"],
}
console.log(student);

// JSON.stringify
// JavaScript Object => JSON String(data)
let studentStr = JSON.stringify(student);
console.log(studentStr);


// JSON.parse
// JSON String(data) => JavaScript Object
let someStr = `{"name":"권정훈","age":28,"hobbies":["유튜브","커피","맛집"]}`;
let studentObj = JSON.parse(someStr);

console.log(typeof student); // object
console.log(typeof studentObj); // object
console.log(typeof studentStr); // string
console.log(typeof someStr); // string