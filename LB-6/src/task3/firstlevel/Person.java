package task3.firstlevel;

import java.time.LocalDate;

public interface Person {
    int limitBirthYear = 1900;
    void setSurname(String surname);
    void setName(String name);
    void setFathersName(String fathername);
    void setBirthday(int yyyy, int mm, int dd);
    String getSurname();
    String getName();
    String getFathersName();
    LocalDate getBirthday();
}
