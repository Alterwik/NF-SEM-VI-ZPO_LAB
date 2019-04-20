//import com.google.gson.annotations.Expose;

public class Question {

    //@Expose
    private int id;

    //@Expose
    private String polishQuestion;

    //@Expose
    private String [] englishAnswers;

    public int getId() {
        return id;
    }

    public String getPolishQuestion() {
        return polishQuestion;
    }

    public String[] getEnglishAnswers() {
        return englishAnswers;
    }
}
