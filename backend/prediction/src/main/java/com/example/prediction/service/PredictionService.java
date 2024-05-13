package com.example.prediction.service;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

import com.example.prediction.Model.Device;
import com.example.prediction.Model.Prediction;

//repository interface to handle mongo database operations
public interface PredictionService  {
    
    List<Prediction> getAllDevices();

    Prediction createDevice(Prediction prediction);

    Prediction getDeviceById(Integer  count);

    String getResultById(Integer count) throws IOException, JSONException;

    Device getObj(Integer count) throws IOException, JSONException;

    String getResultByObj(Prediction user) throws IOException, JSONException;

    List<String> getResultForTestDevice(Integer[] count) throws IOException, JSONException ;
 
    List<Device>  getResultForObjDevices(String count) throws IOException, JSONException ;

}
