import { Injectable } from '@angular/core';
import { Employee } from './models/employee';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  private employee: Employee | null = null;
  private hr: Boolean = false;

  constructor() {}

  setEmployee(employee: Employee) {
    this.employee = employee;
  }

  getEmployee(): Employee | null {
    return this.employee;
  }

  setHr() {
    this.hr = true;
  }

  getHr(): Boolean {
    return this.hr;
  }
  clearEmployee() {
    this.employee = null;
  }
}
