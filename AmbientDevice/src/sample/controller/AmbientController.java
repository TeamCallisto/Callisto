package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import sample.model.AmbientDevice;
import sample.model.WaterFlowData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AmbientController implements Initializable {
  @FXML
  private Sphere ambientSphere;
  @FXML
  private Label waterFlowDate, waterFlowTitle, waterFlowTime, waterFlowOutflow, waterFlowInflow;
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
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(myDevice.getColor());
    phongMaterial.setSpecularColor(Color.WHITE);
    phongMaterial.setSpecularPower(1.0);
    ColorAdjust colorAdjust = new ColorAdjust();
    colorAdjust.setSaturation(10.0);
    ambientSphere.setMaterial(phongMaterial);

    waterFlowDate.setText("Date: " + currentData.getDate());
    waterFlowTime.setText("Time: " + currentData.getTime());
    waterFlowOutflow.setText("Outflow: " + currentData.getOutflow());
    waterFlowInflow.setText("Inflow: " + currentData.getInflow());
    waterFlowTitle.setText("Kings River Basin Inflow and Outflow Data");
  }
}
