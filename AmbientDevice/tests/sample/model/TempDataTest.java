package sample.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by chasepugh on 7/28/17.
 */
class TempDataTest {

  @Test
  void calculateTempBrightnessValue() throws IOException {

    //Create test data objects
    TempData currentData = new TempData();
    AmbientDevice myDevice = new AmbientDevice();

    //first check that default max, min and scale are correct
    assertEquals((Integer) 50, currentData.getMin());
    assertEquals((Integer) 100, currentData.getMax());

    //check multiple temperatures are returning the expected values
    currentData.setActualTemperature(0);
    assertEquals(0, currentData.calculateTempBrightnessValue());

    currentData.setActualTemperature(200);
    assertEquals(99, currentData.calculateTempBrightnessValue());

    currentData.setActualTemperature(75);
    assertEquals(50, currentData.calculateTempBrightnessValue());

  }
}