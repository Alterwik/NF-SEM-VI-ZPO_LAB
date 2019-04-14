import static java.lang.Thread.sleep;

public class Race {

    private static final int MILLISECONDS_BETWEEN_STARTS = 60 * 1000;
    private static CyclistList mCyclistList;
    //private LeadList mLeadList;

    public Race(CyclistList cyclistList) {
        mCyclistList = cyclistList;
    }


    public void start() {
        Thread threads[] = new Thread[mCyclistList.size()];

        for (int i = 0; i < mCyclistList.size(); i++) {
            threads[i] = new Thread(mCyclistList.getCyclistByIndex(i));
        }
        for (int i = 0; i < mCyclistList.size(); i++) {
            threads[i].start();
            try {
                sleep(new SimulatedTime().realTimeToSimulated(MILLISECONDS_BETWEEN_STARTS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
