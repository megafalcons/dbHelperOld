package dbhelper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;   
import org.json.simple.parser.*;

public class serverRequests {
    public static void main(String args[]) {
        serverRequests s = new serverRequests();
        //System.out.println(s.RegisterUser("test2", "test2", "test@test.com"));
        //System.out.println(s.loginUser("testing", "password"));
        //System.out.println(s.getList());
        //System.out.println(s.sucessfulVerify());
    }

    private OkHttpClient client = new OkHttpClient().newBuilder().cookieJar(new SimpleCookieJar()).build();

    
    public Boolean loginUser(String username, String password){
        try{
            RequestBody body = new FormBody.Builder().add("username", username).add("password", password).build();
            Request request = new Request.Builder()
                .url("http://localhost:8080/login")
                //.method("POST", body)
                .post(body)
                .build();
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            if(response.code() == 200){
                return true;
            }
            return false;
            
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    }

    public int RegisterUser(String username, String password, String email){
        try{
            JSONObject obj = new JSONObject();
            obj.put("username", username);
            obj.put("password", password);
            obj.put("email", email);
            MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(obj.toJSONString(), JSON);
            Request request = new Request.Builder()
                .url("http://localhost:8080/register")
                .post(body)
                .build();
            Response response = client.newCall(request).execute();
            return Integer.parseInt(response.body().string());
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Boolean ChangePassword(String newPassword, String oldPassword){
        try{
            JSONObject obj = new JSONObject();
            obj.put("newPassword", newPassword);
            obj.put("oldPassword", oldPassword);
            MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(obj.toJSONString(), JSON);
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/changePass")
                .post(body)
                .build();
            Response response = client.newCall(request).execute();
            return response.body().string().equals("true");
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean addKey(String key){
        try{
            JSONObject obj = new JSONObject();
            obj.put("key", key);
            MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(obj.toJSONString(), JSON);
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/addKeys")
                .post(body)
                .build();
            Response response = client.newCall(request).execute();
            return response.body().string().equals("true");
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean placeBid(String key){
        try{
            JSONObject obj = new JSONObject();
            obj.put("bid", key);
            MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(obj.toJSONString(), JSON);
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/placeBid")
                .post(body)
                .build();
            Response response = client.newCall(request).execute();
            return response.body().string().equals("true");
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> getAuctions(){
        try{
            
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/auctions")
                .get()
                .build();
            Response response = client.newCall(request).execute();
            if(response.code() != 200){
                return null;
            }
            ArrayList<String> result = new ArrayList<String>();
            String str = response.body().string();

            //System.out.println(str + " alkjdsflkajlskdfjlkasfd WHHWHWHWHW");
            JSONParser p = new JSONParser();
            JSONObject obj = (JSONObject) p.parse(str);

            JSONArray keys = (JSONArray)obj.get("auctions");

            for(int i = 0; i < keys.size(); i++){
                result.add((String)keys.get(i));
            }
            return result;
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public LinkedList<String> getOldAuctions(){
        try{
            
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/oldAuctions")
                .get()
                .build();
            Response response = client.newCall(request).execute();
            if(response.code() != 200){
                return null;
            }
            LinkedList<String> result = new LinkedList<String>();
            String str = response.body().string();

            //System.out.println(str + " alkjdsflkajlskdfjlkasfd WHHWHWHWHW");
            JSONParser p = new JSONParser();
            JSONObject obj = (JSONObject) p.parse(str);

            JSONArray keys = (JSONArray)obj.get("auctions");

            for(int i = 0; i < keys.size(); i++){
                result.add((String)keys.get(i));
            }
            return result;
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public LinkedList<String> getPurchases(){
        try{
            
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/purchases")
                .get()
                .build();
            Response response = client.newCall(request).execute();
            if(response.code() != 200){
                return null;
            }
            LinkedList<String> result = new LinkedList<String>();
            String str = response.body().string();

            //System.out.println(str + " alkjdsflkajlskdfjlkasfd WHHWHWHWHW");
            JSONParser p = new JSONParser();
            JSONObject obj = (JSONObject) p.parse(str);

            JSONArray keys = (JSONArray)obj.get("purchases");

            for(int i = 0; i < keys.size(); i++){
                result.add((String)keys.get(i));
            }
            return result;
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public long getTokens(){
        try{
            
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/tokenCount")
                .get()
                .build();
            Response response = client.newCall(request).execute();
            if(response.code() != 200){
                return -1;
            }
            long result;
            String str = response.body().string();

            //System.out.println(str + " alkjdsflkajlskdfjlkasfd WHHWHWHWHW");
            JSONParser p = new JSONParser();
            JSONObject obj = (JSONObject) p.parse(str);
            result = (long)obj.get("tokens");
            return result;
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<String> getKeys(){
        try{
            
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/sendKeys")
                .get()
                .build();
            Response response = client.newCall(request).execute();
            if(response.code() != 200){
                return null;
            }
            ArrayList<String> result = new ArrayList<String>();
            String str = response.body().string();

            //System.out.println(str + " alkjdsflkajlskdfjlkasfd WHHWHWHWHW");
            JSONParser p = new JSONParser();
            JSONObject obj = (JSONObject) p.parse(str);

            JSONArray keys = (JSONArray)obj.get("keys");

            for(int i = 0; i < keys.size(); i++){
                result.add((String)keys.get(i));
            }
            return result;
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getList(){
        try{
            
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/recieveList")
                .get()
                .build();
            Response response = client.newCall(request).execute();
            if(response.code() != 200){
                return null;
            }
            ArrayList<String> result = new ArrayList<String>();
            String str = response.body().string();

            //System.out.println(str + " alkjdsflkajlskdfjlkasfd WHHWHWHWHW");
            JSONParser p = new JSONParser();
            JSONObject obj = (JSONObject) p.parse(str);

            JSONArray keys = (JSONArray)obj.get("ids");

            for(int i = 0; i < keys.size(); i++){
                result.add((String)keys.get(i));
            }
            return result;
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean addList(ArrayList<String> result){
        try{
            JSONObject obj = new JSONObject();
            JSONArray arr = new JSONArray();
            for(int i = 0; i < result.size(); i++){
                arr.add(result.get(i));
            }
            obj.put("result", arr);
            MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(obj.toJSONString(), JSON);
            Request request = new Request.Builder()
                .url("http://localhost:8080/user/addList")
                .post(body)
                .build();
            Response response = client.newCall(request).execute();
            //System.out.println("wow" + response.body().string() + " " + response.code());
            return response.body().string().equals("true");
            //System.out.println("wow" + response.body().string() + " " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
