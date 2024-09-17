import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HREmployee } from 'src/app/models/hremployee';
import { Status, VacationRequest } from 'src/app/models/vacacation-request';
import { Employee } from '../../models/employee';
import { SessionService } from 'src/app/session.service';
import { Message } from 'src/app/models/message';

@Component({
  selector: 'app-create-request',
  templateUrl: './create-request.component.html',
  styleUrls: ['./create-request.component.css'],
})
export class CreateRequestComponent {
  vacationRequestForm: FormGroup;
  vr: VacationRequest | undefined;
  messages: Message[] = [];

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private sessionService: SessionService
  ) {
    this.vacationRequestForm = this.fb.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      reason: ['', Validators.required],
    });
  }

  ngOnInit() {
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
      .get<Message[]>('http://localhost:8080/messages', httpOptions)
      .subscribe((data) => {
        this.messages = data.filter((message) => !message.dismissed);
      });
  }

  onSubmit() {
    if (this.vacationRequestForm.valid) {
      const vacationRequest: VacationRequest = {
        startDate: this.vacationRequestForm.value.startDate,
        endDate: this.vacationRequestForm.value.endDate,
        status: Status.PENDING,
        reason: this.vacationRequestForm.value.reason,
        employeeId: this.sessionService.getEmployee()!.id,
      };

      const credentials = this.sessionService.getCredentials();

      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          Authorization:
            'Basic ' +
            btoa(`${credentials?.username}:${credentials?.password}`),
        }),
        withCredentials: true,
      };

      this.http
        .post(
          'http://localhost:8080/vacation-requests/create',
          vacationRequest,
          httpOptions
        )
        .subscribe((data) => {
          console.log(data);
        });
    }
  }

  dismiss(id: string) {
    // const credentials = this.sessionService.getCredentials();
    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //     Authorization:
    //       'Basic ' + btoa(`${credentials?.username}:${credentials?.password}`),
    //   }),
    //   withCredentials: true,
    // };
    // this.http
    //   .put(`http://localhost:8080/messages/dismiss/${id}`, httpOptions)
    //   .subscribe((data) => {
    //     console.log(data);
    //   });
  }
}
