// this is a model for our Department objects
// we use it to force data into this format, so we can be sure we're
// sending the right data to the backend
// and formatting backend data in the right way for view

export class Department {

    departmentId: number;
    departmentName: string;
    employees: any[];

    constructor(departmentId: number, departmentName: string, employees: any[]) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = employees;
    }

}
