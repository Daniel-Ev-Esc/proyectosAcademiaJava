import { HREmployee } from './hremployee';
import { Employee } from './employee';

export interface VacationRequest {
  id: number;
  requester: Employee;
  startDate: string; // Use string for date to handle JSON parsing
  endDate: string; // Same as above
  status: Status;
  reason: string;
  hrEmployee?: HREmployee; // Optional field since it's nullable
}

export enum Status {
  PENDING = 'PENDING',
  DECLINED = 'DECLINED',
  ACCEPTED = 'ACCEPTED',
}
