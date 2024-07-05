/**
 * HIGHER-ORDER FUNCTIONS
 * 
 * in JS, functions get thrown around a little more easily than in Java
 * 
 * we can:
 * store a function as a variable
 * we can enter a function as a parameter
 * we can also return a function from a method
 * 
 * there's also idea of a closure
 * - a function returned from another function that has embedded in it some context from the original function
 */

// three ways of creating a function
function myFunction() {
    return 'This is my Function!';
}

let myFunction2 = function() {
    return 'This is my Function2!'
}

let myFunction3 = () => 'This is my Function3!';

console.log(myFunction());
console.log(myFunction2());
console.log(myFunction3());

function myFunctionReturner() {
    return (x, y) => x + y;
}

let myReturnedFunction = myFunctionReturner();

// this is what myReturnedFunction is after the above
// function myReturnedFunction(x, y) {
//     return x + y;
// }

console.log(myReturnedFunction(1, 2));

// CLOSURES
// functions which, when returned, contain context from the original function
function timesX(x) {
    return (y) => y * x;
}

let times10 = timesX(10);
let times100 = timesX(100);

console.log(times10(5));
console.log(times100(5));

class Employee {
    name;
    department;
    company;

    constructor(name, department, company) {
        this.name = name;
        this.department = department;
        this.company = company;
    }
}

function deparmentalEmployeeGenerator(department) {
    return (name) => new Employee(name, department, 'SkillStorm');
}

let trainingDeptGenerator = deparmentalEmployeeGenerator('Training');
let accountingDeptGenerator = deparmentalEmployeeGenerator('Accounting');

console.log(trainingDeptGenerator('Biff'));
console.log(accountingDeptGenerator('Mary'));

// array operations using lambda inputs
let nums = [ 1, 2, 3, 4, 5 ];

// foreach
// returns void, requires a consumer (a void function) as a parameter
nums.forEach(num => console.log(num * 3));

// map
// returns an array, requires a supplier (a function that returns something) as a parameter
let mapResult = nums.map(num => num + 66);

console.log(mapResult);

// filter
// returns an array, requires predicate (a function that returns true or false based on a condition) as a parameter
// if true, original value will be included in the returned array; if false, it won't
let filterResult = nums.filter(num => num % 2 === 1);

console.log(filterResult);

// reduce
// returns a single value, requires an accumulator (a function that assembles things into a single value somehow) as a parameter
// first param is the accumulator function, second is the optional starting value
let reduceResult = nums.reduce((num1, num2) => {
    return num1 + num2;
}, 20);

console.log(reduceResult);

let emp1 = new Employee('Jim', 'Training', 'SkillStorm');
let emp2 = new Employee('Martha', 'Accounting', 'SkillStorm');
let emp3 = new Employee('Mrs. Hannigan', 'Childcare', 'The Orphanage');

let emps = [ emp1, emp2, emp3 ];

let finalEmp = emps.filter(emp => emp.company === 'SkillStorm')
                   .reduce((emp1, emp2) => emp1.department.length > emp2.department.length ? emp1 : emp2 );

console.log(finalEmp);