package fetch_user;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class User {
	
	public String userName;
	public String realName;
	public String country;
	public String age;
	public String email;
	public String password;
	public String filePath;
	
	// Default constructor
	public User() {
		this.userName = "";
		this.realName = "";
		this.country = "";
		this.age = "";
		this.email = "";
		this.password = "";
		this.filePath = "database/user/";
	}
	
	public User(String userName) throws Exception {
		this.filePath = "database/user/" + userName + ".json";
		
		// parsing file "JSONExample.json"
		Object ob = new JSONParser().parse(new FileReader(filePath));
		
		// typecasting ob to JSONObject
		JSONObject js = (JSONObject) ob;

		this.userName = userName;
		this.realName = (String) js.get("realName");
		this.country = (String) js.get("country");
		this.age = (String) js.get("age");
		this.email = (String) js.get("email");
		this.password = (String) js.get("password");
	}

	@SuppressWarnings("unchecked")
	public void register(String userName, String realName, String country, 
			String age, String email, String password) {
		// Creating a JSONObject object
		JSONObject js = new JSONObject();
		
		//Inserting key-value pairs into the json object
		js.put("userName", userName);
		js.put("realName", realName);
		js.put("country", country);
		js.put("age", age);
		js.put("email", email);
		js.put("password", password);
		try {
			 new File(filePath).mkdirs();
	         FileWriter file = new FileWriter(filePath + userName + ".json");
	         file.write(js.toJSONString());
	         file.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	
	public void changePassword(String userName, String password) {
		
	}
}