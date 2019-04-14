import java.util.logging.Logger;

public class LeadList {

    private Cyclist mfirst = new Cyclist();
    private Cyclist mSecond = new Cyclist();
    private Cyclist mThird = new Cyclist();

    private static LeadList mLeadList = new LeadList( );

    private LeadList(){}

    public static LeadList getInstance( ) {
        return mLeadList;
    }

    public synchronized void updateLeadList(Cyclist cyclist){
        if(cyclist.getTime() < mThird.getTime() &&
                cyclist.getTime() < mSecond.getTime() &&
                cyclist.getTime() < mfirst.getTime() ){
            Cyclist tmp = mfirst;
            mfirst = cyclist;
            updateLeadList(tmp);
        }
        else if(cyclist.getTime() < mThird.getTime() &&
                cyclist.getTime() < mSecond.getTime() &&
                cyclist.getTime() > mfirst.getTime() ){
            Cyclist tmp = mSecond;
            mSecond = cyclist;
            updateLeadList(tmp);
        }
        else if(cyclist.getTime() < mThird.getTime() &&
                cyclist.getTime() > mSecond.getTime() &&
                cyclist.getTime() > mfirst.getTime() ){
            //Cyclist tmp = mThird;
            mThird = cyclist;
            //updateLeadList(tmp);
        }
        //printLeadlist();
    }

    public void printLeadlist(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("-----------------------PODIUM-----------------------\n");
        sb.append("                  1: " + mfirst+"\n");
        sb.append("2: " + mSecond+"\n");
        sb.append("                                     3: " + mThird+"\n");
        sb.append("----------------------------------------------------");
        sb.append("\n");
        Logger.getLogger(Main.class.getName()).fine(sb.toString());
        System.out.println(sb);


    }
}
