package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chasepugh on 7/21/17.
 */
public class RootController implements Initializable {
  private Main main;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
  @FXML
  public void handleAdjustClick() throws IOException {
    System.out.print("Gold!");
    main.showSettingsScene();

      // these two of them return the same stage
      // Swap screen
   // primaryStage.setScene(new Scene(new Pane()));


  }
}

