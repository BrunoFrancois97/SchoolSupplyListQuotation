import { LevelResource } from './resources/level.resource';
import { Level } from './../model/level';
import { SchoolResources } from './resources/school.resources';
import { School } from './../model/school';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/map';

const URL = `${environment.apiUrl}/schools`;

@Injectable()
export class SchoolRepository {

    constructor(private httpClient: HttpClient) {

    }

    public getSchools(): Observable<Array<School>> {
        return this.httpClient.get(URL).map((data:Array<SchoolResources>) => data.map(s => this.transform(s)));
    }

    private transform(schoolResources: SchoolResources): School {
       let school = new School();

       school.school = schoolResources.school;
       school.levels = schoolResources.levels.map(level => this.transformLevels(level));
       
       return school;
    }

    private transformLevels(levelResource: LevelResource): Level {
        let level = new Level();

        level.id = levelResource.id;
        level.name = levelResource.name;

        return level;
    } 

}