package ohtu;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;

public class MyStatistics {

    private Submission[] subs;
    private Course[] courses;
    private List<String> myCourses;

    public MyStatistics(Submission[] subs, Course[] courses) {
        this.subs = subs;
        this.courses = courses;
        this.myCourses = new ArrayList<>();
        for (Submission submission : subs) {
            if (!myCourses.contains(submission.getCourse())) {
                myCourses.add(submission.getCourse());
            }
        }
    }

    public void printStatistics() throws IOException {
        for (String course : myCourses) {
            String url3 = "https://studies.cs.helsinki.fi/courses/" + course + "/stats";
            String statsResponse = Request.Get(url3).execute().returnContent().asString();
            JsonParser parser = new JsonParser();
            JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
            int ss = 0;
            int es = 0;
            int hs = 0;
            for (String key : parsittuData.keySet()) {
                ss += parsittuData.get(key).getAsJsonObject().get("students").getAsInt();
                es += parsittuData.get(key).getAsJsonObject().get("exercise_total").getAsInt();
                hs += parsittuData.get(key).getAsJsonObject().get("hour_total").getAsInt();
            }            
            int sumE = 0;
            int sumH = 0;
            int ex = 0;
            Course cur = null;
            for (Course c : courses) {
                if (c.getName().equals(course)) {
                    cur = c;
                    System.out.println("");
                    System.out.println(c.getFullName() + " " + c.getTerm() + " " + c.getYear());
                    System.out.println("");
                }
            }
            for (int i = 0; i < cur.getExercises().length; i++) {
                ex += cur.getExercises()[i];
            }
            for (Submission s : subs) {
                if (s.getCourse().equals(course)) {
                    sumE += s.getExercises().length;
                    sumH += s.getHours();
                    System.out.println(s.toStringWithCourseInformation(courses));
                }
            }
            System.out.println("");
            System.out.println("Yhteensä: " + sumE + "/" + ex + " tehtävää " + sumH + " tuntia");
            System.out.println("");
            System.out.println("Kurssilla yhteensä " + ss + " palautusta, palautettuja tehtäviä " + es + " kpl, aikaa käytetty yhteensä " + hs + " tuntia");
        }
    }

}
