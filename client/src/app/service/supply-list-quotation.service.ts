import { SupplyListQuotationRepository } from './../repository/supply-list-quotation.repository';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ChosenSchool } from '../model/chosen-school';
import { Quotation } from '../model/quotation';

@Injectable()
export class SupplyListQuotationService {

    constructor(private repository: SupplyListQuotationRepository) {
    }

    public makeQuotation(choosenSchool: ChosenSchool): Observable<Quotation> {
        return this.repository.makeQuotation(choosenSchool);
    }
}