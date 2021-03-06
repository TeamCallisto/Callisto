package sample.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WaterFlowData {

  private String date, time, status;
  private int outflow, inflow, overage, overageActual;
  private static Integer scale;

  public WaterFlowData() throws IOException {
    this.date = "";
    this.time = "";
    this.outflow = 0;
    this.inflow = 0;
    this.overage = 10;
    if(scale == null) {
      scale = 5000;
    }
  }
  public void setScale(Integer newScale) {
    scale = newScale;
  }
  public void setInflow(int newInflow) {
    this.inflow = newInflow;
  }
  public void setOutflow(int newOutflow) {
    this.outflow = newOutflow;
  }

  public void setData() {

    /* Grab data from website with Jsoup webscrapping library */
    Document data = null;
    try {
      data = Jsoup.connect("http://www.spk-wc.usace.army.mil/fcgi-bin/hourly.py?report=pnf").timeout(6000).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assert data != null;
    Elements elements = data.select("pre");
    String myString = elements.toString();

    //Put the data into a scanner object
    Scanner scan = new Scanner(myString);

    //Loop through the data a pull out the inflow and outflow data
    while (scan.hasNextLine()) {
      String line = scan.nextLine();
      Pattern p = Pattern.compile("([0-9]{2}[A-Z]{3,4}[0-9]{4})\\s+([0-9]*)\\s+[0-9\\.]*\\s+[0-9]*\\s+[0-9\\.]*\\s+([0-9]*)\\s+([0-9]*)");
      Matcher m = p.matcher(line);
      if (m.find()) {
        if (!m.group(3).isEmpty()) {
          if (Objects.equals(m.group(3), "-NR-")) {
            outflow = 0;
          } else {
            outflow = Integer.parseInt(m.group(3));
          }
          if (Objects.equals(m.group(4), "-NR-")) {
            inflow = 0;
          } else {
            inflow = Integer.parseInt(m.group(4));
          }
          date = m.group(1);
          time = m.group(2);
        }
      }
    }
  }
  public int calculateOverflow() {
    int scaleVal = 0;
    if (outflow >= inflow) {
      overage = 10;
      status = "Outflow is greater than inflow. No alert.";
    } else {
      scaleVal = scale / 100;
      overage = inflow - outflow;
      overage = overage / scaleVal;
      if(overage > 75) {
        status = "Urgent! The inflow is significantly higher than outflow!";
      } else if(overage > 40) {
        status = "Overflow risk is immediate";
      } else if(overage > 20) {
        status = "Not urgent, but risk is increasing";
      } else
        status = "Low risk";
    }
    System.out.println(overageActual + " actual");
    System.out.println(overage + " overage");
    System.out.println(outflow + " outflow" + " ");
    System.out.println(inflow + " inflow" + " ");
    System.out.println("scale " + scale);
    return overage;
  }

  public String getDate() { return date; }
  public String getTime() { return time; }
  public String getStatus() { return status; }
  public int getInflow() {
    return inflow;
  }
  public int getOutflow() {
    return outflow;
  }
  public Integer getScale() { return scale; }}



