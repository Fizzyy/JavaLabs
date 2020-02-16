package exceptions;

public class ExceptionAAA1 extends Exception {
    public ExceptionAAA1() {
        this.printStackTrace();
        System.out.println("Error message: " + this.getMessage());
        System.out.println("toString: " + this.toString());
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
