import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployerJobapplicantsComponent } from './employer-jobapplicants.component';

describe('EmployerJobapplicantsComponent', () => {
  let component: EmployerJobapplicantsComponent;
  let fixture: ComponentFixture<EmployerJobapplicantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployerJobapplicantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployerJobapplicantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
