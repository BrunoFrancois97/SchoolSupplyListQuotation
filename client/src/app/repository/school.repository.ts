import { SchoolResources } from './resources/school.resources';
import { School } from './../model/school';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/map';
import { AbstractRepository } from './abstract.repository';

const URL = `${environment.apiUrl}`;

@Injectable()
export class SchoolRepository extends AbstractRepository {

    constructor(private httpClient: HttpClient) {
        super();
    }

    public getSchools(): Observable<School> {
        return this.httpClient.post(URL, '').map((data:SchoolResources) => this.fromDto(data));
    }

    private fromDto(dto: SchoolResources): School {
        return this.copy(dto, new School());
    }
}