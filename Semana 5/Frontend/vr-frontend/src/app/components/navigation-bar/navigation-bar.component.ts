import { Component } from '@angular/core';
import { SessionService } from 'src/app/session.service';

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css'],
})
export class NavigationBarComponent {
  constructor(private sessionService: SessionService) {}

  getHR(): Boolean {
    return this.sessionService.getHr();
  }
}
