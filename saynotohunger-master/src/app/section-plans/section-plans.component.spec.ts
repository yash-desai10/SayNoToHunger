import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionPlansComponent } from './section-plans.component';

describe('SectionPlansComponent', () => {
  let component: SectionPlansComponent;
  let fixture: ComponentFixture<SectionPlansComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SectionPlansComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SectionPlansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
