const btnList = document.querySelectorAll(".movie-like-btn");
console.log(btnList);

btnList.forEach((btn) => {
    btn.addEventListener("click", function (event) {
        let originData = btn.closest(".movie-info-wrap").innerText;
        console.log(originData);
    });
});