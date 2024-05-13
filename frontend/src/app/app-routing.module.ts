import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
// import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
// import { LoginComponent } from './login/login.component';
// import { NotfoundComponent } from './notfound/notfound.component';
// import { PortfolioComponent } from './portfolio/portfolio.component';
// import { AddProviderComponent } from './provider/add-provider/add-provider.component';
// import { EditProviderComponent } from './provider/edit-provider/edit-provider.component';
// import { DeleteProviderComponent } from './provider/delete-provider/delete-provider.component';
// import { DetailsProviderComponent } from './provider/details-provider/details-provider.component';
// import { ProviderComponent } from './provider/provider.component';
// import { RegisterComponent } from './register/register.component';
import { DeviceComponent } from './device/device.component';
import { AddDeviceComponent } from './device/add-device/add-device.component';
import { PredictPriceComponent } from './device/predict-price/predict-price.component';

let n:number=1;
const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"about",component:AboutComponent},
  {path:"device",component:DeviceComponent},
  {path:"device/add-device",component:AddDeviceComponent},
  {path:"device/predict-price",component:PredictPriceComponent},

];
// this.routes.navigate(
//   ['/componentb'],
//   { queryParams: { ids:  ids} }
// );

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
