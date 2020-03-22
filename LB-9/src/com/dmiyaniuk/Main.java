package com.dmiyaniuk;

public class Main {

    public static void main(String[] args) {
    	//Task3
	    String str1 = "This is the first string!";
	    String str2 = "This is the second string!";
	    String str3 = "This is the third string!";
	    String str43 = "This is the third string!";

	    System.out.println("Lenghts of each string: str1 = " + str1.length() + " str2 = " + str2.length() + " str3 = " + str3.length());
	    System.out.println("Concatenation of str1 and str2: " + str1.concat(str2));
	    System.out.println("Replacing symbols in str1: " + str1.replace('i', '$'));
	    System.out.println("Substring symbols in str3 from 0 to 7: " + str3.substring(0, 7));
	    System.out.println("Str2 in upper case: " + str2.toUpperCase());
	    System.out.println("Str1 repeats 3 times: " + str3.repeat(3));
	    System.out.println("Is Str2 empty: " + str2.isEmpty());
	    System.out.println("Does Str1 contains str: " + str1.contains("str"));
	    System.out.println("Do strings str1 and str2 equal: " + (str1.toLowerCase().equalsIgnoreCase(str2)));
	    System.out.println("Do strings str3 and str43 equal: " + (str3.equalsIgnoreCase(str43.toUpperCase())));

	    System.out.println();
	    String str4 = "hello world";
	    for (int i = 0; i < str4.length(); i++) {
	    	System.out.println("Index: " + i + " char: " + str4.charAt(i));
		}

		StringBuffer stringBuffer = new StringBuffer(50);
	    System.out.println("\nAppending new string in stringBuffer: " + stringBuffer.append("I am string buffer"));
	    System.out.println("stringBuffer capacity: " + stringBuffer.capacity());
	    System.out.println("stringBuffer length: " + stringBuffer.length());
	    System.out.println("Insert new string: " + stringBuffer.insert(stringBuffer.length(), " and I am cool"));
		stringBuffer.ensureCapacity(100);
	    System.out.println("New stringBuffer capacity: " + stringBuffer.capacity());
	    System.out.println("Reversing stringBuffer: " + stringBuffer.reverse());

	    //Task4
	    Float floatt = 1.5f;
	    System.out.println("\nIs floatt NaN: " + floatt.isNaN());
	    System.out.println("Int floatt: " + floatt.intValue());

		Double extDouble = 9.3;
		System.out.println("\nIs NaN: " + extDouble.isNaN());
		System.out.println("To int:  " + extDouble.intValue());
		System.out.println("Is infinite: " + extDouble.isInfinite());

		Boolean extBoolean = true;
		System.out.println("\nBoolean value: " + extBoolean.booleanValue());
		System.out.println("ToString: " + extBoolean.toString());

		Character extChar = 'a';
		System.out.println("Char value: " + extChar.charValue());
		System.out.println("ToString: " + extChar.toString());

	    //Task5
        System.out.println("\n---Enums---");
        for (var state:States.values()) {
            System.out.println("Number: " + state.ordinal() + " value: " + state);
        }
        States state = States.ARKANSAS;
        System.out.println("Selected state: " + state);

        ExtendedStates eStates = ExtendedStates.NORTH_DAKOTA;
        System.out.println("\nValue of ExtendedStates: " + eStates.getStateValue());
        eStates = ExtendedStates.VIRGINIA;
		System.out.println("New value of ExtendedStates: " + eStates.getStateValue());
	}
}
