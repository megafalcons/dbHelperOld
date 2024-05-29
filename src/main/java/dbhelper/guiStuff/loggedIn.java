package dbhelper.guiStuff;

import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.CardLayout;

import dbhelper.notification;
import dbhelper.serverRequests;

public class loggedIn extends javax.swing.JFrame implements Runnable {
    private Thread programThread;
    private serverRequests sr;
    private homeScreen h;
    private ApiKeysEditor a;
    private settings se;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private String sound = "boom.wav";
    private boolean isSound = true;
    public void startProgramThread(){
        programThread = new Thread(this);
        programThread.start();
    }
    public void toggleSound(){
        isSound = !isSound;
    }

    public void setSound(String soundName){
        sound = soundName;
    }
    public loggedIn(serverRequests s){
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        sr = s;
        a = new ApiKeysEditor(this, sr);
        h = new homeScreen(this, sr);
        se = new settings(this, sr);

        mainPanel.add(h, "homeScreen");
        mainPanel.add(a, "apiKeysEditor");
        mainPanel.add(se, "settings");
        this.add(mainPanel);
        this.setVisible(true);

        startProgramThread();
    }
    public void switchToApiPage(){
        cardLayout.show(mainPanel, "apiKeysEditor");
    }
    public void switchToSettings(){
        cardLayout.show(mainPanel, "settings");
    }
    public void switchToHomePage(){
        cardLayout.show(mainPanel, "homeScreen");
    }
    @SuppressWarnings("deprecation")
    public void logout(){
        LoginJFrame l = new LoginJFrame();
        programThread.stop();
        l.setVisible(true);
        l.pack();
        l.setLocationRelativeTo(null);
        l.setResizable(false);
        this.dispose();
    }

    public void notifyUsers(){
        notification n = new notification();
        if(isSound){
            n.notify(sound);
        }
        else{
            n.notifying();
        }
    }

    @Override
    public void run() {
        //double drawInterval = 7000000000L;
        //double nextDrawTime = System.nanoTime() + drawInterval;
        updateThread u = new updateThread(h);
        u.startProgramThread();
        while(programThread != null){
            ArrayList<String> keys = sr.getKeys();
            ArrayList<String> list = sr.getList();
            ArrayList<String> result = new ArrayList<String>();
            if(list == null){
                try {
                    Thread.sleep(10000);
                    //System.outprintln("wowie");
                    run();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //System.outprintln(keys.size() + " " + list.size());
            if(keys.size() > 0){
                for(int i = 0; i < keys.size(); i++){
                    ArrayList<String> snippet = new ArrayList<String>();
                    for(int j = 0; j < 60; j++){
                        snippet.add(list.get(i * 60 + j));  
                    }
                    Thread t = new Thread(new ScanThread(keys.get(i), snippet, result));
                    t.run();
                }
            }
            int buh = 0;
            int updateCounter = 0;
            while(result.size() != keys.size() * 60 && buh < 40){
                buh++;
                updateCounter++;
                if(updateCounter == 2){
                    //System.out.println("THIS IS AN UPDATE PELASE HELP");
                    //h.updateAuctions();
                    updateCounter = 0;
                }
                try{
                    Thread.sleep(7000);
                }catch(Exception e){
                    e.printStackTrace();
                    
                }
            }
            h.updateTokens();
            h.updateKeyAmount();
            sr.addList(result);
            //System.outprintln("can this work plz im tired its 1am");
        }
    }
    
}
