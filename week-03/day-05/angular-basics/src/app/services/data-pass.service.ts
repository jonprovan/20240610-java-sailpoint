import { Injectable } from '@angular/core';
import { Department } from '../models/department';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataPassService {

  // Services are perfect for passing data between unrelated components
  // "unrelated" in a DOM sense, i.e., distant from each other structurally

  // services ALSO maintain their data as long as the app is running
  // they are singletons (only one instance globally)
  // and since they are never visible, they are never destroyed
  // and their data persists
  constructor() { }

  favoriteDepartment: Department = new Department(0,'',[]);

  // a BehaviorSubject alerts its observable whenever it's changed
  faveDeptSubject = new BehaviorSubject<Department>(this.favoriteDepartment);

  // this takes our BehaviorSubject and makes it into an Observable
  faveDeptObservable = this.faveDeptSubject.asObservable();

  updateFavoriteDepartment(department: Department) {
    this.favoriteDepartment = department;
    // this updates our subject to its next state and triggers the observable
    this.faveDeptSubject.next(this.favoriteDepartment);
  }
}
