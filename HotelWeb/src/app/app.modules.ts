import { registerLocaleData } from "@angular/common";
import en from "@angular/common/locales/en";
import fr from "@angular/common/locales/fr";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { en_US, fr_FR, NZ_I18N } from "ng-zorro-antd/i18n";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { DemoNgZorroAntdModule } from "./DemoNgZorroAntdModule";
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';



registerLocaleData(fr);


@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        BrowserAnimationsModule,
        DemoNgZorroAntdModule,
        NzLayoutModule,   
        NzMenuModule,  
        ReactiveFormsModule
    ],
    providers: [
        { provide: NZ_I18N, useValue: fr_FR}
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }

