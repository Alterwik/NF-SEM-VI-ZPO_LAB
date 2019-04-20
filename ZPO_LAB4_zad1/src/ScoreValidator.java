import org.apache.commons.text.similarity.LevenshteinDistance;

public class ScoreValidator {

    public double score(String givenAnswer, String correctAnswer){
        givenAnswer = givenAnswer.toLowerCase();
        correctAnswer = correctAnswer.toLowerCase();
        int levenshteinDistance = LevenshteinDistance.getDefaultInstance().apply(
                        givenAnswer, correctAnswer);
//        System.out.println("given: " + givenAnswer);
//        System.out.println("correct: " + correctAnswer);
//        System.out.println("Levenshtein distance: " + levenshteinDistance);
        if(levenshteinDistance == 1){
            return 0.5;
        }else if(levenshteinDistance == 0){
            return 1;
        }else{
            return 0;
        }
    }
}
