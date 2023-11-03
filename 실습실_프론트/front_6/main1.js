// 문제 1
const name = "Kwon";
const birthday = "1996.06.17";
let job = "Student";

const info = `내 이름은 ${name}이고, ${birthday}에 태어났습니다. 제 직업은 ${job}입니다.`;

// 문제 2
const Movie = {
    title: "기생충",
    director: "봉준호",
    genre: "드라마",
    runningTime: 132,
};

function showMovie({title, director, genre, runningTime}) {
    console.log(title);
    console.log(director);
    console.log(genre);
    console.log(runningTime);
}
showMovie(Movie);

// 문제 3
Movies = ["기생충", "이터널스", "킹스맨", "스파이더맨", "해리포터"];
Movies.forEach(movie => {
    console.log(movie)
});

// 문제 4
let cube = (a) => {
   console.log(Math.pow(a, 3));
}
cube(5);

// 문제 5
const arr = [1,2,3,4,5];
const doubledArr = arr.map(element => element * 2);
console.log(doubledArr);