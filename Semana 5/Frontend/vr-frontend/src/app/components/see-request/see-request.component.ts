import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Status, VacationRequest } from 'src/app/models/vacacation-request';
import { SessionService } from 'src/app/session.service';

@Component({
  selector: 'app-see-request',
  templateUrl: './see-request.component.html',
  styleUrls: ['./see-request.component.css'],
})
export class SeeRequestComponent {
  vacationRequests: VacationRequest[] = [];

  constructor(
    private http: HttpClient,
    private sessionService: SessionService
  ) {}

  ngOnInit(): void {
    this.getVacationRequests();
  }

  getVacationRequests(): void {
    const credentials = this.sessionService.getCredentials();

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization:
          'Basic ' + btoa(`${credentials?.username}:${credentials?.password}`),
      }),
      withCredentials: true,
    };

    this.http
      .get<VacationRequest[]>(
        'http://localhost:8080/vacation-requests',
        httpOptions
      )
      .subscribe((data) => {
        this.vacationRequests = data.filter(
          (request) => request.status == Status.PENDING
        );
      });
  }

  acceptRequest(id: number, reason: String): void {
    const credentials = this.sessionService.getCredentials();

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization:
          'Basic ' + btoa(`${credentials?.username}:${credentials?.password}`),
      }),
      withCredentials: true,
    };

    console.log('Accepted' + id);
    this.http
      .put(
        'http://localhost:8080/vacation-requests/accept/' + id,
        null,
        httpOptions
      )
      .subscribe((data) => {
        console.log(data);
      });

    // this.http
    //   .post('http://localhost:9000/publish', {
    //     message: `Your request with reason ${reason} was accepted`,
    //   })
    //   .subscribe((data) => {
    //     console.log(data);
    //   });
  }

  rejectRequest(id: number, reason: String): void {
    const credentials = this.sessionService.getCredentials();

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization:
          'Basic ' + btoa(`${credentials?.username}:${credentials?.password}`),
      }),
      withCredentials: true,
    };

    this.http
      .put(
        'http://localhost:8080/vacation-requests/decline/' + id,
        null,
        httpOptions
      )
      .subscribe((data) => {
        console.log(data);
      });

    // this.http
    //   .post('http://localhost:9000/publish', {
    //     message: `Your request with reason ${reason} was denied`,
    //   })
    // .subscribe((data) => {
    //     console.log(data);
    //   });
  }
}
