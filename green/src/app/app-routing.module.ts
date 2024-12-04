import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FormComponent } from './form/form.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';

const routes: Routes = [

  {
    path: 'login',
    component:LoginComponent
  },
  {
    path:'',
    component:LoginComponent
  }
  ,{
    path:'form/:username',
    component:FormComponent
  },
  {
    path:'leaderboard/:username',
    component:LeaderboardComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
