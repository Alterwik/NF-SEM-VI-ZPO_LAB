import java.util.Random;
import java.util.logging.Logger;

public class Cyclist implements Runnable{

    private static final int NEVER_EXCEED_RACE_TIME_VALUE = 3000 * 1000;

    //Members ------------------------------------------------------------

    private String mName;
    private SimulatedTime mTime;
    private int mNumber;

    //Methods ------------------------------------------------------------

    public Cyclist(){
        mName = "Jeszcze nie dotarł";
        mNumber = 0;
        mTime = new SimulatedTime(NEVER_EXCEED_RACE_TIME_VALUE);
    }

    public Cyclist(String name, int numberOfCyclist){
        mName = name;
        mNumber = numberOfCyclist;
        setTimeRand();

    }

    @Override
    public void run() {
        Logger.getLogger(Main.class.getName()).fine("Startuje kolarz nr: "+mNumber+" "+ mName);
        System.out.println("Startuje kolarz nr: "+mNumber+" "+ mName);
        try {
            Thread.sleep(mTime.getRealTimeInMilis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.getLogger(Main.class.getName()).fine("Kończy kolarz nr: "+mNumber+" "+mName+" z czasem: "+mTime );
        System.out.println("Kończy kolarz nr: "+mNumber+" "+mName+" z czasem: "+mTime );
        LeadList.getInstance().updateLeadList(this);
        LeadList.getInstance().printLeadlist();
    }

    public String getmName() {
        return mName;
    }

    @Override
    public String toString() {
        return mName;
    }

    public String toStringWithTime() {
        return "| "+mName+" Czas:"+mTime.getSimulatedTime()+" |";
    }

    public void setTimeRand() {
        this.mTime = new SimulatedTime((new Random().nextInt(120) + 250) * 1000);
    }

    public long getTime() {
        return mTime.getSimulatedTime();
    }

    //Private methods -----------------------------------------------------
}
