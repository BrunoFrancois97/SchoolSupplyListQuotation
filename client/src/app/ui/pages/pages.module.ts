import { ServiceModule } from './../../service/service.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComponentsModule } from '../components/components.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { SupplyQuotationComponent } from './supply-quotation/supply-quotation.component';
import { SharedModule } from '../../shared.module';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        SharedModule,
        ComponentsModule,
        FormsModule,
        ServiceModule
    ],
    declarations: [
        SupplyQuotationComponent
    ]
})
export class PagesModule {
}
