package sample.controller;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.util.Callback;
import sample.model.AmbientDevice;
import sample.model.TempData;
import sample.model.TrafficData;
import sample.model.WaterFlowData;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
public class AmbientController implements Initializable {
  @FXML
  private Sphere ambientSphere;
  @FXML
  private Label Date, Title, Time, Outflow, Inflow, Status, errorLabel;
  @FXML private GridPane gridPaneList;


  private AmbientDevice myDevice;
  private WaterFlowData currentData;
  public TableView<Traffic> table;

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
    if(table != null) {
      table.setVisible(false);
    }
    currentData = new WaterFlowData();
    currentData.setData();
    myDevice.setColor(currentData.calculateOverflow());

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
    errorLabel.setText(currentData.getErrorStatus());
  }
  /**
   * Handler for TemperatureData button; sets the color of the ambient device to most recent values
   */
  public void handleTemperatureClick() throws IOException {
    if(table != null) {
      table.setVisible(false);
    }
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
    Status.setLayoutY(180.0);
    errorLabel.setText("");
  }



  public void handleTrafficClick()throws IOException
  {
    //Clear out text fields on the GUI
    Time.setText("");
    Date.setText("");
    Status.setText("");
    Inflow.setText("");
    Outflow.setText("");
    errorLabel.setText("");
    ObservableList<Traffic> data = FXCollections.observableArrayList();


    table = new TableView<Traffic>();
    table.setMinWidth(310);

    TableColumn facilityColumn = new TableColumn("Facility");
    facilityColumn.setMinWidth(150);


    facilityColumn.setCellValueFactory( new PropertyValueFactory<>("Facility"));

    TableColumn eventTypeCol = new TableColumn("Event Type");
    eventTypeCol.setMinWidth(150);
    eventTypeCol.setCellValueFactory(
            new PropertyValueFactory<>("EventType"));


    TrafficData trafficData = new TrafficData();
    trafficData.setData();


      /////////////////////////////////////////////////







    /////////////////////////////////////////////////

    int totalTraffic=trafficData.getTotalTraffic();
    if (totalTraffic==0)
      myDevice.setColor(0);
    else
      myDevice.setColor((totalTraffic*5)+55);
   // myDevice.setColor((4*15));
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseColor(myDevice.getColor());
    ambientSphere.setMaterial(phongMaterial);

     ///Check if record exist or not
    if(trafficData.getTotalTraffic()!=0)
    {

        Title.setText("Total Record Found: "+trafficData.getTotalTraffic());

        //Loop through all the records and add it to data
      for (int i = 0; i < trafficData.facilityList.size(); i++) {

        data.add(new Traffic(trafficData.facilityList.get(i),trafficData.eventTypeList.get(i)));
      }

      table.setItems(data); // add data to table
      table.getColumns().addAll(facilityColumn, eventTypeCol);

      gridPaneList.getChildren().add(table);  //add table to GUI


    }
else
    {
      Title.setText("Status: " + "No record Found");
    }



  }

  // A class for Record which contains 2 basic attributes. Facility and EventType

  public static class Traffic {

    private  SimpleStringProperty facility;
    private  SimpleStringProperty eventType;

    private Traffic(String facility, String eventTYpe) {
      this.facility = new SimpleStringProperty(facility);
      this.eventType = new SimpleStringProperty(eventTYpe);
    }

    public String getFacility() {
      return facility.get();
    }

    public void setFacility(String facility) {
      this.facility.set(facility);
    }

    public String getEventType() {
      return this.eventType.get();
    }

    public void setEventType(String eventtype) {
      this.eventType.set(eventtype);
    }
  }

}