/**
 * OBJECTS IN JS
 * 
 * Objects in JS are more lightweight/flexible than Object in Java
 * 
 * In many ways, they function the same way
 * - they can have properties and methods
 * - we can assign them to variables
 * 
 * BUT, we can add properties at will
 * - we can also delete properties
 * - a little easier to see if they're equal to each other
 */

// creating an object
// methods use lambda syntax
let myPizza = {
    toppingOne: 'Pepperoni',
    toppingTwo: 'Cheese',
    yearMade: 2024,
    sayName: () => console.log('I am a pizza!')
}

console.log(myPizza);

// accessing a property
console.log(myPizza.yearMade);

// changing a property
myPizza.yearMade = 2023;
console.log(myPizza);

// adding a property
myPizza.crustType = 'Stuffed';
console.log(myPizza);

// removing a property
delete myPizza.crustType;
console.log(myPizza);

// calling my method
myPizza.sayName();

// will come back to this
// let myPizza2 = {
//     toppingOne: 'Pepperoni',
//     toppingTwo: 'Cheese',
//     yearMade: 2023,
//     sayName: () => console.log('I am a pizza!')
// }

// this points to the same object, so they are linked
let myPizza2 = myPizza;

console.log(myPizza);
console.log(myPizza2);

myPizza.toppingOne = 'Sausage';

console.log(myPizza);
console.log(myPizza2);

// this spreads out the properties, applies them to a new object, and breaks the connection
myPizza2 = { ...myPizza };

console.log(myPizza);
console.log(myPizza2);

myPizza.toppingOne = 'Pepperoni';

console.log(myPizza);
console.log(myPizza2);