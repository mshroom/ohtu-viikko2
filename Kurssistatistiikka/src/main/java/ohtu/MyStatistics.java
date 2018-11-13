package ohtu;

import java.util.ArrayList;
import java.util.List;

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

    public void printStatistics() {
        for (String course : myCourses) {
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
            for (int i = 0; i < cur.getExercises().length; i ++) {
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
        }
    }

}
