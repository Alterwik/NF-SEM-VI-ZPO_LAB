import java.util.Vector;

public class Pesel{
    private String mPesel;
    private Date mBirthDate;
    private String mSerialNumber;
    private Gender mGender;

    public Pesel(String pesel) {
        try {
            if(pesel.length()!=11) {
                throw new IncorrectPeselException("Given number is not a PESEL - Wrong size");
            }else if(isSerialNumberWrong(pesel)){
                throw new IncorrectPeselException("Given number is not a PESEL - Wrong serial number");
            }else{
                initializeMembers(pesel);
            }
        }catch (IncorrectPeselException e){
            //e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    private boolean isSerialNumberWrong(String pesel) {
        String checkSumValues = "13791379131";
        int checkSum = 0;
        for (int i = 0; i < pesel.length(); ++i){
            checkSum += Character.getNumericValue(pesel.charAt(i)) *
                    Character.getNumericValue(checkSumValues.charAt(i));
            //System.out.println(checkSumValues.charAt(i)+" * "+pesel.charAt(i));
        }
        //System.out.println("modulo 10 z sumy kontrolnej: "+(checkSum %10));
        if(checkSum % 10 == 0){
            return false;
        }else{
            return true;
        }
    }

    private void initializeMembers(String pesel) {
        mPesel = pesel;
        mBirthDate = new Date(pesel.substring(0, 6));
        mSerialNumber = pesel.substring(6, 10);
        //System.out.println(pesel.charAt(9)); //gender
        if((Character.getNumericValue(pesel.charAt(10)) % 2) == 0){
            mGender = Gender.FEMALE;
        }else{
            mGender = Gender.MALE;
        }
    }

    private void print(Object object){
        System.out.println(object);
    }

    public void printBirthDateAndGender(){
        print("Birthday date : " + mBirthDate.getBirthDayDate());
        print("Gender        : " + mGender);
    }

    public String getPesel() {
        return mPesel;
    }

    public String getBirthDate() {
        return mBirthDate.getBirthDayDate();
    }

    public String getSerialNumber() {
        return mSerialNumber;
    }

    public Gender getGender() {
        return mGender;
    }
}
