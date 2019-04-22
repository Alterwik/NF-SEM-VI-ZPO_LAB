
public class Main {

    private static final String FILEPATH = "resources/PolEngTest.json";

    public static void main(String[] args) {

    Test t = new Test();
    t.initializeQuestionList(FILEPATH);
    t.askQuestions(5);

    }


}
