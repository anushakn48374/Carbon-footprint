import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormComponent } from './form/form.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import { IntergateService } from './form/intergate.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';

import { ToastrModule } from 'ngx-toastr'; // Import ToastrModule
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [AppComponent,LoginComponent,FormComponent,LeaderboardComponent],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule,ReactiveFormsModule,FormsModule,NgxSpinnerModule,HttpClientModule,  ToastrModule.forRoot(),  BrowserAnimationsModule ],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  bootstrap: [AppComponent],
})
export class AppModule {}
