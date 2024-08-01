import { Routes } from '@angular/router';
import { BasicComponent } from './basic/basic.component';
import { TokenComponent } from './token/token.component';

export const routes: Routes = [
    {
        path: '',
        component: BasicComponent
    },
    {
        path: 'token',
        component: TokenComponent
    }
];
