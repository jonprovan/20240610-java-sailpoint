/**
 * ARRAYS IN JS
 * 
 * arrays in JS use index notation
 * they collect items together
 * 
 * DIFFERENCES
 * arrays DO NOT have a fixed size -- can be shortened/lengthened whenever
 * you can put ANYTHING into a given array -- any type, any object, any other array, any combination of those
 * 
 * In TypeScript, you CAN type an array to force its contents to be homogenous
 */

let myArray = [ 1, 'a', true, { job: 'Millworker'}, [ 1, 2, 3 ], undefined ];

let nums = [ 2, 4, 6, 8, 10 ];

console.log(nums[3]);

nums[3] = 16;
console.log(nums[3]);

// we have a bunch of List-type functions available with arrays

// push adds to the end
nums.push(22);
console.log(nums);

// pop removes it from the end
console.log(nums.pop());
console.log(nums);

// unshift adds to the beginning
nums.unshift(44);
console.log(nums);

// shift removes from the beginning
console.log(nums.shift());
console.log(nums);

// to operate as a queue, we'd push, then shift (in right, out left)
// or, unshift and then pop (in left, out right)

let nums2 = [ 1, 2, 3, 4, 5 ];
let nums3 = nums2;

console.log(nums2);
console.log(nums3);

// this changes the value in BOTH arrays, since they're linked
nums2[2] = 100;

console.log(nums2);
console.log(nums3);

nums2[2] = 3;

// to avoid this, we can destructure the array when copying it over
// ... here is the spread operator -- it "spreads out" the values of nums2 into nums3 and breaks the object connection
nums3 = [ ...nums2 ];

console.log(nums2);
console.log(nums3);

nums2[2] = 100;

console.log(nums2);
console.log(nums3);

nums2[2] = 3;

// can be part of adding other parameters
nums4 = [ -2, -1, 0, ...nums2, 6, 7, 8];

console.log(nums4);

// to copy part or all of an array to a new location
// arrayName.slice -- first parameter is the first index to grab (inclusive), second is the last index to grab (exclusive)
// this copies the included values over and breaks the object link as well
nums5 = nums2.slice(1, 4);

console.log(nums5);

nums2[2] = 100;

console.log(nums2);
console.log(nums5);

nums2[2] = 3;

// splice allows you to insert or remove elements into an array, or both at once

let movies = [ 'Looper', 'Up', 'Jaws', 'Dune', 'Cars' ];

console.log(movies);

// to remove only
// first param = starting index, second param = how many to remove
movies.splice(2, 1);
console.log(movies);

// to add only
// first and second params = same as above, third and additional params = things we want to add at that spot
movies.splice(3, 0, 'Jaws', 'Pi');
console.log(movies);

// to remove AND add at the same time
// movies.splice(1, 4, 'Reds');
// console.log(movies);

// moving items around...gets tricky!
// splice returns the excised elements in an array
// have to keep track of how long the array is after the first splice
movies.splice(3, 0, ...movies.splice(0, 2));
console.log(movies);