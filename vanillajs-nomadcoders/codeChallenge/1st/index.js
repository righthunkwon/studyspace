// <⚠️ DONT DELETE THIS ⚠️>
const colors = ["#1abc9c", "#3498db", "#9b59b6", "#f39c12", "#e74c3c"];
// <⚠️ /DONT DELETE THIS ⚠️>

/*
✅ The text of the title should change when the mouse is on top of it.
✅ The text of the title should change when the mouse is leaves it.
✅ When the window is resized the title should change.
✅ On right click the title should also change.
✅ The colors of the title should come from a color from the colors array.
✅ DO NOT CHANGE .css, or .html files.
✅ ALL function handlers should be INSIDE of "superEventHandler"
*/
const superEventHandler = {
    handleMouseOver: function () {
        const title = document.querySelector("h2");
        title.innerText = "The mouse is here!";
        title.style.color = colors[0];
      },
      handleMouseOut: function () {
        const title = document.querySelector("h2");
        title.innerText = "The mouse is gone!";
        title.style.color = colors[1];
      },
      handleResize: function () {
        const title = document.querySelector("h2");
        title.innerText = "You just resized!";
        title.style.color = colors[2];
      },
      handleRightClick: function () {
        const title = document.querySelector("h2");
        title.innerText = "That was a right click!";
        title.style.color = colors[4];
      },
};
    
const title = document.querySelector("h2");
    
title.addEventListener("mouseover", superEventHandler.handleMouseOver);
title.addEventListener("mouseout", superEventHandler.handleMouseOut);
window.addEventListener("resize", superEventHandler.handleResize);
window.addEventListener("contextmenu", superEventHandler.handleRightClick);

