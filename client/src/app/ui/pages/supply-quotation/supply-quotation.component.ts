import { Component, OnInit } from '@angular/core';
import { SchoolService } from '../../../service/school.service';
import { SupplyListQuotationService } from '../../../service/supply-list-quotation.service';

@Component({
  selector: 'app-supply-quotation',
  templateUrl: './supply-quotation.component.html',
  styleUrls: ['./supply-quotation.component.scss']
})
export class SupplyQuotationComponent implements OnInit {

  public isBusy = false;

  constructor(
    private schoolService: SchoolService,
    private supplyListQuotationService: SupplyListQuotationService) {
  }

  ngOnInit() {
  }

  public grades;

  schools = [
    { id: 1, name: "A" },
    { id: 2, name: "B" },
    { id: 3, name: "C" },
    { id: 4, name: "D" },
    { id: 5, name: "E" }
  ];

  gradesA = [
    { id: 1, name: "1" },
    { id: 2, name: "2" },
    { id: 3, name: "3" },
    { id: 4, name: "4" },
    { id: 5, name: "5" }
  ];

  gradesB = [
    { id: 1, name: "10" },
    { id: 2, name: "20" },
    { id: 3, name: "30" },
    { id: 4, name: "40" },
    { id: 5, name: "50" }
  ];

  public selectedSchool = null;
  public selectedGrade = null;

  public foo(){
    if(this.selectedSchool.id == 1) {
      this.grades = this.gradesA;
    }
    else if(this.selectedSchool.id == 2) {
      this.grades = this.gradesB;
    }
    else{
      this.grades = null;
    }
  }

}
