import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditJobdialogComponent } from './edit-jobdialog.component';

describe('EditJobdialogComponent', () => {
  let component: EditJobdialogComponent;
  let fixture: ComponentFixture<EditJobdialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditJobdialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditJobdialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
