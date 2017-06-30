package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;



public class Main extends Application  {

    //declare variables and objects
    Circle displayCircle;
    AmbientDevice myDevice;
    String color;
    Double brightness;
    ColorAdjust colorAdjust;

    public static void main(String[] args) {
    launch(args);
  }

      @Override
      public void start(Stage primaryStage) throws Exception{
          Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
          primaryStage.setTitle("AmbientDevice");

          //create and initialize objects
          displayCircle = new Circle(150);
          myDevice = new AmbientDevice(99,99);
          colorAdjust = new ColorAdjust();
          color = AmbientDevice.getColor();
          brightness = AmbientDevice.getBrightness();
          colorAdjust.setBrightness(brightness);

          //set ambient output color and brightness
          displayCircle.setFill(Color.web(color));
          displayCircle.setEffect(colorAdjust);

          //create layout and display in the scene
          StackPane layout = new StackPane();
          layout.getChildren().add(displayCircle);
          primaryStage.setScene(new Scene(layout, 400, 350));
          primaryStage.show();
    }

}
