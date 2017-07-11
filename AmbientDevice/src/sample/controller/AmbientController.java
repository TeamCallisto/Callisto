package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import sample.model.AmbientDevice;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;


public class AmbientController implements Initializable {
  @FXML
  private Sphere ambientSphere;
  private AmbientDevice myDevice = new AmbientDevice(99,99);
  private ColorAdjust colorAdjust;
  private String color;
  private double brightness;

  /**This code initializes the AmbientDevice display to the default values*/
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ambientSphere.setRadius(150);
    myDevice = new AmbientDevice(99,99);
    colorAdjust = new ColorAdjust();
    String color = AmbientDevice.getColor();
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(Color.HOTPINK);
    ambientSphere.setMaterial(phongMaterial);
  }

  public void handleWaterFlowClick (){
    System.out.println("WaterFlow data");
  }


}
