package sample.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TempData {

  private String date, time, status;
  private double temperature;

  public TempData() throws IOException {
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
    String myTime = curTime.text();
    Pattern p = Pattern.compile("([0-9]{1,2}:[0-9]{2}\\s)(PM|AM)\\s[A-Z]{2,4}\\son\\s([A-Z][a-z]{0,10}\\s[0-9]{1,2},\\s[0-9]{4})");
    Matcher m = p.matcher(myTime);
    if (m.find()) {
      time = m.group(1) + m.group(2);
      date = m.group(3);
      System.out.print(date + " " + time);
    }
    Elements temp = data.select("div[id=curTemp]");
    temp = temp.select("span.wx-value");
    String myString = temp.text();
    temperature = Double.parseDouble(myString);
    System.out.println(temperature);
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