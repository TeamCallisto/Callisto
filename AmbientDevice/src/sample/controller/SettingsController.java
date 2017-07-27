package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import sample.model.TempData;
import sample.model.WaterFlowData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable{

  //Initialize values
  ObservableList<Integer> scale = FXCollections.observableArrayList(50, 100, 300, 500, 1000, 2000, 4000, 5000, 6000, 8000, 10000);
  ObservableList<Integer> scaleMinTemp = FXCollections.observableArrayList(50, 55, 60, 65, 70);
  ObservableList<Integer> scaleMaxTemp = FXCollections.observableArrayList(75, 80, 85, 90, 95, 100);
  @FXML
  private ChoiceBox scaleBox,scaleBoxMinTemp, scaleBoxMaxTemp;
  private WaterFlowData waterFlowData;
  private TempData tempData;

  //Initialize values in UI choice boxes
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    scaleBox.setItems(scale);
    scaleBoxMinTemp.setItems(scaleMinTemp);
    scaleBoxMaxTemp.setItems(scaleMaxTemp);
  }

  //Handlers for the selection of values in the UI choice boxes
  public void handleScale() {
    scaleBox.setValue(scaleBox.getValue());
  }
  public void handleScaleMaxTemp() {
    scaleBoxMaxTemp.setValue(scaleBoxMaxTemp.getValue());
  }
  public void handleScaleMinTemp() {
    scaleBoxMinTemp.setValue(scaleBoxMinTemp.getValue());
  }


  //Handlers to save the new scales
  public void handleScaleSave() throws IOException {
    waterFlowData = new WaterFlowData();
    waterFlowData.setScale((Integer) scaleBox.getValue());
  }
  public void handleScaleTempSave() throws IOException {
    tempData = new TempData();
    tempData.setMax((Integer) scaleBoxMaxTemp.getValue());
    tempData.setMin((Integer) scaleBoxMinTemp.getValue());
  }

}



