// 반복문 실습 1

let persons = [
    {name: "철수", age: 17},
    {name: "영희", age: 22},
    {name: "도우너", age: 5},
    {name: "그루트", age: 65},
    {name: "도비", age: 3},
]
// undefined
for(let i = 0; i < persons.length; i++) {
    if(persons[i].age >= 19) {
        console.log(persons[i].name + "님은 성인입니다")
    } else {
        console.log(persons[i].name + "님은 미성년자입니다")
    }
}
// VM1973:5 철수님은 미성년자입니다
// VM1973:3 영희님은 성인입니다
// VM1973:5 도우너님은 미성년자입니다
// VM1973:3 그루트님은 성인입니다
// VM1973:5 도비님은 미성년자입니다
// undefined


// 반복문 실습 2
const fruits = [
    {number: 1, title: "레드향" },
    {number: 2, title: "샤인머스켓" },
    {number: 3, title: "산청딸기" },
    {number: 4, title: "한라봉" },
    {number: 5, title: "사과" },
    {number: 6, title: "애플망고" },
    {number: 7, title: "딸기" },
    {number: 8, title: "천혜향" },
    {number: 9, title: "과일선물세트" },
    {number: 10, title: "귤" },
]
// 방법 1
for(let i = 0; i < fruits.length; i++) {
    console.log(fruits[i].number + " " + fruits[i].title)
}
// 방법 2 (` : 백틱 활용)
for(let i = 0; i < fruits.length; i++) {
    console.log(`${fruits[i].number} ${fruits[i].title}`)
}
// 방법 3 (` : 백틱 활용, 문자열과 함께 사용할 때는 백틱을 활용하자!!!) 
for(let i = 0; i < fruits.length; i++) {
    console.log(`과일 차트 ${fruits[i].number}위는 ${fruits[i].title}입니다.`)
}