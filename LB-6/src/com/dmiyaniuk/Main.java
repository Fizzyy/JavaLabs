package com.dmiyaniuk;

import task3.firstlevel.secondlevel.thirdlevel.AAA;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        AAA aaa = new AAA();
        aaa.setSurname("Yaniuk");
        aaa.setName("Dmitry");
        aaa.setFathersName("Sergeevich");
        aaa.setBirthday(2000, 6, 27);

        aaa.setUniversity("BelSTU");
        aaa.setFirstDate(LocalDate.of(2017, 8, 14));

        System.out.println("Full name: " + aaa.getSurname() + " " + aaa.getName() + " " + aaa.getFathersName());
        System.out.println("Birthday: " + aaa.getBirthday());
        System.out.println("University: " + aaa.getUniversity() + ", start date: " + aaa.getFirstDate());
    }
}
