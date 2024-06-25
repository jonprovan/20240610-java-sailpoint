// all the standard boolean operations apply in JS

console.log(6 > 5);

console.log(6 > 5 && 5 > 6);

console.log(6 > 5 || 5 > 6);

// equality is a little odd in JS

console.log(6 == 6);
console.log(6 == "6");
console.log(6 === "6");     // this is the strict equality operator, checks type AND value
// ...is the same as...
console.log(6 == "6" && typeof 6 == typeof "6");

if(10) {
    console.log('Condition was true.');
}

/**
 * TRUTHY OR FALSY
 * 
 * JS will assess the boolean "quality" of something based on its truthiness or falsiness
 * 
 * Values That Are Falsy
 * 0
 * 0.0
 * -0
 * 0n
 * undefined
 * false
 * null
 * '' or ""
 * NaN
 * 
 * Values That Are Truthy
 * ANYTHING that is not falsy
 * -123
 * "false"
 * true
 * 45.56
 * .000001n
 * []
 * {}
 * 
 */

if({}) {
    console.log('The value is truthy.')
}

let myString = '';

if('') {
    console.log('My string was not empty.');
}

// ternaries apply here too
const answer = (myString === '') ? 'No String' : myString;

console.log(answer);

// some ternary shorthand
// equivalent to "if the first value is falsy, assign the second value; otherwise, assign the first"
const choice = 0 || 'Choice';

console.log(choice);

// if you want to actually parse the statement as true/false, wrap it in a Boolean
const choice2 = Boolean(0 || 'Choice');

console.log(choice2);

// using the above, we can't get back the first value if it's falsy, even if we want to
// JS has something called the nullish coalescing operator to solve this problem
// it returns the first value as long as the first value is not null or undefined
const choice3 = false ?? 'Choice';

console.log(choice3);