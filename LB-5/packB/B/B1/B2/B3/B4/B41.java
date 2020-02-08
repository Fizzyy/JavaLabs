package B.B1.B2.B3.B4;

public class B41 {
    public String word;

    public B41(String word) {
        this.word = word;
    }

    public String getClassNameAndString() {
        return "Class name: " + this.getClass().getName() + " variable value: " + this.word;
    }
}
