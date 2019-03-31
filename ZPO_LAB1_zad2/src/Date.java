public class Date {
    int mYear;
    int mMonth;
    int mDay;

    public Date(String date) {
        setYearAndMonth(date.substring(0, 4));
        setDay(date.substring(4));
    }

    private void setYearAndMonth(String substring) {
        int year;
        int centuryChecker = Integer.parseInt(substring.substring(2));
        int yearEnd = Integer.parseInt(substring.substring(0, 2));
        if (centuryChecker >= 1 && centuryChecker <= 12 ){
            year = 1900;
            mMonth = centuryChecker;
        }else if (centuryChecker >= 21 && centuryChecker <= 32 ){
            year = 2000;
            mMonth = centuryChecker - 20;
        }else if (centuryChecker >= 41 && centuryChecker <= 52 ){
            year = 2100;
            mMonth = centuryChecker - 40;
        }else if (centuryChecker >= 61 && centuryChecker <= 72 ){
            year = 2200;
            mMonth = centuryChecker - 60;
        }else if (centuryChecker >= 81 && centuryChecker <= 92 ){
            year = 1800;
            mMonth = centuryChecker - 80;
        }else{
            year = 9999;
            System.err.println("Wrong year in PESEL");
        }
        mYear = year + yearEnd;
    }

    public String getBirthDayDate(){
        return mDay+"-"+mMonth+"-"+mYear;
    }

    private void setDay(String substring) {
        int day = Integer.parseInt(substring);
        this.mDay = day;
    }




}
