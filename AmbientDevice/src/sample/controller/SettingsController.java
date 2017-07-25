package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import sample.model.WaterFlowData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chasepugh on 7/24/17.
 */
public class SettingsController implements Initializable{

  ObservableList<Integer> scaleMin = FXCollections.observableArrayList(0, 50, 100, 300, 500, 1000, 2000, 5000);
  ObservableList<Integer> scaleMax = FXCollections.observableArrayList(5000, 6000, 7000, 8000, 9000, 10000);
  @FXML
  private ChoiceBox scaleBoxMin, scaleBoxMax;
  @FXML
  private Button scaleSave;
  private WaterFlowData waterFlowData;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    scaleBoxMin.setItems(scaleMin);
    scaleBoxMax.setItems(scaleMax);
  }

  public void handleScaleMin() {
    scaleBoxMin.setValue(scaleBoxMin.getValue());
  }
  public void handleScaleMax() {
    scaleBoxMax.setValue(scaleBoxMax.getValue());
  }
  public void handleScaleSave() throws IOException {
    System.out.print(scaleBoxMin.getValue());
    System.out.print(scaleBoxMax.getValue());
    waterFlowData = new WaterFlowData();
    waterFlowData.setScaleMax((Integer) scaleBoxMax.getValue());
    waterFlowData.setScaleMin((Integer) scaleBoxMin.getValue());
  }

}



