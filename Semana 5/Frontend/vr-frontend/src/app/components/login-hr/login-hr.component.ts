import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee';
import { SessionService } from 'src/app/session.service';

@Component({
  selector: 'app-login-hr',
  templateUrl: './login-hr.component.html',
  styleUrls: ['./login-hr.component.css'],
})
export class LoginHrComponent {
  username: string = '';
  password: string = '';

  constructor(
    private router: Router,
    private http: HttpClient,
    private sessionService: SessionService
  ) {}

  onSubmit() {
    this.sessionService.setCredentials({
      username: this.username,
      password: this.password,
    });

    const credentials = this.sessionService.getCredentials();

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization:
          'Basic ' + btoa(`${credentials?.username}:${credentials?.password}`),
      }),
      withCredentials: true,
    };

    const email = this.username;
    const url = `http://localhost:8080/hr/employees/get-profile/${email}`;

    this.http.get<Employee>(url, httpOptions).subscribe(
      (data) => {
        this.sessionService.setHr();
        this.sessionService.setEmployee(data);
        this.router.navigateByUrl('/requestList');
      },
      (error) => {
        console.error('Error fetching employee profile:', error);
      }
    );
  }
}
