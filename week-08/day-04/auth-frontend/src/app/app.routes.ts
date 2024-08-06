import { Routes } from '@angular/router';
import { BasicComponent } from './basic/basic.component';
import { TokenComponent } from './token/token.component';
import { OauthComponent } from './oauth/oauth.component';

export const routes: Routes = [
    {
        path: '',
        component: BasicComponent
    },
    {
        path: 'token',
        component: TokenComponent
    },
    {
        path: 'oauth',
        component: OauthComponent
    }
];
