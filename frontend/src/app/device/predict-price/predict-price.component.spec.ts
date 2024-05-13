import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PredictPriceComponent } from './predict-price.component';

describe('PredictPriceComponent', () => {
  let component: PredictPriceComponent;
  let fixture: ComponentFixture<PredictPriceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PredictPriceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PredictPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
