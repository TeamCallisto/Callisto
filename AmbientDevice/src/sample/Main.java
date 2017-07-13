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
  private BorderPane rootLayout;

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    primaryStage.setTitle("AmbientDevice");
    initRootLayout();
    showUserView();
  }

  public void initRootLayout() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
      rootLayout = (BorderPane) loader.load();
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
      primaryStage.show();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showUserView() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/UserView.fxml"));
      AnchorPane userView = (AnchorPane) loader.load();
      rootLayout.setCenter(userView);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

/*
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

        //Grab data from website with Jsoup webscrapping library
        Document data = Jsoup.connect("http://www.spk-wc.usace.army.mil/fcgi-bin/hourly.py?report=pnf").timeout(6000).get();
        Elements elements = data.select("pre");
        String myString = elements.toString();

        //Put the data into a scanner object
        Scanner scan = new Scanner(myString);

        //Create a map to store the time of the event and the values
        Map<String,List<String>> multiMap = new HashMap<String,List<String>>();


        //Loop through the data a pull out the inflow and outflow data
        while (scan.hasNextLine()) {
          String line = scan.nextLine();
          Pattern p = Pattern.compile("([0-9]{2}[A-Z]{3,4}[0-9]{4})\\s+([0-9]*)\\s+[0-9\\.]*\\s+[0-9]*\\s+[0-9\\.]*\\s+([0-9]*)\\s+([0-9]*)");
          Matcher m = p.matcher(line);
          if ( m.find()){
            String key = m.group(1)+ m.group(2);
            List<String> values = new ArrayList<String>();
            values.add(m.group(3));
            values.add(m.group(4));
            multiMap.put(key, values);
          }
        }

        //Loop through the map and print the values
        for (Map.Entry<String, List<String>> entry : multiMap.entrySet()) {
          String key = entry.getKey();
          List<String> values = entry.getValue();
          System.out.println("Key = " + key);
          System.out.println("Values = " + values + "n");
        }

    }*/

