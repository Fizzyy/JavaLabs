package B.B1.B2;

public class B22 {
    public String word;

    public B22(String word) {
        this.word = word;
    }

    public String getClassNameAndString() {
        return "Class name: " + this.getClass().getName() + " variable value: " + this.word;
    }
}
