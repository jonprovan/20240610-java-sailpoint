/**
 * LOOPS IN JS
 * 
 * For the most part, loops work exactly the same way as in Java (one exception)
 * This applies to flow control elements like if, else, else-if, etc. as well
 */

let nums = [ 1, 2, 3, 4, 5 ];

let counter = 0;

// while
while (counter < 5) {
    console.log(nums[counter++]);
}

counter = 0;

// do-while
do {
    console.log(counter++);
} while (counter < 0)

// standard for
// we say let i instead of int i in this case
for (let i = 0; i < 5; i++) {
    console.log(`Index of for loop is: ${i}`);
}

// enhanced for
// functionality we expect is with of instead of the colon, not in
for (let num of nums) {
    console.log(num * num);
}

// this doesn't work with objects
// objects are not iterable
const stringHolder = {
    string1: 'One',
    string2: 'Two',
    string3: 'Three',
    string4: 'Four',
    string5: 'Five'
}

// must use for in, instead of for of
// this is enumerating an object, which functionally gets the key for each property and stores it temporarily for use
// BUT...this just prints out the keys, so how do we use this to get the values...?
for (let property in stringHolder) {
    console.log(property);
}

// must use the properties as "indices" to access the values from our temp "array" of the stringHolder object
for (let property in stringHolder) {
    console.log(stringHolder[property]);
}

/**
 * In Angular, looping through objects and creating HTML will look more like this on the page itself
 * 
 * <h1>{{ object.name }}</h1>
 * <ul>
 *      <li>{{ object.year }}</li>
 *      <li>{{ object.description }}</li>
 * </ul>
 */
