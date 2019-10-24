import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { SchoolRepository } from '../repository/school.repository';
import { School } from '../model/school';

@Injectable()
export class SchoolService {

    constructor(private repository: SchoolRepository) {
    }

    public getSchools(): Observable<Array<School>> {
        return this.repository.getSchools();
    }
}
