import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import fr from '@angular/common/locales/fr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { en_US, fr_FR, NZ_I18N } from 'ng-zorro-antd/i18n';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './auth/components/register/register.component';
import { DemoNgZorroAntdModule } from './DemoNgZorroAntdModule';
import { AppRoutingModule } from './app.routing.modules';
import { AuthModule } from './auth/auth.module';



registerLocaleData(en);


@NgModule({
    declarations: [
        AppComponent, RegisterComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule, 
        HttpClientModule,
        BrowserAnimationsModule,
        DemoNgZorroAntdModule,
        ReactiveFormsModule,
        AuthModule
    ],
    providers: [
        { provide: NZ_I18N, useValue: en_US}
    ],
    bootstrap: [AppComponent],
    schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }

