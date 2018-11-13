package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        String url2 = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
        /*
        System.out.println("json-muotoinen data:");
        System.out.println(bodyText2);
        */

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        for (int i = 0; i <= subs.length - 1; i ++) {
            Submission s = subs[i];
        }
        
        Gson mapper2 = new Gson();
        Course[] courses = mapper2.fromJson(bodyText2, Course[].class);        

        System.out.println("Opiskelijanumero " + studentNr);
        MyStatistics myStats = new MyStatistics(subs, courses);
        myStats.printStatistics();

    }
}
