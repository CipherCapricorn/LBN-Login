package fetch_user;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Temp {
	
    public static void main(String[] args) {
    	User user = new User();
        try {
        	user = new User("CipherCapricorn");
        	System.out.println("Old user detected.");
        } catch (Exception e) {
			user.register("CipherCapricorn", "李准恩", "Taiwan", "2004-01-02", "alky930102@gmail.com", "test");
			System.out.println("New user detected.");
        }
        System.out.println(user.email);
    }

}
