package B.B1.B2.B3;

import A.A1.A11;

public class SixthTask {
    private A11 a11;

    public SixthTask(double number) {
        a11 = new A11(number);
    }

    public String returnMethodFromPackageA() {
        return "Call from class " + this.getClass().getSimpleName() + ": " + a11.getClassNameAndValue();
    }
}
