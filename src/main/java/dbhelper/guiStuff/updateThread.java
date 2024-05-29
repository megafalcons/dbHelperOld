package dbhelper.guiStuff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;



class updateThread implements Runnable {
    private homeScreen h;
    private Thread prgmThread;
    private int updateOld;
    public updateThread(homeScreen home){
        h = home;
    }
    public void startProgramThread(){
        prgmThread = new Thread(this);
        prgmThread.start();
    }
    public void run()
    {
        while(prgmThread != null){
            h.updateAuctions();
            try {
                Thread.sleep(15000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

