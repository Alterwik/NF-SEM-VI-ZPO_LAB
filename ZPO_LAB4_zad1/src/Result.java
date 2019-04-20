import com.google.gson.annotations.Expose;

public class Result {

    @Expose
    String question;

    @Expose
    String answer;

    public Result(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
