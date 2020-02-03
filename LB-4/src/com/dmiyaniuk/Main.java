package com.dmiyaniuk;

public class Main {

    public static void main(String[] args) {
        //Task1
	    CCC ccc = new CCC();
	    System.out.println("Parameterless object CCC: x = " + ccc.getPropertyX() + " y = " + ccc.getPropertyY());

        CCC ccc_param = new CCC(4, 5);
        System.out.println("Object with parameters: x = " + ccc_param.getPropertyX() + " y = " + ccc_param.getPropertyY());
        System.out.println("sum(): " + ccc_param.sum());
        System.out.println("ssub(): " + CCC.ssub(1,2));

        //Task2
        DDD ddd = new DDD();
        System.out.println("\nParameterless object DDD: x = " + ddd.getPropertyX() + " y = " + ddd.getPropertyY());

        DDD ddd_param = new DDD(3, 4);
        System.out.println("Object with parameters: x = " + ddd_param.getPropertyX() + " y = " + ddd_param.getPropertyY());
        System.out.println("sum(): " + ddd_param.sum());
        System.out.println("ssub(): " + ddd_param.calc());
    }
}
