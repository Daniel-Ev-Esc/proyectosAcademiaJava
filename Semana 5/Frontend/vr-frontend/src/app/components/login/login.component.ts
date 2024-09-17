import { HttpClient, HttpHeaders } from '@angular/common/http';
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
    const url = `http://localhost:8080/employees/get-profile/${email}`;

    this.http.get<Employee>(url, httpOptions).subscribe(
      (data) => {
        this.sessionService.setEmployee(data);
        this.router.navigateByUrl('/createRequest');
      },
      (error) => {
        console.error('Error fetching employee profile:', error);
      }
    );
  }

  ngOnInit() {
    this.sessionService.setCredentials(null);
  }

  gotoHR() {
    this.router.navigateByUrl('/hr');
  }
}
