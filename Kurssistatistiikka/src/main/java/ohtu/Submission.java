package ohtu;

import java.util.List;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private String course;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int[] getExercises() {
        return exercises;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
    
    private String listExercises() {
        String r = "";
        if (this.exercises.length < 1) {
            return r;
        }
        for (int i = 0; i <= this.exercises.length - 2; i ++) {
            r += this.exercises[i] + ", ";
        }
        r += this.exercises[this.exercises.length - 1];
        return r;
    }

    @Override
    public String toString() {
        String r = course + ", viikko " + week + ":\n" + " tehtyjä tehtäviä yhteensä " + exercises.length + " aikaa kului " + hours + " tehdyt tehtävät: " + this.listExercises();
        return r;
    }
    
    public String toStringWithCourseInformation(Course[] courses) {
        Course cur = null;
        for (Course c : courses) {
            if (c.getName().equals(this.course)) {
                cur = c;
            }
        }
        String r = "viikko " + week + ":\n" + " tehtyjä tehtäviä yhteensä " + exercises.length + "/" + (cur.getExercises()[week]) + " aikaa kului " + hours + " tehdyt tehtävät: " + this.listExercises();
        return r;
    }
    
}