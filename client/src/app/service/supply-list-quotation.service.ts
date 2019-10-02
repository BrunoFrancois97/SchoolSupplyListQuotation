import { SupplyListQuotationRepository } from './../repository/supply-list-quotation.repository';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { SupplyList } from '../model/supplylist';

@Injectable()
export class SupplyListQuotationService {

    constructor(private repository: SupplyListQuotationRepository) {
    }

    public makeQuotation(): Observable<SupplyList> {
        return this.repository.makeQuotation();
    }
}