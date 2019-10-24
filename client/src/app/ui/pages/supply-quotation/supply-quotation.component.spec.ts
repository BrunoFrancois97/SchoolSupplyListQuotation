import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplyQuotationComponent } from './supply-quotation.component';

describe('SupplyQuotationComponent', () => {
  let component: SupplyQuotationComponent;
  let fixture: ComponentFixture<SupplyQuotationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupplyQuotationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplyQuotationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
