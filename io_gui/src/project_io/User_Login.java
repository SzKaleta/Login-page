package project_io;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Abstract_classes.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class User_Login extends Login {
	
	private User CurrentUser;
	private static  ArrayList<User> ListofUsers = new ArrayList<User>();

	public boolean Log_in(String login, String pass) {
		
		boolean logged = false;
		CurrentLog = login;
		CurrentPass = pass;

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:\\Users\\User\\Desktop\\test.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray tmpList = (JSONArray) obj;
            // System.out.println(employeeList);

            tmpList.forEach( usr -> parseUser( (JSONObject) usr ) );

        } catch (Exception e) {
			e.printStackTrace();
		}
        
        for (User user : ListofUsers) {
        	if(user.Login.equals(login) && user.Password.equals(pass)) {
        		CurrentUser = user;
        		logged = true;
        		break;
        	}
        }
        
        return logged;
	}
	
	public boolean Register (String l, String p, String n) {
		
        JSONParser jsonParser = new JSONParser();
        JSONArray tmpList =new JSONArray();
        boolean registered=false;
        try (FileReader reader = new FileReader("C:\\Users\\User\\Desktop\\test.json")) {
            Object obj = jsonParser.parse(reader);
 
            tmpList = (JSONArray) obj;
        } 
        catch (Exception e) {
			e.printStackTrace();
		}
        
        JSONObject newUser = new JSONObject();
        JSONObject userObject = new JSONObject();
        JSONArray userList = new JSONArray();
        
        newUser.put("Login", l);
        newUser.put("Password", p);
        newUser.put("Name", n);
        newUser.put("Movies", userList);
        
        userObject.put("User", newUser);
        
        if(!tmpList.contains(userObject))
        {
            tmpList.add(userObject);
            
            try (FileWriter file = new FileWriter("C:\\Users\\User\\Desktop\\test.json")) {
                file.write(tmpList.toJSONString());
                file.flush();
                registered=true;
            } 
            catch (IOException e) {
                e.printStackTrace();
                
            }   
            
        }

        return registered;

	}
	
	public boolean Return() {	
		
		return true;
	}
	
	private static void parseUser(JSONObject user) {

	    JSONObject userObject = (JSONObject) user.get("User");
	    String log = (String) userObject.get("Login");
	    String pass = (String) userObject.get("Password"); 
	    String name = (String) userObject.get("Name");
	    
		ArrayList<Integer> Movies = ( ArrayList<Integer>) userObject.get("Movies");
		User temp = new User(log, pass, name, Movies);	
		ListofUsers.add(temp);
	}
}
