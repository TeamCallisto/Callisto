package sample.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IncidentData {

    //Initialize values
    private String facility, incident, description;

    //Constructor
    public IncidentData() throws IOException {
        this.facility = "";
        this.incident = "";
        this.description = "";
  }

        //Method to grab values from the external website and set the values for the object

    public void setData() {
        Document data = null;
        try {
            data = Jsoup.connect("http://goakamai.org/icx/pages/incidentlist.aspx").timeout(6000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert data != null;

        Elements curIncident = data.select("div[id=IncidentListBox]");
        curIncident = curIncident.select("span");
        String myIncident = curIncident.text();
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(myIncident);
        if (m.find()) {
            facility = m.group();
            incident = m.group(2);
            description = m.group();
            System.out.print(facility + ": " + incident);
            System.out.println(description);
        }

        Elements curTime = data.select("div[id=lastRefresh.lastRefreshTime]");
        curTime = curTime.select("span");
        String myTime = curTime.text();
       // Pattern p = Pattern.compile("([0-9]{1,2}:[0-9]{2}\\s)(PM|AM)\\s[A-Z]{2,4}\\son\\s([A-Z][a-z]{0,10}\\s[0-9]{1,2},\\s[0-9]{4})");
        Matcher m = p.matcher(myTime);
        if (m.find()) {
            time = m.group(1) + m.group(2);
            date = m.group(3);
            System.out.print(date + " " + time);
        }

    }

    public int calculateTrafficStatus() {

    }

    public String getFacility() {return facility; }
    public String getIncident() {
        return incident;
    }
    public String getDescription() {
        return description;
    }

}