import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewResumeDialogComponent } from './view-resume-dialog.component';

describe('ViewResumeDialogComponent', () => {
  let component: ViewResumeDialogComponent;
  let fixture: ComponentFixture<ViewResumeDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewResumeDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewResumeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
