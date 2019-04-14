import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class CyclistList {

    //Members ------------------------------------------------------------

    private ArrayList<Cyclist> mCyclists = new ArrayList<>();

    //Methods ------------------------------------------------------------

    public CyclistList(String url, int numberOfCyclistsToChoose) {
        chooseCyclists(getListFromUrl(url), numberOfCyclistsToChoose);
    }

    public Cyclist getCyclistByIndex(int index){
        return mCyclists.get(index);
    }

    public ArrayList<Cyclist> getCyclists() {
        return mCyclists;
    }

    public int size(){
        return mCyclists.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CyclistList{ ");
        for (int i = 0; i < mCyclists.size(); i++) {
            sb.append(mCyclists.get(i).toString());
            if(i<mCyclists.size()-1){sb.append(", ");}
        }
        sb.append(" }");
        return sb.toString();
    }

    //Private methods -----------------------------------------------------

    private ArrayList<String> getListFromUrl(String url){
        URL listFromSite;
        ArrayList<String> namesFromUrl = new ArrayList<>();
        try {
            listFromSite = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(listFromSite.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                namesFromUrl.add(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return namesFromUrl;
    }

    private String getRandomElement(ArrayList <String> list){

        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    private void chooseCyclists(ArrayList<String> listFromUrl, int numberOfCyclistsToChoose){
        while(numberOfCyclistsToChoose > 0){
            String randomElement = getRandomElement(listFromUrl);
            listFromUrl.remove(randomElement);
            Cyclist cyclist = new Cyclist(randomElement, numberOfCyclistsToChoose);
            mCyclists.add(cyclist);
            numberOfCyclistsToChoose--;
        }
    }
}


