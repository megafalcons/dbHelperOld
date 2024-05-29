package dbhelper;
import java.util.*;
public class checkLoop {
    //private static notification notis = new notification();
    //private ArrayList<String> apiKeys = new ArrayList<String>();
    private String apiKey;
    private isOnline tester;
    //private ArrayList<String> apiKeys = new ArrayList<String>();
    public checkLoop(String apiK){
        apiKey = apiK;
        tester = new isOnline(apiK);
    }

    //public void apiKeySetup(ArrayList<String> apiK){
    //    for(int i = 0; i < apiK.size(); i++){
    //        apiKeys.add(apiK.get(i));
    //    }
    //}

    //public void addApiKey(String key){
    //    if(!apiKeys.contains(key)){
    //        apiKeys.add(key);
    //    }
    //}

    //public void removeApiKey(String key){
    //    apiKeys.remove(key);
    //}
    
    public ArrayList<String> check(ArrayList<String> ids){
        ArrayList<String> result = new ArrayList<String>();
        
        for(int i = 0; i < ids.size(); i++){
            long curTime = System.currentTimeMillis();
            //System.out.println(ids.get(i));
            if(tester.getHypixelStatus(ids.get(i))){
                
                result.add(ids.get(i) + ":" + "true");
                //System.out.println(ids.get(i) + ":" + "true");
            }
            else{
                result.add(ids.get(i) + ":" + "false");
                //System.out.println(ids.get(i) + ":" + "false");

            }
            //System.out.println(i);
            long newTime = curTime + 1000 - System.currentTimeMillis();
            if(newTime < 0){
                newTime = 0;
            }
            try {
                Thread.sleep(newTime); // Sleep for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
