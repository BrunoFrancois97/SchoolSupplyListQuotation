import { PagesModule } from './ui/pages/pages.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { SupplyQuotationComponent } from './ui/pages/supply-quotation/supply-quotation.component';

const appRoutes: Routes = [
  {
    path: '',
    component: SupplyQuotationComponent,
  },
];

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    RouterModule.forRoot(
        appRoutes,
    ),
    BrowserModule,
    FormsModule,
    HttpClientModule,
    PagesModule
],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
