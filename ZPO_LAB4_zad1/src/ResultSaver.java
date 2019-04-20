import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class ResultSaver {

    ArrayList<Result> mResult;

    public ResultSaver() {
        this.mResult = new ArrayList<>();
    }

    public void addResult(String question, String answer){
        mResult.add(new Result(question, answer));
        //printResult();
    }

    public void saveResult(){
        System.out.println("Podaj swoje imię i nazwisko:");
        String username = new Scanner(System.in).nextLine();
        createFile(username);
    }

    public void printResult(){
        System.out.println("Results:");
        System.out.println("size:"+ mResult.size());
        for (int i = 0; i < mResult.size(); i++) {
            System.out.println(mResult.get(i).answer);
            System.out.println(mResult.get(i).question);
            System.out.println("----------------------");
        }
    }

    private void createFile(String username){
        username = username.replaceAll("\\s+","_");
        String filename = username+".json";
        File file = new File(filename);
        try {
            if(file.createNewFile()){
                System.out.println(username+".json Stworzony w katalogu projektu");
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Type type = new TypeToken<ArrayList<Result>>() {}.getType();
                String json = gson.toJson(this.mResult, type);
                //System.out.println(json);
                //printResult();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter.write(json);

                bufferedWriter.close();
            }else System.out.println("File "+username+".json Już istnieje w katalogu projektu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
