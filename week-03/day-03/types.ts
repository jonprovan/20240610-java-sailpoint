// TYPES IN TYPESCRIPT AT A GLANCE

// I can create a type that a new object must match

type Department = {
    department_id: number;
    department_name: string;
}

let dept: Department = {
    department_name: 'Accounting',
    department_id: 4
}

console.log(dept);