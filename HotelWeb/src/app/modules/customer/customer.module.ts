import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { CustomersComponent } from './customer.component';
import { CustomerRoutingModule } from './customer.routing.module';
import { RoomsComponent } from './components/rooms/rooms.component';
import { DemoNgZorroAntdModule } from '../../DemoNgZorroAntdModule';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    CustomersComponent,
    RoomsComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    CustomersComponent,
    CustomerRoutingModule,
    DemoNgZorroAntdModule
  ]
})
export class CustomersModule { }
