
/*

REAL   | SIMULATED
1/25   =    1
1      =    25

          !!! all in MILLIS !!!

*/
public class SimulatedTime {

    private static final long RATIO = 25;

    private long mSimulatedTime;

    public SimulatedTime(int simulatedTime) {
        mSimulatedTime = simulatedTime;
    }

    public SimulatedTime() {
        mSimulatedTime = 0;
    }

    public long getRealTimeInMilis() {
         return (long)(mSimulatedTime / RATIO);
    }

    public long simulatedTimeToReal(long simulated){
        return simulated * RATIO;
    }

    public long realTimeToSimulated(long simulated){
        return simulated / RATIO;
    }

    public long getSimulatedTime() {
        return mSimulatedTime;
    }

    @Override
    public String toString() {
        return (mSimulatedTime/1000)+" sec";
    }
}
