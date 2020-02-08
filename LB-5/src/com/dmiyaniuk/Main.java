package com.dmiyaniuk;

//Task2
import A.A1.A2.A3.A4.*;
//Task3
import A.A1.*;
//Task4
import A.A1.A2.*;
//Task5
import B.B1.*;
import B.B1.B2.*;
import B.B1.B2.B3.B4.*;

import B.B1.B2.B3.*;
import A.A1.A2.A3.*;

public class Main {

    public static void main(String[] args) {
        //Task1
        A.A1.A11 a11 = new A.A1.A11(5);
        System.out.println(a11.getClassNameAndValue());
        A.A1.A2.A21 a21 = new A.A1.A2.A21(6);
        System.out.println(a21.getClassNameAndValue());
        A.A1.A2.A22 a22 = new A.A1.A2.A22(7);
        System.out.println(a22.getClassNameAndValue());
        A.A1.A2.A3.A4.A41 a41 = new A.A1.A2.A3.A4.A41(8);
        System.out.println(a41.getClassNameAndValue());
        A.A1.A2.A3.A4.A42 a42 = new A.A1.A2.A3.A4.A42(9);
        System.out.println(a42.getClassNameAndValue());

        //Task2
        A41 a41_2 = new A41(1);
        System.out.println("\n" + a41_2.getClassNameAndValue());
        A41 a42_2 = new A41(2);
        System.out.println(a42_2.getClassNameAndValue());

        //Task3
        A11 a11_2 = new A11(2.5);
        System.out.println("\n" + a11_2.getClassNameAndValue());

        //Task4
        A21 a21_2 = new A21(3.5);
        System.out.println("\n" + a21_2.getClassNameAndValue());
        A22 a22_2 = new A22(4.5);
        System.out.println(a22_2.getClassNameAndValue());

        //Task5
        B11 b11 = new B11("It's b11");
        System.out.println("\n" + b11.getClassNameAndString());
        B21 b21 = new B21("It's b21");
        System.out.println(b21.getClassNameAndString());
        B22 b22 = new B22("It's b22");
        System.out.println(b22.getClassNameAndString());
        B41 b41 = new B41("It's b41");
        System.out.println(b41.getClassNameAndString());
        B42 b42 = new B42("It's b42");
        System.out.println(b42.getClassNameAndString());

        //Task6
        SixthTask sixT = new SixthTask(100);
        System.out.println("\n" + sixT.returnMethodFromPackageA());

        //Task7
        SeventhTask seventhT = new SeventhTask("Word from Main.java");
        System.out.println("\n" + seventhT.getParentMethod());
    }
}
