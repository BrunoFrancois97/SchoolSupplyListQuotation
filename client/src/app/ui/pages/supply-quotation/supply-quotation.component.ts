import { Component, OnInit } from '@angular/core';
import { SchoolService } from '../../../service/school.service';
import { SupplyListQuotationService } from '../../../service/supply-list-quotation.service';
import { Item } from '../../../model/item';
import { SupplyListQuotationRepository } from '../../../repository/supply-list-quotation.repository';
import { School } from '../../../model/school';

@Component({
  selector: 'supply-quotation',
  templateUrl: './supply-quotation.component.html',
  styleUrls: ['./supply-quotation.component.scss']
})
export class SupplyQuotationComponent implements OnInit {

  public isBusy = false;
  public isQuotationMade: boolean;
  public grades;
  public selectedSchool;
  public selectedGrade;
  public totalPrice: number;
  public schools: Array<School>;

  constructor(
    private schoolService: SchoolService,
    private supplyListQuotationService: SupplyListQuotationService) {
  }

  ngOnInit() {
    this.schoolService.getSchools()
      .subscribe(
        foundSchools => {
          this.schools = foundSchools;
        }, error => {
          console.log(error);
        })
  }

  public get isSchoolSelected(): boolean {
    return this.selectedSchool;
  }

  public get isGradeSelected(): boolean {
    return this.selectedGrade;
  }

  public get areRequiredFieldsFilled(): boolean {
    return this.isSchoolSelected && this.isGradeSelected;
  }

  public items: Array<Item>;

  public gradesA = [
    { id: 1, name: "1" },
    { id: 2, name: "2" },
    { id: 3, name: "3" },
    { id: 4, name: "4" },
    { id: 5, name: "5" }
  ];

  public gradesB = [
    { id: 1, name: "10" },
    { id: 2, name: "20" },
    { id: 3, name: "30" },
    { id: 4, name: "40" },
    { id: 5, name: "50" }
  ];

  public onModelChanged() {
    if (this.selectedSchool.id == 1) {
      this.grades = this.gradesA;
    }
    else if (this.selectedSchool.id == 2) {
      this.grades = this.gradesB;
    }
    else {
      this.grades = null;
    }
  }

  public makeQuotation() {
    if (this.selectedGrade.id == 1) {
      this.items = [
        { quantity: 1, name: "Backpack", price: 150, extendedPrice: 150, },
      ];
    }
    else if (this.selectedGrade.id == 2) {
      this.items = [
        { quantity: 1, name: "Paste", price: 3, extendedPrice: 3, },
        { quantity: 1, name: "Scissors", price: 12, extendedPrice: 12, },
      ];
    }
    else {
      this.items = [
        { quantity: 5, name: "Pencil", price: 1, extendedPrice: 5, },
        { quantity: 5, name: "Pen", price: 2, extendedPrice: 10, },
        { quantity: 2, name: "Notebook", price: 3, extendedPrice: 6, },
        { quantity: 2, name: "Eraser", price: 4, extendedPrice: 8, },
        { quantity: 1, name: "Sharpner", price: 5, extendedPrice: 5, },
      ];
    }
    this.totalPrice = this.items.map(i => i.extendedPrice).reduce((accumulator, current) => accumulator + current);
    this.isQuotationMade = true;
  }

}
