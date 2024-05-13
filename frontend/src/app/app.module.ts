import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { AboutComponent } from './about/about.component';
import { AboutModule } from './about/about.module';
import { ReactiveFormsModule } from '@angular/forms';

// import { UserModule } from './user/user.module';
import { HomeComponent } from './home/home.component';
// import { NotfoundComponent } from './notfound/notfound.component';
// import { ContactComponent } from './contact/contact.component';
// import { PortfolioComponent } from './portfolio/portfolio.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
// import { ProviderModule } from './provider/provider.module';
import { DeviceComponent } from './device/device.component';
import { AddDeviceComponent } from './device/add-device/add-device.component';
import { PredictPriceComponent } from './device/predict-price/predict-price.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    FooterComponent,
    DeviceComponent,
    AddDeviceComponent,
    PredictPriceComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AboutModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
