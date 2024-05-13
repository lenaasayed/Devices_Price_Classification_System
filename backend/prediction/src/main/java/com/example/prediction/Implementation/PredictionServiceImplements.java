package com.example.prediction.Implementation;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.prediction.Exception.ResourceNotFoundException;
import com.example.prediction.Model.Device;
import com.example.prediction.Model.Prediction;
import com.example.prediction.Repository.PredictionRepository;
import com.example.prediction.service.PredictionService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

@Service
@Transactional
public class PredictionServiceImplements implements PredictionService{

@Autowired
private PredictionRepository predictionRepository; 
private static String POST_URL_ML = "http://192.168.99.100:9700/prediction";

// get all devices
@Override
public List<Prediction> getAllDevices(){
    return this.predictionRepository.findAll();   
}

// create device
@Override
public Prediction createDevice(Prediction prediction){
    return predictionRepository.save(prediction);
};

// get device using id
@Override
public Prediction getDeviceById(Integer count){
    Optional <Prediction> predictionDb = this.predictionRepository.findByCount(count);
    if (predictionDb.isPresent()) {
        return predictionDb.get();
    } else {
        throw new ResourceNotFoundException("Record not found with id : " + count);
    }
}

// Predict device using id
@Override
public String getResultById(Integer count) throws IOException, JSONException{
    Optional <Prediction> user = this.predictionRepository.findByCount(count);
    if (user.isPresent()) {
        return postUser(user);
    } else {
        throw new ResourceNotFoundException("Record not found with id : " + count);
    }
    
};

// Predict device using object
@Override
public String getResultByObj(Prediction user) throws IOException, JSONException{
    try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
        String POST_URL = POST_URL_ML;
        HttpPost httpPost = new HttpPost(POST_URL);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        System.out.println("-******==============================***********************************-");
        System.out.println(user);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("n_cores", user.getN_cores());
        jsonObject.put("touch_screen", user.getTouch_screen());
        jsonObject.put("four_g", user.getFour_g());
        jsonObject.put("blue", user.getBlue());
        jsonObject.put("three_g", user.getThree_g());
        jsonObject.put("ram", user.getRam());
        jsonObject.put("battery_power",user.getBattery_power());
        jsonObject.put("px_width",user.getPx_width());

        String json = jsonObject.toString();

        System.out.println("-*****************************************-");
        System.out.println(json);

        StringEntity stringEntity = new StringEntity(json);
        httpPost.setEntity(stringEntity);

        System.out.println("Executing request " + httpPost.getRequestLine());

        // Create a custom response handler
        ResponseHandler < String > responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
        String responseBody = httpclient.execute(httpPost, responseHandler);
        System.out.println("----------------------------------------");
        System.out.println(responseBody);

        return responseBody;
    }

};

// Test 10 devices of the Test Dataset
@Override
public List<String> getResultForTestDevice(Integer[] count) throws IOException, JSONException {
    List<String> price = new ArrayList<String>();
    for (Integer integer : count) {
        Optional <Prediction> user = this.predictionRepository.findByCount(integer);
        if (user.isPresent()) {
            System.out.println("-------------------getResultForTestDevice---------------------");
            price.add(postUser(user).toString());
             System.out.println(price);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + count);
        }
    }
    return price;
};

// Test 10 devices of the Test Dataset
@Override
public Device getObj(Integer count) throws IOException, JSONException {
    Device device;
        Optional <Prediction> user = this.predictionRepository.findByCount(count);
        if (user.isPresent()) {
            System.out.println("-------------------Devices---------------------");
             device = new Device( 
                user.get().getCount(),user.get().getN_cores(),user.get().getTouch_screen(),user.get().getFour_g(),
                user.get().getBlue(),user.get().getThree_g(),user.get().getBattery_power(),
                user.get().getRam(),user.get().getPx_width(),postUser(user).toString());
            System.out.println(device);
            // devices.add(device);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + count);
        }
    // }
    return device;
};


// Test 10 devices of the Test Dataset
@Override
public List<Device> getResultForObjDevices(String count) throws IOException, JSONException {
    List<Device> devices = new ArrayList<Device>();
    // for (Integer integer : count) {
        Optional <Prediction> user = this.predictionRepository.findByCount(Integer.parseInt(count));
          
        if (user.isPresent()) {
            System.out.println("-------------------Devices---------------------");
            Device device = new Device( 
                user.get().getCount(),user.get().getN_cores(),user.get().getTouch_screen(),user.get().getFour_g(),
                user.get().getBlue(),user.get().getThree_g(),user.get().getBattery_power(),
                user.get().getRam(),user.get().getPx_width(),postUser(user).toString());
            System.out.println(device);
            devices.add(device);


        } else {
            throw new ResourceNotFoundException("Record not found with id : " + count);
        }
    // }
    return devices;
};

public static String postUser(Optional<Prediction> user) throws IOException, JSONException {

    try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
        String POST_URL = POST_URL_ML;
        HttpPost httpPost = new HttpPost(POST_URL);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        System.out.println("-******==============================***********************************-");
        System.out.println(user);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("n_cores", user.get().getN_cores());
        jsonObject.put("touch_screen", user.get().getTouch_screen());
        jsonObject.put("four_g", user.get().getFour_g());
        jsonObject.put("blue", user.get().getBlue());
        jsonObject.put("three_g", user.get().getThree_g());
        jsonObject.put("ram", user.get().getRam());
        jsonObject.put("battery_power",user.get().getBattery_power());
        jsonObject.put("px_width",user.get().getPx_width());

        String json = jsonObject.toString();

        System.out.println("-*****************************************-");
        System.out.println(json);

        StringEntity stringEntity = new StringEntity(json);
        httpPost.setEntity(stringEntity);

        System.out.println("Executing request " + httpPost.getRequestLine());

        // Create a custom response handler
        ResponseHandler < String > responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
        String responseBody = httpclient.execute(httpPost, responseHandler);
        System.out.println("----------------------------------------");
        System.out.println(responseBody);

        return responseBody;
    }
}




}
