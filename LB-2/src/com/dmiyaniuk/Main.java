package com.dmiyaniuk;

public class Main {

    public static void main(String[] args) {
        int a1 = 3, b1 = 2;
        var c = Math.pow(a1, 2) - Math.pow(b1, 2);
        System.out.println("a1^2 - a2^2: " + c);

        float a2 = 4, b2 = 3;
        var c2 = Math.pow(a2, 3) - Math.pow(b2, 3);
        System.out.println("a2^3 - b2^3: " + c2);

        double a3 = a2, b3 = b2;
        var c3 = Math.pow(a3, 4) - Math.pow(b3, 4);
        System.out.println("a3^4 - b3^4: " + c3);


        char ch1 = '4', ch2= '2';
        System.out.println("\n'4' + '2': " + (ch1 + ch2));
        System.out.println("'4' - '2': " + (ch1 - ch2));
    }
}
