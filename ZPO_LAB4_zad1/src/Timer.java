public class Timer {

    private long mTimeMillis = 0;

    private long mStartTimeMillis = 0;

    public void start(){
        mStartTimeMillis = System.currentTimeMillis();
    }

    public void stop(){
        mTimeMillis = System.currentTimeMillis() - mStartTimeMillis;
    }

    public double getTimeSec(){
        return ((double)mTimeMillis) / 1000;
    }
}
