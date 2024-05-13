import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PredictPrice } from '../model/predictPrice';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  //URL Endpoint to our Express app
  apiUrl="http://localhost:7000/api/"

  apiGetAllDevice=this.apiUrl+"devices";

  apiGetResultByObj=this.apiUrl+"predict";

  apiDevice=this.apiUrl+"predictObj/";

  constructor(private http:HttpClient) { }

  //Get all records
  getDevices():Observable<any>{
    return this.http.get(this.apiGetAllDevice)
  }
  
  //Get result of device
  addPredict(newPredict:PredictPrice):Observable<String>{
    return this.http.post<String>(this.apiGetResultByObj,newPredict)
  }

  //Get result of device
  deviceTest(count:Number):Observable<PredictPrice>{
    return this.http.get<PredictPrice>(this.apiDevice+count)
  }

  //Get result of device
  // predictDevices(count:String):Observable<PredictPrice[]>{
  //   let params = new HttpParams();
  //   params = params.set('count', count);
  //   // count = count.trim();
  //   const options = count ?
  //   { params: new HttpParams().set(count, count) } : {};
  //   return this.http.post<PredictPrice[]>(this.apiGetResultObjDevice,options)
  // }



  // getString(stringParam: string): Observable<boolean> {
  //   console.log('api param', stringParam);
  //   let params = new HttpParams();
  //   params = params.set('stringParam', stringParam);
  //   return this.http.get<boolean>(`${URL}/param`, { params });
  // }

//   //Get result of test data
//   getResultOfTestData(newPredict:PredictPrice):Observable<String>{
//     return this.http.post<String>(this.apiGetResultByObj,newPredict)
//   }


// }
// function params<T>(apiGetResultObjDevice: string, params: any, arg2: {}): Observable<PredictPrice[]> {
//   throw new Error('Function not implemented.');
// }

}
