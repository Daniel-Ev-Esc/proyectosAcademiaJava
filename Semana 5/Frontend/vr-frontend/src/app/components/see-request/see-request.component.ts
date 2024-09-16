import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Status, VacationRequest } from 'src/app/models/vacacation-request';

@Component({
  selector: 'app-see-request',
  templateUrl: './see-request.component.html',
  styleUrls: ['./see-request.component.css'],
})
export class SeeRequestComponent {
  vacationRequests: VacationRequest[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.getVacationRequests();
  }

  getVacationRequests(): void {
    this.http
      .get<VacationRequest[]>('http://localhost:8080/vacation-requests')
      .subscribe((data) => {
        this.vacationRequests = data.filter(
          (item) => item.status == Status.PENDING
        );
        console.log(this.vacationRequests); // Log data to the console
      });
  }

  acceptRequest(id: number): void {
    console.log('Accepted' + id);
    this.http
      .put('http://localhost:8080/vacation-requests/accept/' + id, null)
      .subscribe((data) => {
        console.log(data);
      });
  }

  rejectRequest(id: number): void {
    console.log('Rejected' + id);
    this.http
      .put('http://localhost:8080/vacation-requests/decline/' + id, null)
      .subscribe((data) => {
        console.log(data);
      });
  }
}
