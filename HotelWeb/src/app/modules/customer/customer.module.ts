import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DemoNgZorroAntdModule } from '../../DemoNgZorroAntdModule';
import { CustomersComponent } from './customer.component';
import { CustomerRoutingModule } from './customer.routing.module';
import { RoomsComponent } from './components/rooms/rooms.component';



@NgModule({
  declarations: [
    CustomersComponent,
    RoomsComponent
  ],
  imports: [
    CommonModule,
    DemoNgZorroAntdModule,
    CustomersComponent,
    CustomerRoutingModule,
  ]
})
export class CustomersModule { }
