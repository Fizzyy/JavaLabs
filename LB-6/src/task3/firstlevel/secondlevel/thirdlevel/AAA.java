package task3.firstlevel.secondlevel.thirdlevel;

import task3.firstlevel.secondlevel.Student;

import java.time.LocalDate;

public class AAA implements Student {
    private String name;
    private String surname;
    private String fathersname;
    private LocalDate birthday;

    private String university;
    private LocalDate firstDate;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFathersName(String fathername) {
        this.fathersname = fathername;
    }

    public void setBirthday(int yyyy, int mm, int dd) {
        if (limitBirthYear < yyyy) this.birthday = LocalDate.of(yyyy, mm, dd);
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getFathersName() {
        return this.fathersname;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setFirstDate(LocalDate date) {
        this.firstDate = date;
    }

    public LocalDate getFirstDate() {
        return this.firstDate;
    }

    public void setUniversity(String universityName) {
        if (universityName.length() > limitUniversityLength) this.university = universityName;
    }

    public String getUniversity() {
        return this.university;
    }
}
