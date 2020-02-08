package A.A1.A2.A3;

import B.B1.B11;

public class SeventhTask extends B11 {
    public SeventhTask(String constructorWord) {
        super(constructorWord);
    }

    public String getParentMethod() {
        return "Call from class " + this.getClass().getSimpleName() + ": " + super.getClassNameAndString();
    };
}
