package sample.model;
import com.sun.org.apache.xml.internal.utils.DOMBuilder;
import javafx.scene.web.WebEngine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javafx.scene.web.WebView;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import org.jsoup.nodes.Element;
import java.util.List;




import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.util.ArrayList;





public class TrafficData {

    //Initialize values

    private String date, time, facility, eventType, description;
    private int totalTraffic;
    public List<String> facilityList = new ArrayList<String>();
    public List<String> eventTypeList = new ArrayList<String>();

    //Constructor
    public TrafficData() throws IOException {
        this.date = "";
        this.time = "";
        this.facility = "";
        this.eventType = "";
        this.description = "";
        this.totalTraffic=0;

    }

    public  void setTotalTraffic(int totalTraffic)
    {
        this.totalTraffic=totalTraffic;
    }

    public int getTotalTraffic()
    {
        return  this.totalTraffic;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return this.time;
    }

    public String getFacility() {
        return this.facility  ;
    }

    public String getEventType() {
        return this.eventType  ;
    }

    public String getDescription() {
        return this.description  ;
    }

    public String getDate() {
        return this.date  ;
    }

    //Method to grab values from the external website and set the values for the object
    public void setData() {
        Document data = null;


        try {
////////////////////////           WebView Sample for extracting DateTime//////////////////////////////////////////////////////////

//            WebView view = new WebView();
//            WebEngine engine = view.getEngine();
//
//
//            engine.getLoadWorker().stateProperty().addListener(
//                    new ChangeListener<State>() {
//                        @Override public void changed(ObservableValue ov, State oldState, State newState) {
//
//                            if (newState == Worker.State.SUCCEEDED) {
//
//                                String doc = engine.getDocument().toString();
//
//                                System.out.println("called");
//                            }
//
//                        }
//                    });
//            engine.load("http://www.goakamai.org/icx/pages/incidentlist.aspx");



            ///////////////////////////////////////////////////

            data = Jsoup.connect("http://www.goakamai.org/icx/pages/incidentlist.aspx").timeout(6000).get();

           // data = Jsoup.parse(new File("D://view4.html"), "ISO-8859-1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert data != null;
        Elements timeHTML=data.select("div#lastRefresh");
        String time=timeHTML.get(0).text();
        Elements curTime = data.select("div#IncidentListBox");
        curTime = curTime.select("table");

        Elements rows = curTime.select("tr");

        setTotalTraffic(rows.size());


        for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            setFacility(cols.get(1).text());
            setEventType(cols.get(2).text());
            setDescription(cols.get(3).text());

            facilityList.add(cols.get(1).text());
            eventTypeList.add(cols.get(2).text());

            System.out.println(getFacility());
            System.out.println(getEventType());
            System.out.println(getDescription());
        }


//        String myTime = timeHTML;
//        Pattern p = Pattern.compile("([0-9]{1,2}:[0-9]{2}\\s)(PM|AM)\\s[A-Z]{2,4}\\son\\s([A-Z][a-z]{0,10}\\s[0-9]{1,2},\\s[0-9]{4})");
//        Matcher m = p.matcher(myTime);
//        if (m.find()) {
//            time = m.group(1) + m.group(2);
//            date = m.group(3);
//            System.out.print(date + " " + time);
//        }

    }




}

