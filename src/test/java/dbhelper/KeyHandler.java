package dbhelper;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener{
    private KeyStatus k;

    public KeyHandler(){
        k = new KeyStatus();
    }

    public KeyStatus getTyped(){
        KeyStatus result = new KeyStatus();
        result.setDeletes(k.getDeletes());
        result.setCmds(k.getCmds());
        result.setTyped(k.getTyped());
        if(k.isTabbed()){
            result.tab();
        }
        if(k.isEntered()){
            result.enter();
        }
        k.setCmds("");
        k.setDeletes(0);
        k.setTyped("");
        k.untab();
        k.processed();
        return result;
    }
    @Override
    public void keyPressed(KeyEvent arg0) {
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("code " + (int)e.getKeyChar());
        if(e.getKeyChar() < 32 && e.getKeyChar() != 8){
            if(e.getKeyChar() == 9){
                System.out.println("yippe");
                k.tab();
            }
            if(e.getKeyChar() == 10){
                k.enter();
            }
            //if(e.getKeyChar() == )
            //k.setCmds(k.getCmds() + (int)e.getKeyChar() + " ");
        }
        if(k.isTabbed() || k.isEntered()){
            return;
        }
        else if(e.getKeyChar() == 8 || e.getKeyChar() == 127){
            if(k.getTyped().length() == 0){
                k.setDeletes(k.getDeletes() + 1);
            }
            else{
                k.setTyped(k.getTyped().substring(0, k.getTyped().length() - 1));
            }
        }
        else{
            k.setTyped(k.getTyped() + e.getKeyChar());
        }
    }
    
}
