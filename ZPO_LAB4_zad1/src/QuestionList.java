import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

public class QuestionList {

    private ArrayList<Question> mQuestionList;

    public QuestionList(final String FILEPATH) {
        try {
            getQuestionListFromJson(FILEPATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Question selectQuestionById(int id){
        for (int i = 0; i < mQuestionList.size(); i++) {
            if (mQuestionList.get(i).getId() == id){
                return mQuestionList.get(i);
            }
        }
        return null;
    }

    public Question drawQuestionWithoutRepeat(){
        Question chosenQuestion = mQuestionList.get(new Random().nextInt(mQuestionList.size()));
        mQuestionList.remove(chosenQuestion);
        return chosenQuestion;
    }

    public void printAllQuestions(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mQuestionList.size() ; i++) {
            sb.append(mQuestionList.get(i).getId());
            sb.append("\n--question--\n");
            sb.append(mQuestionList.get(i).getPolishQuestion());
            sb.append("\n---answer---\n");
            for (int j = 0; j < mQuestionList.get(i).getEnglishAnswers().length; j++) {
                sb.append(mQuestionList.get(i).getEnglishAnswers()[j]);
                sb.append("\n");
            }
            sb.append("----------------------------\n");
        }
        System.out.println(sb);
    }

    private void getQuestionListFromJson(final String FILEPATH) throws IOException {
        FileReader fileReader = new FileReader(FILEPATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String fileTxt = new String();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            fileTxt = fileTxt + line;
        }
        //System.out.println(fileTxt);
        Type listType = new TypeToken<ArrayList<Question>>(){}.getType();
        mQuestionList = new Gson().fromJson(fileTxt, listType);
        //this.printAllQuestions();
        bufferedReader.close();
    }
}
