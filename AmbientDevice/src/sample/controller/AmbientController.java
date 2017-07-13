package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.control.Label;
import sample.model.AmbientDevice;
import sample.model.WaterFlowData;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AmbientController implements Initializable {
  @FXML
  private Sphere ambientSphere;
  private AmbientDevice myDevice;
  @FXML
  private Label waterFlowDate;
  @FXML
  private Label waterFlowTime;
  @FXML
  private Label waterFlowOutflow;
  @FXML
  private Label waterFlowInflow;

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
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(myDevice.getColor());
    ambientSphere.setMaterial(phongMaterial);
    waterFlowDate.setText("Date: " + currentData.getDate());
    waterFlowTime.setText("Time: " + currentData.getTime());
    waterFlowOutflow.setText("Outflow: " + currentData.getOutflow());
    waterFlowInflow.setText("Inflow: " + currentData.getInflow());
  }
}