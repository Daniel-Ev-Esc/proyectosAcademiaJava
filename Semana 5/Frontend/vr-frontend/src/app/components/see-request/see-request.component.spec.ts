import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeRequestComponent } from './see-request.component';

describe('SeeRequestComponent', () => {
  let component: SeeRequestComponent;
  let fixture: ComponentFixture<SeeRequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SeeRequestComponent]
    });
    fixture = TestBed.createComponent(SeeRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
