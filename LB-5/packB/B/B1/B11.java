package B.B1;

public class B11 {
    public String word;

    public B11(String word) {
        this.word = word;
    }

    public String getClassNameAndString() {
        return "Class name: " + this.getClass().getName() + " variable value: " + this.word;
    }
}
