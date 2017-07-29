package sample.controller;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import sample.model.AmbientDevice;
import sample.model.TempData;
import sample.model.WaterFlowData;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmbientControllerTest {
  @Test
  void initialize() {

  }

  @Test
  void handleWaterFlowClick() throws IOException {

    //Create test data objects
    WaterFlowData currentData = new WaterFlowData();
    AmbientDevice myDevice = new AmbientDevice();

    //Set the data from the website
    currentData.setData();
    //add tests for values


  }

  @Test
  void handleTemperatureClick() throws IOException  {
    //Create test data objects
    TempData currentData = new TempData();

    //Set the data from the website
    currentData.setData();
    //add tests for temperature
  }



}