import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/map';
import { AbstractRepository } from './abstract.repository';
import { SupplyList } from '../model/supplylist';
import { SupplyListResources } from './resources/supply-list.resources';

const URL = `${environment.apiUrl}`;

@Injectable()
export class SupplyListQuotationRepository extends AbstractRepository {

    constructor(private httpClient: HttpClient) {
        super();
    }

    public makeQuotation(): Observable<SupplyList> {
        return this.httpClient.post(URL, '').map((data:SupplyListResources) => this.fromDto(data));
    }

    private fromDto(dto: SupplyListResources): SupplyList {
        return this.copy(dto, new SupplyList());
    }
}