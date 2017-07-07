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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.Map;





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
          myDevice = new AmbientDevice(1,0);
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

        Document data = Jsoup.connect("http://www.spk-wc.usace.army.mil/fcgi-bin/hourly.py?report=pnf").timeout(6000).get();
        Elements elements = data.select("pre");
        String myString = elements.toString();
        Scanner scan = new Scanner(myString);
        Map dictionary = new HashMap();
        for(int i = 0; i < 10; i++) {
          String line = scan.nextLine();
          Pattern p = Pattern.compile("([0-9]{2}[A-Z]{3,4}[0-9]{4})\\s+[0-9]*\\s+[0-9\\.]*\\s+[0-9]*\\s+[0-9\\.]*\\s+([0-9]*)\\s+([0-9]*)");
          Matcher m = p.matcher(line);
          if ( m.find()){
            System.out.println(m.group(3));
          }
        }

    }

}
