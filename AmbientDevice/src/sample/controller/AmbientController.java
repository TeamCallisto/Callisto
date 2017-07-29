package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
  private WaterFlowData currentData;

  /**
   * This code initializes the AmbientDevice display to the default values
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ambientSphere.setRadius(85);
    myDevice = new AmbientDevice();
  }

  /**
   * Handler for WaterFlowData button; sets the color of the ambient device to most recent values
   */
  public void handleWaterFlowClick() throws IOException {
    currentData = new WaterFlowData();
    currentData.setData();
    myDevice.setColor(currentData.calculateOverflow());

    //myDevice.setColor(25);

    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(myDevice.getColor());
    ambientSphere.setMaterial(phongMaterial);

    Date.setText("Date: " + currentData.getDate());
    Time.setText("Time: " + currentData.getTime());
    Outflow.setText("Outflow: " + currentData.getOutflow());
    Inflow.setText("Inflow: " + currentData.getInflow());
    Title.setText("Kings River Basin Inflow and Outflow Data");
    Status.setText("Status: " + currentData.getStatus());
    Status.setLayoutY(180.0);
  }
  /**
   * Handler for TemperatureData button; sets the color of the ambient device to most recent values
   */
  public void handleTemperatureClick() throws IOException {
    TempData currentData = new TempData();
    currentData.setData();
    myDevice.setColor(100);
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(myDevice.getBrightnessValue(currentData.calculateTempBrightnessValue()));

    //phongMaterial.setDiffuseColor(myDevice.getBrightnessValue(0));
    ambientSphere.setMaterial(phongMaterial);

    Title.setText("Current Honolulu Temperature");
    Time.setText("Time: " + currentData.getTime());
    Date.setText("Date: " + currentData.getDate());
    Status.setText("Status: " + currentData.getStatus());
    Status.setLayoutY(140.0);
    Inflow.setText("");
    Outflow.setText("Current temp: " + currentData.getTemperature());
  }

  public void handleIncidentClick() throws IOException {
    currentData = new IncidentData();
    currentData.setData();
    myDevice.setColor(currentData.calculateTrafficStatus());

    //myDevice.setColor(25);

    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(myDevice.getColor());
    ambientSphere.setMaterial(phongMaterial);

    Date.setText("Date: " + currentData.getDate());
    Time.setText("Time: " + currentData.getTime());
    Outflow.setText("Incident: " + currentData.getIncident());
    Inflow.setText("Facility: " + currentData.getFacility());
    Title.setText("Current Incidents and Traffic on Oahu");
    Status.setText("Description: " + currentData.getDescription());
    Status.setLayoutY(180.0);
  }

}