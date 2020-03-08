import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionNewletterformComponent } from './section-newletterform.component';

describe('SectionNewletterformComponent', () => {
  let component: SectionNewletterformComponent;
  let fixture: ComponentFixture<SectionNewletterformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SectionNewletterformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SectionNewletterformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
