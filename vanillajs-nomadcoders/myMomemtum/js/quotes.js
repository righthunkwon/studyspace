const quotes = [
    {
        quote: 'Nothing great in the world has been accomplished without passion.',
        author: 'Georg Wilhelm'
    },
    {
        quote: 'Nothing is stronger than habit.',
        author: 'Ovid'
    },
    {
        quote: 'Strive for excellence, not perfection.',
        author: 'H. Jackson Brown Jr.'
    },
    {
        quote: 'There is no security on this earth, there is only opportunity.',
        author: 'General Douglas MacArthur.'
    },
    {
        quote: 'Great minds have purposes, others have wishes.',
        author: 'Washington Irving'
    },
    {
        quote: 'He whom you cannot teach to fly, teach to fall faster!',
        author: 'Friedrich Nietzsche'
    },
    {
        quote: 'He who can, does. He who cannot, teaches.',
        author: 'George Bernard Shaw'
    },
    {
        quote: 'The great aim of education is not knowledge but action.',
        author: 'Herbert Spencer'
    },
    {
        quote: 'Never leave that until tomorrow which you can do today.',
        author: 'Benjamin Franklin'
    },
    {
        quote: 'You may delay, but time will not.',
        author: 'Benjamin Franklin'
    },
];

const quote = document.querySelector("#quote div:first-child");
const author = document.querySelector("#quote div:last-child");
const todaysQuote = quotes[Math.floor(Math.random() * quotes.length)];

// Math.random()    : 0~1 사이의 무작위의 수
// Math.round()     : 반올림
// Math.ceil()      : 올림
// Math.floor()     : 버림

quote.innerText = todaysQuote.quote;
author.innerText = "\n\n - " + todaysQuote.author;
