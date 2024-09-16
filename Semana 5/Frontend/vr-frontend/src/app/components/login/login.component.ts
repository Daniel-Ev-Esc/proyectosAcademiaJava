import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee';
import { SessionService } from 'src/app/session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(
    private router: Router,
    private http: HttpClient,
    private sessionService: SessionService
  ) {}

  onSubmit() {
    const email = this.username;
    const url = `http://localhost:8080/employees/get-profile/${email}`;

    this.http.get<Employee>(url).subscribe(
      (data) => {
        this.sessionService.setEmployee(data);
        this.router.navigateByUrl('/createRequest');
      },
      (error) => {
        console.error('Error fetching employee profile:', error);
      }
    );
  }

  gotoHR() {
    this.router.navigateByUrl('/hr');
  }
}
