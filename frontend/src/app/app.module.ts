import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CustomerComponent } from './customer/customer.component';
import { ItemComponent } from './item/item.component';
import { OrderComponent } from './order/order.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
// import { ServiceComponent } from './service/service.component';
// import { Service1Component } from './service/service1.component';

const routes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'customer',
    component: CustomerComponent
  },
  // {
  //   path: '',
  //   component: DashboardComponent
  // },
  {
    path: 'item',
    component: ItemComponent
  },
  {
    path: 'order',
    component: OrderComponent
  },
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'dashboard'
  }
];
@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    CustomerComponent,
    ItemComponent,
    OrderComponent,
    // ServiceComponent,
    // Service1Component
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
