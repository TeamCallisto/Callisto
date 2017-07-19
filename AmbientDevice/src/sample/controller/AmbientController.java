package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import sample.model.AmbientDevice;
import sample.model.TemperatureData;
import sample.model.WaterFlowData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AmbientController implements Initializable {
  @FXML
  private Sphere ambientSphere;
  @FXML
  private Label waterFlowDate, waterFlowTitle, waterFlowTime, waterFlowOutflow, waterFlowInflow, waterFlowStatus;
  private AmbientDevice myDevice;

  /**
   * This code initializes the AmbientDevice display to the default values
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ambientSphere.setRadius(150);
    myDevice = new AmbientDevice();
  }

  /**
   * Handler for WaterFlowData button; sets the color of the ambient device to most recent values
   */
  public void handleWaterFlowClick() throws IOException {
    WaterFlowData currentData = new WaterFlowData();
    currentData.setData();
    myDevice.setColor(currentData.calculateOverflow());
    myDevice.setBrightness(currentData.calculateOverflow());
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(myDevice.getColor());
    phongMaterial.setSpecularColor(Color.YELLOW);
    phongMaterial.setSpecularPower(myDevice.getBrightness());
    ambientSphere.setMaterial(phongMaterial);

    waterFlowDate.setText("Date: " + currentData.getDate());
    waterFlowTime.setText("Time: " + currentData.getTime());
    waterFlowOutflow.setText("Outflow: " + currentData.getOutflow());
    waterFlowInflow.setText("Inflow: " + currentData.getInflow());
    waterFlowTitle.setText("Kings River Basin Inflow and Outflow Data");
    waterFlowStatus.setText("Status: " + currentData.getStatus());
  }

  public void handleTemperatureClick() throws IOException {
    TemperatureData currentTemp = new TemperatureData();
    currentTemp.setData();
  }
}
