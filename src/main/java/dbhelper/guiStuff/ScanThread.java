package dbhelper.guiStuff;

import java.util.ArrayList;

import dbhelper.checkLoop;

class ScanThread extends Thread {
    private String apiKey;
    private ArrayList<String> l;
    checkLoop loop;
    private ArrayList<String> result;
    public ScanThread(String apiK, ArrayList<String> list, ArrayList<String> r){
        apiKey = apiK;
        l = list;
        result = r;
        loop = new checkLoop(apiKey);
    }
    public void run()
    {
        try {
            ArrayList<String> temp = loop.check(l);
            //System.outprintln("wtf");
            for(int i = 0; i < temp.size(); i++){
                result.add(temp.get(i));
            }
        }
        catch (Exception e) {
            // Throwing an exception
            e.printStackTrace();
        }
    }
}
