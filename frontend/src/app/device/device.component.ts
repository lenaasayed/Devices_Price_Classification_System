import { Component, OnInit } from '@angular/core';
import { Device } from './model/device';
import { PredictPrice } from './model/predictPrice';
import { DeviceService } from './service/device.service';

@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: [

  ]
})
export class DeviceComponent implements OnInit {

  deviceList = new Array<PredictPrice>();

  counts:Number[];
  constructor(private deviceService:DeviceService) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData(){
     this.counts = [1,2,3,4,5,6,7,8,9,10]
     this.counts.forEach(i => {
      this.deviceService.deviceTest(i)
      .subscribe(
        data=>{
          this.deviceList.push(data);
        },
        error=>{
          console.log(error)
        }
      )
      });
}
}
