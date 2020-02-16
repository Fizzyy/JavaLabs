package com.dmiyaniuk;

import exceptions.*;

public class Main {

    public static void main(String[] args) {
        Integer nullNum = null;
        int zeroNum = 0, negNum = -5;
        try {
            AAA a1 = new AAA(nullNum);
            AAA a2 = new AAA(10);
            a2.methode(zeroNum);
            a2.methode(negNum);
        } catch (ExceptionAAA1 error) {
            System.out.println("ExceptionAAA1 has been thrown");
        } catch (ExceptionAAA2 error) {
            System.out.println("ExceptionAAA2 has been thrown");
        } catch (ExceptionAAA3 error) {
            System.out.println("ExceptionAAA3 has been thrown");
        }
        finally {
            System.out.println("Finally called");
        }
    }
}
