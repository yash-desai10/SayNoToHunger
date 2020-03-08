import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionStepsComponent } from './section-steps.component';

describe('SectionStepsComponent', () => {
  let component: SectionStepsComponent;
  let fixture: ComponentFixture<SectionStepsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SectionStepsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SectionStepsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
