package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
  private Main main;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
  @FXML
  private void handleSettingsClick() throws IOException {
    main.showSettingsScene();
  }

  @FXML
  private void goHome() {
    main.showUserView();
  }

}

