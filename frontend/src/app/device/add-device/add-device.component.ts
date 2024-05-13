import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators,FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { PredictPrice } from '../model/predictPrice';
import { DeviceService } from '../service/device.service';

@Component({
  selector: 'app-add-device',
  templateUrl: './add-device.component.html',
  styleUrls: [

  ]
})
export class AddDeviceComponent implements OnInit {
  predictionprice :String;
  submitted = false;
  emailError=false;
  emailErrorMsg="Invalid email . Try again or contact us ."
  predictPrice = new PredictPrice();
  deviceForm: FormGroup;
  ty = "hj"
  constructor(private deviceService:DeviceService) { }

  ngOnInit(): void {
    this.buildFormControl();
  }
  FunctionPrint(): String{
    const pr = this.predictPrice.price;
    return pr;
  }
  handleSubmit() {
    this.buildDevice();
     this.deviceService.addPredict(this.predictPrice)
        .subscribe(
          data=>{
            // this.predictPrice=data[0];
            this.predictionprice=data;
            console.log("***********************data********************************")
            console.log(data)

            // this.ty= this.predictPrice.price.toString()
            console.log("*********************** this.predictPrice********************************")
            console.log(this.predictPrice)

            console.log("***********************this.ty********************************")
            console.log(this.ty)
            this.submitted=true;

          },
          error=>{
            console.log(error)
          }
          )
  }

  // handleSubmit() {
  //   this.buildDevice();
  //    this.deviceService.addPredict(this.predictPrice)
  //       .subscribe(
  //         data=>{
  //           this.predictPrice.price=data;
  //           this.predictionprice=data;
  //           this.ty= JSON.stringify(this.predictionprice)

  //           this.submitted=true;

  //         },
  //         error=>{
  //           console.log(error)
  //         }
  //         )
  // }

    //Build new provider object
    buildDevice(){
      let d = this.deviceForm.value;

      // if(d.touch_screen=='False')
      this.predictPrice.n_cores = Number(d.n_cores);
      this.predictPrice.touch_screen = Number(Boolean(JSON.parse(d.touch_screen)) );
      this.predictPrice.four_g = Number(Boolean(JSON.parse(d.four_g)));
      this.predictPrice.blue = Number(Boolean(JSON.parse(d.blue)));
      this.predictPrice.three_g = Number(Boolean(JSON.parse(d.three_g)));
      this.predictPrice.battery_power = d.battery_power;
      this.predictPrice.ram = d.ram;
      this.predictPrice.px_width = d.px_width;

      console.log("***********************form data d********************************")
      console.log(d)

      console.log("***********************form predictPrice d********************************")
      console.log(this.predictPrice)

    }
    //Build Form Control
    buildFormControl(){
      this.deviceForm = new FormGroup({

        n_cores: new FormControl('',[Validators.required]),
        touch_screen: new FormControl('',[Validators.required]),
        four_g: new FormControl('',[Validators.required]),
        blue: new FormControl('',[Validators.required]),
        three_g: new FormControl('',[Validators.required]),
        battery_power: new FormControl('',[Validators.required]),
        ram: new FormControl('',[Validators.required]),
        px_width: new FormControl('',[Validators.required]),
        // price: new FormControl('',[Validators.required]),
      });


      console.log("*******************deviceForm******************************")
      console.log(this.deviceForm)
    }

}
