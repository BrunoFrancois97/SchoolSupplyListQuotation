import { Component, OnInit } from '@angular/core';
import { SchoolService } from '../../../service/school.service';
import { SupplyListQuotationService } from '../../../service/supply-list-quotation.service';
import { School } from '../../../model/school';
import { ChosenSchool } from '../../../model/chosen-school';
import { Level } from '../../../model/level';
import { Quotation } from '../../../model/quotation';
import { Product } from '../../../model/product';

@Component({
  selector: 'supply-quotation',
  templateUrl: './supply-quotation.component.html',
  styleUrls: ['./supply-quotation.component.scss']
})
export class SupplyQuotationComponent implements OnInit {

  public isBusy = false;
  public isQuotationMade: boolean;
  public grades: Array<Level>;
  public selectedSchool: School;
  public selectedLevel: Level;
  public totalPrice: number;
  public schools: Array<School>;
  public quotation: Quotation;
  public items: Array<Product>;
  public shopName: string;

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
    return this.selectedSchool != null;
  }

  public get isGradeSelected(): boolean {
    return this.selectedLevel != null;
  }

  public get areRequiredFieldsFilled(): boolean {
    return this.isSchoolSelected && this.isGradeSelected;
  }

  public onModelChanged() {
    let schoolsCopy = Object.assign(this.schools, new Array<School>());
    this.grades = schoolsCopy.filter(c => c.schoolName == this.selectedSchool.schoolName).flatMap(c => c.levels);
  }

  public makeQuotation() {

    let choosenSchool = new ChosenSchool();
    choosenSchool.schoolName = this.selectedSchool.schoolName;
    choosenSchool.levelId = this.selectedLevel.id;

    this.supplyListQuotationService.makeQuotation(choosenSchool)
      .subscribe(
        (quotation: Quotation) => {
          this.quotation = quotation;
          this.items = quotation.products;
          this.totalPrice = quotation.totalPrice;
          this.isQuotationMade = true;
          this.shopName = quotation.shop;
        }, error => {
          console.log(error);
        }
      )
  }

}
