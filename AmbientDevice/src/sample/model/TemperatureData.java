package sample.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TemperatureData {

  private String date, time, status;
  private double temperature;

  public TemperatureData() throws IOException {
    this.date = "";
    this.time = "";
    this.temperature = 0.0;
  }

  public void setData() {
     /* Grab data from website with Jsoup webscrapping library */
    Document data = null;
    try {
      data = Jsoup.connect("https://www.wunderground.com/us/hi/honolulu").timeout(6000).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assert data != null;
    Elements curTime = data.select("div.local-time");
    curTime = curTime.select("span");
    time = curTime.text();

    Elements temp = data.select("div[id=curTemp]");
    temp = temp.select("span.wx-value");
    String myString = temp.text();
    temperature = Double.parseDouble(myString);
    System.out.println(time);
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public String getStatus() {
    return status;
  }

  public double getTemperature() {
    return temperature;
  }
}

