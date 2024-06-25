// single-line comment in JavaScript
/*
 * multi-line comment in JavaScript
 * here's another line...yay!
 * 
 * JavaScript (JS) is what the user's browser will run locally for scripting/functionality purposes
 * It's served up from our Angular application along with HTML/CSS
 * 
 * TypeScript is JS with strict types, i.e., if we have a Department type, our object has to match that template
 * 
 * JS variables can hold anything (a variable holding a String can be filled with an Integer, etc.)
 * - not so in TS -- once a variable is declared with a certain type, that's all it can hold
 * 
 * All versions of JS/TS are back-compiled to the original JS runtime
 * - all newer features are just abstractions atop the original kernel
 * 
 * Speed of execution is largely dependent on the user's computer -- not so much an issue anymore
 * 
 * JS can make reference to objects in the DOM -- e.g., replacing the text inside a specific div tag, etc.
 * - this is what Angular is doing under the hood
 * 
 * JS is single-threaded -- you cannot make another thread, you only ever have one
 * - async operations are sent off to the side in something called the JS Event Loop
 * - they return from the event loop and are processed when they can be in the single thread
 * 
 * As such, most operations are run top-to-bottom in our code, with some exceptions
 * 
 */

// variable declaration
// three ways to declare a variable in JS -- var, let, const
/**
 * var -- global variable
 * - its declaration is "hoisted" no matter where it is in our code
 * - even if I declare it in a deeply-nested way, it's still available outside that scope
 * - best practice = never use var
 * 
 * let -- block-scoped variable (even if that block is the whole file)
 * - behaves like a regular Java block-scoped variable
 * - its declaration is only available AFTER the line containing it
 * - it ceases to exist once it's out of scope
 * 
 * const - just like let, but you can't change the value once it's initialized
 */


// calling my hoisted function
console.log(addTwoNumbers(6, 7));

var myVar = 5;

console.log(myVar);

console.log(myOtherVar);

// this declaration gets hoisted, but NOT the value with which it's initialized
var myOtherVar = 10;

console.log(myOtherVar);

console.log(myThirdVar);

if(true) {
    if(true) {
        if(true) {
            var myThirdVar = 33;
        }
    }
}

// let works better (more predictably)
let myLet = 7;

console.log(myLet);

// console.log(myOtherLet);

let myOtherLet = 11;

// you can redeclare variables at different scopes
// avoid the complications by using different variable names that don't conflict

console.log();

let x;
x = 1;

console.log(x);

if(true) {
    let x = 2;
    console.log(x);
}

console.log(x);

// const -- like let, but for a constant
const myConst = 65;
// myConst = 66;  // can't do this, because it's a constant

const myConstObj = { name: "Franz" };

myConstObj.name = "Hanz";

console.log(myConstObj.name);

// only throws the error at runtime IF it occurs

// let num = Math.floor(Math.random()*2);
// console.log(num);

// if(num == 1) {
//     myConst = 45;
// }

// can't access object properties if the object is null (kinda like a NullPointerException)
// const myOtherObj = null;

// console.log(myOtherObj.name);


/**
 * DATA TYPES IN JS
 * 
 * Numerical Data Types
 * number -- whole and decimal numbers, essentially byte, short, int, long, float and double all in one -- 1, -34.4, 12345, etc.
 * BigInt -- a giant number with essentially no cap, 234n, 893274923058724985723408752n, -123n, etc. 
 * 
 * Alphanumeric Data Types
 * string -- all single- or multiple-character alpanumeric values -- 'abc', "SDSA", '8', "......."
 * 
 * Other Types
 * boolean - true/false
 * array - [ 1, 2, 3, 4, 5 ]
 * object - { name: "James", age: 56 }
 * undefined - a variable has yet to be initialized
 * null - an object has no assigned value
 * NaN - not a number, this is technically of type number
 * 
 */

// you can recreate and reassign a const; each one stops existing after its iteration
for(let i = 0; i < 5; i++) {
    const xx = i;
    console.log(xx);
}

// xx ceases to exist after each block
// console.log(xx);

console.log(typeof []);

// functions are fully hoisted; I can declare them anywhere and call them anywhere

function addTwoNumbers(one, two) {
    return one + two;
}

// call functions just like you do in Java
console.log(addTwoNumbers(6, 7));

console.log(addTwoNumbers("a", "b"));