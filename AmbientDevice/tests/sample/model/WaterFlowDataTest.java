package sample.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

//Class to test for critical methods in WaterFlowData class
class WaterFlowDataTest {

  @Test
  void calculateOverflow() throws IOException {
    //Create test data objects
    WaterFlowData currentData = new WaterFlowData();

    //Test for a normal situation where the outflow is greater than inflow
    currentData.setInflow(7000);
    currentData.setOutflow(8000);
    assertEquals(10, currentData.calculateOverflow());

    //Set inflow and outflow to multiple value to test for correct overage value
    currentData.setInflow(10000);
    currentData.setOutflow(9000);
    assertEquals(20, currentData.calculateOverflow());

    //Test for extreme values
    currentData.setInflow(20000);
    currentData.setOutflow(0);
    assertEquals(400, currentData.calculateOverflow());

  }

}