package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import sample.model.AmbientDevice;
import sample.model.TempData;
import sample.model.WaterFlowData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AmbientController implements Initializable {
  @FXML
  private Sphere ambientSphere;
  @FXML
  private Label Date, Title, Time, Outflow, Inflow, Status;
  private AmbientDevice myDevice;

  /**
   * This code initializes the AmbientDevice display to the default values
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ambientSphere.setRadius(80);
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(Color.AQUA);
    ambientSphere.setMaterial(phongMaterial);
    myDevice = new AmbientDevice();
  }

  /**
   * Handler for WaterFlowData button; sets the color of the ambient device to most recent values
   */
  public void handleWaterFlowClick() throws IOException {
    WaterFlowData currentWaterflowData = new WaterFlowData();
    currentWaterflowData.setData();
    myDevice.setColor(currentWaterflowData.calculateOverflow());
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(myDevice.getColor());
    ambientSphere.setMaterial(phongMaterial);
    System.out.print(ambientSphere.getRadius());

    Date.setText("Date: " + currentWaterflowData.getDate());
    Time.setText("Time: " + currentWaterflowData.getTime());
    Outflow.setText("Outflow: " + currentWaterflowData.getOutflow());
    Inflow.setText("Inflow: " + currentWaterflowData.getInflow());
   Title.setText("Kings River Basin Inflow and Outflow Data");
    Status.setText("Status: " + currentWaterflowData.getStatus());
  }
  /**
   * Handler for TemperatureData button; sets the color of the ambient device to most recent values
   */
  public void handleTemperatureClick() throws IOException {
    TempData currentTempData = new TempData();
    currentTempData.setData();
    Title.setText("Current Honoluu Temperature");
    Time.setText("Time: " + currentTempData.getTime());
    Date.setText("Date: " + currentTempData.getDate());
    Status.setText("Status: " + currentTempData.getStatus());
    Outflow.setText("");
    Inflow.setText("Current temp: " + currentTempData.getTemperature());

  }
}