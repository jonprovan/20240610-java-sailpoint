import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DepartmentsComponent } from './departments/departments.component';

// creating routes for our router outlet
// each "page" needs a route
// each route includes a URL path and a Component to load
// these can be linked to by typing in the full URL
// or routerlinking to each path
export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'departments',
        component: DepartmentsComponent
    }
];
