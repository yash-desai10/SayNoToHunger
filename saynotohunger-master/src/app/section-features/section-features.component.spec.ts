import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionFeaturesComponent } from './section-features.component';

describe('SectionFeaturesComponent', () => {
  let component: SectionFeaturesComponent;
  let fixture: ComponentFixture<SectionFeaturesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SectionFeaturesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SectionFeaturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
