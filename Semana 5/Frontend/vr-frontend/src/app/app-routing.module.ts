import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { CreateRequestComponent } from './components/create-request/create-request.component';
import { SeeRequestComponent } from './components/see-request/see-request.component';
import { MarkCompletedComponent } from './components/mark-completed/mark-completed.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'createRequest', component: CreateRequestComponent },
  { path: 'requestList', component: SeeRequestComponent },
  { path: 'completedRequest', component: MarkCompletedComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
