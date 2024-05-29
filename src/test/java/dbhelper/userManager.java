package dbhelper;

public class userManager {
    private String username;
    private String password;

    public userManager(){
        username = "";
        password = "";
    }

    public void addToUsername(String addition){
        username += addition;
    }

    public void addToPassword(String addition){
        password += addition;
    }

    public void setUsername(String user){
        username = user;
    }

    public void setPassword(String pass){
        password = pass;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
