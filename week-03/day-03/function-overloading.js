/**
 * FUNCTION OVERLOADING IN JS
 * 
 * There is no function overloading in JS.
 */

// this overload doesn't work because the second method declaration just overwrites the first
// function myFunction(x) {
//     console.log(x);
// }

// function myFunction(x, y) {
//     console.log(x + y + "Test");
// }

// myFunction('Does it work?');

// variables not fed by a function call will be undefined, so we can use that for some logic
function add(x, y) {
    if (y === undefined)
        console.log(x);
    else (console.log(x + y));
}

add(3);
add(3, 4);


// we can supply default values for variables in the method signature
function multiply(x, y = 1) {
    console.log(x * y);
}

multiply(2, 3);
multiply(4);

// can base default values on other method variables
function calcArea(w, h = w) {
    console.log(w * h);
}

calcArea(4, 8);
calcArea(4);

function printPerson(name, age, job) {
    if (name === undefined)
        name = 'Default Name';

    console.log("Name = " + name);
    console.log(`Age = ${age}`);        // this syntax allows us to insert variable values into a template string
    console.log("Job = " + job)
}

printPerson('Beth', 29, 'Milkmaid');

// can't call to the method variable names, because the method call has no idea what they are
// printPerson(age = 50, job = 'Parking Attendant', name = 'Jose');

// can 'skip' a parameter by passing in undefined
printPerson(undefined, 66, 'Overlord');

// what if we don't know how many arguments could be passed?
// what if there could be ANY number of arguments passed?

// we can use the rest operator (nothing to do with REST APIs) -- ...<variableName>
// this MUST be the last parameter in the list, and you can only use it once per function
// collects all additional intake parameters into an array called whatever you designate
// if there are no parameters feeding into it, it still creates an empty array
function addAllNumbers(x, y, ...theRest) {
    console.log(x);
    console.log(y);
    console.log(theRest);

    let startingSum = x + y;
    for (let num of theRest) {
        startingSum += num;
    }

    console.log(startingSum);
}

addAllNumbers(2, 7, 8, 9, 0, 12, 43, -22, 5.5);
