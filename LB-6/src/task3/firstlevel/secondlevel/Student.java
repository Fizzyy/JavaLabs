package task3.firstlevel.secondlevel;

import task3.firstlevel.Person;

import java.time.LocalDate;

public interface Student extends Person {
    void setFirstDate(LocalDate date);
    LocalDate getFirstDate();
    void setUniversity(String universityName);
    String getUniversity();
    int limitUniversityLength = 2;
}
