package dbhelper;

public class KeyStatus {
    private String typed = "";
    private String cmds ="";
    private int deletes = 0; 
    private boolean tabbed = false;
    private boolean entered = false;
    public String getTyped(){
        return typed;
    }
    public String getCmds(){
        return cmds;
    }
    public int getDeletes(){
        return deletes;
    }
    public void setTyped(String newTyped){
        typed = newTyped;
    }
    public void setCmds(String newCmds){
        cmds = newCmds;
    }
    public void setDeletes(int newDeletes){
        deletes = newDeletes;
    }

    public void tab(){
        tabbed = true;
    }
    public void untab(){
        tabbed = false;
    }
    public boolean isTabbed(){
        return tabbed;
    }

    public void enter(){
        entered = true;
    }
    public void processed(){
        entered = false;
    }
    public boolean isEntered(){
        return entered;
    }

}
