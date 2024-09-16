import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Status, VacationRequest } from 'src/app/models/vacacation-request';

@Component({
  selector: 'app-mark-completed',
  templateUrl: './mark-completed.component.html',
  styleUrls: ['./mark-completed.component.css'],
})
export class MarkCompletedComponent {
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
          (data) =>
            data.status == Status.ACCEPTED || data.status == Status.DECLINED
        );
        console.log(this.vacationRequests); // Log data to the console
      });
  }

  markAsCompleted(): void {
    this.http
      .post('http://localhost:9192/jobs/completeRequest', null)
      .subscribe((data) => {
        console.log(data);
      });
  }
}
