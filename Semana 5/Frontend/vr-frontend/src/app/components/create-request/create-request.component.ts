import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HREmployee } from 'src/app/models/hremployee';
import { Status, VacationRequest } from 'src/app/models/vacacation-request';
import { Employee } from '../../models/employee';
import { SessionService } from 'src/app/session.service';

@Component({
  selector: 'app-create-request',
  templateUrl: './create-request.component.html',
  styleUrls: ['./create-request.component.css'],
})
export class CreateRequestComponent {
  vacationRequestForm: FormGroup;
  vr: VacationRequest | undefined;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private employeeService: SessionService
  ) {
    this.vacationRequestForm = this.fb.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      reason: ['', Validators.required],
    });

    // console.log(employeeService.getEmployee());
  }

  onSubmit() {
    if (this.vacationRequestForm.valid) {
      const vacationRequest: VacationRequest = {
        startDate: this.vacationRequestForm.value.startDate,
        endDate: this.vacationRequestForm.value.endDate,
        status: Status.PENDING,
        reason: this.vacationRequestForm.value.reason,
        employeeId: this.employeeService.getEmployee()!.id,
      };

      // console.log(vacationRequest);

      this.http
        .post('http://localhost:8080/vacation-requests/create', vacationRequest)
        .subscribe((data) => {
          console.log(data);
        });
    }
  }
}
