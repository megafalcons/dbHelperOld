package dbhelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

//import loginDisplay;
import dbhelper.serverRequests;

public class windowPanel{} //extends JPanel implements Runnable{
    /*private int screenWidth = 856;
    private int screenHeight = 482;
    private int prgmState = 0;
    private String thing = "";
    private int field = -1;
    private boolean changed = false;
    KeyHandler keys = new KeyHandler();
    userManager user = new userManager();
    serverRequests sRequests = new serverRequests();
    loginDisplay l = new loginDisplay();
    Thread programThread;

    public windowPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keys);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void startProgramThread(){
        programThread = new Thread(this);
        programThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/60;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(programThread != null){

            //System.out.println("yippe");
            update();
            if(changed){
                repaint();
            }
            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void update(){
        changed = false;
        if(prgmState == 0){
            KeyStatus k = keys.getTyped();
            //System.out.println(field + " username: " + user.getUsername() + " password: " + user.getPassword());
            if(field == 0){
                String username = user.getUsername();
                if(username.length() - k.getDeletes() >= 0){
                    user.setUsername(username.substring(0, username.length() - k.getDeletes()));
                    changed = true;
                }
                if(k.getTyped().length() >= 1){
                    changed = true;
                }
                user.addToUsername(k.getTyped());
                
            }
            else if(field == 1){
                String password = user.getPassword();
                if(password.length() - k.getDeletes() >= 0){
                    user.setPassword(password.substring(0, password.length() - k.getDeletes()));
                    changed = true;
                }
                if(k.getTyped().length() >= 1){
                    changed = true;

                }
                user.addToPassword(k.getTyped());
            }
            
            if(k.isTabbed()){
                field = (field + 1) % 2;
                System.out.println(field);
                changed = true;
                System.out.println("field: " + field);
            }

            if(k.isEntered()){
                System.out.println("wow");
                changed = true;
                if(sRequests.loginUser(user.getUsername(), user.getPassword())){
                    prgmState = 1;
                    System.out.println(user.getUsername() + " " + user.getPassword() + " success!");
                }
                else{
                    System.out.println(user.getUsername() + " " + user.getPassword() + " fail!");
                }
            }
        }
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(prgmState == 0){
            l.setVars(this.getWidth(), this.getHeight(), user.getUsername(), user.getPassword(), false);
            l.draw(g2);
        }

    }
}*/