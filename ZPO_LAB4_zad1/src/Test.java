import java.util.Scanner;

public class Test {

    private QuestionList mQuestionList;
    private double mPoints;
    private ResultSaver mResultSaver;

    public void initializeQuestionList(String FILEPATH){
        mQuestionList = new QuestionList(FILEPATH);
        mPoints = 0;
        mResultSaver = new ResultSaver();
    }

    public void askQuestions(int numberOfQuestions){
        Timer timer = new Timer();
        timer.start();
        while(numberOfQuestions > 0){
            Question q = mQuestionList.drawQuestionWithoutRepeat();
            askQuestion(q);
            verifyQuestionAnswer(q);
            numberOfQuestions--;
        }
        timer.stop();
        System.out.println("Twój czas: " + timer.getTimeSec() + "s");
        mResultSaver.saveResult();
    }

    private void askQuestion(Question question){
        System.out.println("Wpisz angielskie tłumaczenie słowa: " + question.getPolishQuestion());
    }

    private void verifyQuestionAnswer(Question question){
        String answerFromUser = new Scanner(System.in).nextLine();
        mResultSaver.addResult(question.getPolishQuestion(), answerFromUser);
        scorePoints(answerFromUser, question.getEnglishAnswers());
        System.out.println("Zebranych punktów: " + mPoints);
    }

    private void scorePoints(String answer, String[]correctAnswers){
        for (int i = 0; i < correctAnswers.length; i++) {
                mPoints += new ScoreValidator().score(answer,correctAnswers[i]);
        }
    }
}
