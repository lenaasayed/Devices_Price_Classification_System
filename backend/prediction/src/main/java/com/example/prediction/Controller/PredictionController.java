package com.example.prediction.Controller;
import com.example.prediction.Model.Device;
import com.example.prediction.Model.Prediction;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.prediction.service.PredictionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PredictionController {
    
    @GetMapping("/")
    public String getDevice(){
        return "Print Device ";
    }

    @Autowired
    private PredictionService predictionService;

    // get all devices
    @GetMapping("/api/devices")
    public ResponseEntity < List < Prediction >> getAllDevices() {
        return ResponseEntity.ok().body(predictionService.getAllDevices());
    }

    // get one device
    @GetMapping("/api/devices/{count}")
    public ResponseEntity < Prediction > getDeviceById(@PathVariable Integer  count) {
        return ResponseEntity.ok().body(predictionService.getDeviceById(count));
    }

    // add new device
    @PostMapping("/api/devices")
    public ResponseEntity < Prediction > createDevice(@RequestBody Prediction prediction) {
        return ResponseEntity.ok().body(this.predictionService.createDevice(prediction));
    }

    // predict price of id device
    @GetMapping("/api/predict/{count}")
    public ResponseEntity<String> getResultById(@PathVariable Integer count) throws IOException, JSONException {
        return ResponseEntity.ok().body(this.predictionService.getResultById(count));
    }

    // predict price of object device
    @PostMapping("/api/predict")
    public ResponseEntity < String > getResultByObj(@RequestBody Prediction user) throws IOException, JSONException {
        return ResponseEntity.ok().body(this.predictionService.getResultByObj(user));
    }

    // predict price of id device
    @GetMapping("/api/predictObj/{count}")
    public ResponseEntity<Device> getObj(@PathVariable Integer count) throws IOException, JSONException {
        return ResponseEntity.ok().body(this.predictionService.getObj(count));
    }
    
    // Test 10 devices of the Test Dataset
    @PostMapping("/api/predicttestdata")
    public ResponseEntity <  List<String> > getResultForTestDevice(@RequestParam  Integer[] count) throws IOException, JSONException {
        return ResponseEntity.ok().body(this.predictionService.getResultForTestDevice(count));
    }

    // Test 10 devices of the Test Dataset
    @PostMapping("/api/predictobjdevice")
    public ResponseEntity <List<Device> > getResultForObjDevices(@RequestParam String count) throws IOException, JSONException {
        return ResponseEntity.ok().body(this.predictionService.getResultForObjDevices(count));
    }

}
// mvn install -DskipTests
// .\mvnw spring-boot:run