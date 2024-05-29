

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class loginDisplay {
    private int width;
    private int height;
    private String username;
    private String password;
    private Boolean error;
    public loginDisplay(){
        width = 0;
        height = 0;
    }
    public void setVars(int w, int h, String u, String p, Boolean e){
        width = w; height = h; username = u; password = p; error = e;
    }

    public void draw(Graphics2D g2){
        System.out.println(width + " " + height);
        g2.setColor(Color.white);
        g2.setFont(new Font("TimesRoman", Font.PLAIN, width/64));
        //g2.fillRect(width/8 * 3, height/ 2, width/4, height/32*3);
        //g2.fillRect(width/8 * 3, height/16 * 11, width/4, height/32*3);
        g2.drawString("username", width/8 * 3, height / 2 - height / 128);
        g2.drawString("password", width/8 * 3, height/16 * 11 - height / 128);
        g2.setColor(Color.black);
        
        //g2.drawRect(width/8 * 3, height/ 2, width/4, height/32*3);
        //g2.drawRect(width/8 * 3, height/16 * 11, width/4, height/32*3);
        //g2.drawString(username , width/8 * 3 + width/ 64, height / 2 + height / 16);
        //g2.drawString(password, width/8 * 3 + width / 64, height/16 * 11 + height / 16);
        g2.dispose();
    }
}
