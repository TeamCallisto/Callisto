package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

  private Stage primaryStage;
  private static BorderPane rootLayout;

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    primaryStage.setTitle("AmbientDevice");
    initRootLayout();
    showUserView();
  }

  private void initRootLayout() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
      rootLayout = loader.load();
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
      primaryStage.show();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void showUserView() {
    try {
      FXMLLoader loader;
      loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/UserView.fxml"));
      BorderPane userView = loader.load();
      rootLayout.setCenter(userView);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void showSettingsScene() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("view/SettingsView.fxml"));
    BorderPane settingsView = loader.load();
    rootLayout.setCenter(settingsView);

  }
  public static void main(String[] args) {
    launch(args);
  }
}
