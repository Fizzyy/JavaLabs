package B.B1.B2;

public class B21 {
    public String word;

    public B21(String word) {
        this.word = word;
    }

    public String getClassNameAndString() {
        return "Class name: " + this.getClass().getName() + " variable value: " + this.word;
    }
}
