import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import { CreateRequestComponent } from './components/create-request/create-request.component';
import { SeeRequestComponent } from './components/see-request/see-request.component';
import { MarkCompletedComponent } from './components/mark-completed/mark-completed.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginHrComponent } from './components/login-hr/login-hr.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    CreateRequestComponent,
    SeeRequestComponent,
    MarkCompletedComponent,
    LoginComponent,
    LoginHrComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
