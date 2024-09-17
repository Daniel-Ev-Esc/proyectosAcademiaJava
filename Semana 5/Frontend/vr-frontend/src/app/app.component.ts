import { Component } from '@angular/core';
import { SessionService } from './session.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  constructor(private sessionService: SessionService) {}
  title = 'vr-frontend';

  getCredentials() {
    return this.sessionService.getCredentials();
  }
}
