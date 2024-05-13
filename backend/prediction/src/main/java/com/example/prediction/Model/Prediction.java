package com.example.prediction.Model;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
// create a "PredictDB" database
@Document(collection="PredictDB")
//  to represent the data model
public class Prediction {

    private Integer  count;
    private Integer n_cores;
    private Integer touch_screen;
    private Integer four_g;
    private Integer blue;
    private Integer three_g;

    private Integer battery_power;
    private Integer ram;
    private Integer px_width;

    public Prediction(){}
    public Prediction( 
      Integer  count,Integer n_cores,Integer touch_screen,Integer four_g,
    Integer blue,Integer three_g,Integer battery_power,Integer ram,Integer px_width
    ){
        super();
        this.count = count;
        this.n_cores = n_cores;
        this.touch_screen = touch_screen;
        this.four_g = four_g;
        this.blue = blue;
        this.three_g = three_g;
        this.battery_power = battery_power;
        this.ram = ram;
        this.px_width = px_width;
    }

    public Integer  getCount() {
        return count;
    }
    
      public Integer getN_cores() {
        return n_cores;
      }
    
      public Integer getTouch_screen() {
        return touch_screen;
      }
    
      public Integer getFour_g() {
        return four_g;
      }
    
      public Integer getBlue() {
        return blue;
      }
    
      public Integer getThree_g() {
        return three_g;
      }
    
      public Integer getBattery_power() {
        return battery_power;
      }
    
      public Integer getRam() {
        return ram;
      }
    
      public Integer getPx_width() {
        return px_width;
      }
    
     // Setter Methods 
     public void setCount(Integer  count){
        this.count = count;
    }
    
      public void setN_cores( Integer n_cores ) {
        this.n_cores = n_cores;
      }
    
      public void setTouch_screen( Integer touch_screen ) {
        this.touch_screen = touch_screen;
      }
    
      public void setFour_g( Integer four_g ) {
        this.four_g = four_g;
      }
    
      public void setBlue( Integer blue ) {
        this.blue = blue;
      }
    
      public void setThree_g( Integer three_g ) {
        this.three_g = three_g;
      }
    
      public void setBattery_power( Integer battery_power ) {
        this.battery_power = battery_power;
      }
    
      public void setRam( Integer ram ) {
        this.ram = ram;
      }
    
      public void setPx_width( Integer px_width ) {
        this.px_width = px_width;
      }
}
