import { SchoolService } from './school.service';
import { NgModule } from '@angular/core';
import { SupplyListQuotationService } from './supply-list-quotation.service';

@NgModule({
    providers: [
        SupplyListQuotationService,
        SchoolService
    ]
})
export class ServiceModule {
}
