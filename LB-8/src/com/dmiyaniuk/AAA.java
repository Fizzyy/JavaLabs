package com.dmiyaniuk;

import exceptions.*;

public class AAA {

    public AAA(Integer number) throws ExceptionAAA1 {
        if (number == null) throw new ExceptionAAA1();
        System.out.println("Received number in constructor: " + number);
    }

    public void methode(Integer number) throws ExceptionAAA2, ExceptionAAA3 {
        if (number == 0) throw new ExceptionAAA2();
        if (number < 0) throw new ExceptionAAA3();
        System.out.println("Received number in method: " + number);
    }
}
