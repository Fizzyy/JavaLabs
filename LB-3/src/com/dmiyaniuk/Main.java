package com.dmiyaniuk;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
    	//Task1
	    int[] intArray = new int[10];
	    for (int i = 0; i < intArray.length; i++) {
	        intArray[i] = i;
        }
	    System.out.print("Simple array: ");
	    for(int elem:intArray) {
	        System.out.print(elem + " ");
        }

	    //Task2
		int[][] bigIntArray = new int[5][5];
	    for (int i = 0; i < bigIntArray.length; i++) {
	    	for (int j = 0; j < bigIntArray[i].length; j++) {
	    		bigIntArray[i][j] = i + j;
			}
		}
		System.out.print("\nComplicated array: ");
	    for (int[] arrayElem:bigIntArray) {
	    	System.out.println(" ");
	    	for (int j:arrayElem) {
				System.out.print(j + " ");
			}
		}

	    //Task3
		int a = 10, b = 2;
	    System.out.println("\n\na in binary: " + Integer.toBinaryString(a));
		System.out.println("b in binary: " + Integer.toBinaryString(b));
	    System.out.println("\na >>> b: " + Integer.toBinaryString((a >>> b)));
		System.out.println("a <<= b: " + Integer.toBinaryString((a <<= b)));
		System.out.println("a ^= b: " + Integer.toBinaryString((a ^= b)));
		System.out.println("a & b: " + Integer.toBinaryString((a & b)));
		System.out.println("~a: " + Integer.toBinaryString(~a));

		//Task4
		boolean result = false;
		System.out.println();

		//Task5
		Date date = new Date();
		if (date.getDay() == 3) System.out.println("Today is a wednesday!");
		else System.out.println("Today is not a wednesday");

		int whileInt = 1;
		while (whileInt < 10) {
			System.out.println("whileInt: " + whileInt);
			whileInt++;
		}

		System.out.println();
		int doInt = 5;
		do {
			System.out.println("doInt: " + doInt);
			doInt--;
		} while (doInt > -1);

		int currentHour = date.getHours();
		switch (currentHour) {
			case 12: System.out.println("\nIt is 12!"); break;
			case 13: System.out.println("\nIt is 13!"); break;
			case 0: System.out.println("\nIt is 0!"); break;
		}

		//Task6
		StaticClass.staticInt = 2;
		System.out.println("\nStatic int: " + StaticClass.staticInt);
		System.out.println("Static method: " + StaticClass.getStaticStringMethod());
    }
}
