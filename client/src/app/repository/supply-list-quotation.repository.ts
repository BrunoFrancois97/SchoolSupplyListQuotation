import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/map';
import { AbstractRepository } from './abstract.repository';
import { QuotationResource } from './resources/quotation.resource';
import { Quotation } from '../model/quotation';
import { ChosenSchool } from '../model/chosen-school';

const URL = `${environment.apiUrl}/quotation`;

@Injectable()
export class SupplyListQuotationRepository extends AbstractRepository {

    constructor(private httpClient: HttpClient) {
        super();
    }

    public makeQuotation(choosenSchool: ChosenSchool): Observable<Quotation> {
        return this.httpClient.post(URL, choosenSchool).map((data:QuotationResource) => this.fromDto(data));
    }

    private fromDto(dto: QuotationResource): Quotation {
        return this.copy(dto, new Quotation());
    }
}