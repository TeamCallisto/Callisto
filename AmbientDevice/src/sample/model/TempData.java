package sample.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TempData {

  //Initialize values
  private String date, time, status;
  private double actualTemperature;
  private static Integer min, max;

  //Constructor
  public TempData() throws IOException {
    this.date = "";
    this.time = "";
    this.actualTemperature = 0.0;
    if(min == null) {
      min = 50;
    }
    if(max == null) {
      max = 100;
    }
  }
  public void setMin(Integer newMin) {
    min = newMin;
  }
  public void setMax(Integer newMax) {
    max = newMax;
  }

  //Method to grab values from the external website and set the values for the object
  public void setData() {
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
    actualTemperature = Double.parseDouble(myString);
    System.out.println(actualTemperature);
  }

  public int calculateTempBrightnessValue() {
    double scaleTemp;
    double scale;
    double tempDifference;
    System.out.println(actualTemperature + " " + max);
    if(actualTemperature < min) {
      status = "Below normal!";
      return 0;
    } else if(actualTemperature > max ) {
      status = "Urgent! Its hot!";
      return 99;
    } else {
      tempDifference = max - min;
      scale = tempDifference / 100;
      scaleTemp = actualTemperature - min;
      scaleTemp = scaleTemp / scale;
      if(scaleTemp > 75) {
        status = "Urgent! Its hot!";
      } else if(scaleTemp > 40) {
        status = "Average Temp range";
      } else if(scaleTemp > 20) {
        status = "Its cool outside";
      } else
        status = "Below normal!";
    }
      return (int) scaleTemp;
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
    return actualTemperature;
  }

}