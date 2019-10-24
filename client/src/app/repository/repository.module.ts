import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { SupplyListQuotationRepository } from './supply-list-quotation.repository';
import { ErrorInterceptorProvider } from './interceptor/error.interceptor';
import { SchoolRepository } from './school.repository';

@NgModule({
    imports: [HttpClientModule],
    providers: [
        SupplyListQuotationRepository,
        SchoolRepository,
        ErrorInterceptorProvider,
    ]
})

export class RepositoryModule {
}
