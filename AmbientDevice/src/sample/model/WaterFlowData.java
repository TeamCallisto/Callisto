package sample.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WaterFlowData {

  private static String date;
  private static String time;
  private static int outflow;
  private static int inflow;
  private static int overage;
  private static int overageActual;

  public WaterFlowData() throws IOException {
    this.date = "";
    this.time = "";
    this.outflow = 0;
    this.inflow = 0;
    this.overage = 0;
  }

  public static void setData() {

    /* Grab data from website with Jsoup webscrapping library */
    Document data = null;
    try {
      data = Jsoup.connect("http://www.spk-wc.usace.army.mil/fcgi-bin/hourly.py?report=pnf").timeout(6000).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
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
          if (m.group(3) == "-NR-") {
            outflow = 0;
          } else {
            //outflow = Integer.parseInt(m.group(3));
            outflow = 4000;
          }
          if (m.group(4) == "-NR-") {
            inflow = 0;
          } else {
            //inflow = Integer.parseInt(m.group(4));
            inflow = 9000;
          }
          date = m.group(1);
          time = m.group(2);
        }
      }
    }

  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public int getInflow() {
    return inflow;
  }

  public int getOutflow() {
    return outflow;
  }

  public int calculateOverflow() {
    if (outflow >= inflow) {
      overage = 0;
    } else {
      overage = inflow - outflow;
      overageActual = overage;
      overage = overageActual/50;
//      if (overage > 10000) {
//        overage = 100;
//      } else if (overage > 5000) {
//        overage = 90;
//      } else if (overage > 3000) {
//        overage = 80;
//      } else if (overage > 2500) {
//        overage = 70;
//      } else if (overage > 2000) {
//        overage = 60;
//      } else if (overage > 1500) {
//        overage = 50;
//      } else if (overage > 1000) {
//        overage = 40;
//      } else if (overage > 800) {
//        overage = 30;
//      } else if (overage > 500) {
//        overage = 20;
//      } else if (overage > 200) {
//        overage = 10;
//      } else
//        overage = 0;

    }
    System.out.println(overageActual + " actual");
    System.out.println(overage + " overage");
    System.out.println(outflow + " outflow" + " ");
    System.out.println(inflow + " inflow" + " ");
    return overage;
  }
}

