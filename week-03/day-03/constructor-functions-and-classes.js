/**
 * CONSTRUCTOR FUNCTIONS AND CLASSES IN JS
 * 
 * In JS, under the hood, what is a class?
 * Basically a function...we create a function that outputs objects with a certain structure
 * This can be abstracted pretty deeply
 */

// a constructor function
function Desk(height, width, material, manufacturer) {
    this.height = height;
    this.width = width;
    this.material = material;
    this.manufacturer = manufacturer;
}

// using "new Desk" creates an "instance" from my constructor function
let desk1 = new Desk(12, 24, 'Wood', 'IKEA');
let desk2 = new Desk(35, 60, 'Metal', "Biff's Desk Farm");

console.log(desk1);
console.log(desk2);

// you can use class syntax to get even closer to familiar java formatting
// but, under the hood, it's doing the same thing

class ClassDesk {

    // properties
    height;
    width;
    material;
    // # before a property makes it private
    #manufacturer;
    // can have static variables, too, that belong to the "class" itself
    static numberOfDesks = 1000;

    // constructor
    constructor(height, width, material, manufacturer) {
        this.height = height;
        this.width = width;
        this.material = material;
        // have to use the hashtag when referring to the private variable name
        this.#manufacturer = manufacturer;
    }

    // getter and setter for #manufacturer
    get manufacturer() {
        return this.#manufacturer;
    }

    set manufacturer(manufacturer) {
        this.#manufacturer = manufacturer;
    }

}

let cd1 = new ClassDesk(11, 22, 'Teak', 'WalMart');

console.log(cd1);
console.log(cd1.manufacturer);
cd1.manufacturer = 'Doug The Deskmaker';
console.log(cd1.manufacturer);

console.log(ClassDesk.numberOfDesks);
