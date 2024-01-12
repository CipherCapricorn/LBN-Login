package fetch_user;

// A class for testing User class function
public class Temp {
	
    public static void main(String[] args) {
    	User user = new User(); // Make an instance of User
        try {
        	user = new User("CipherCapricorn"); // Try to find a match registered user in database
        	System.out.println("Old user detected.");
        } catch (Exception e) {
			user.register("CipherCapricorn", "李准恩", "Taiwan", "2004-01-02", "alky930102@gmail.com", "test"); // Put a formatted value and test again
			System.out.println("New user detected.");
        }
        System.out.println(user.email);
    }

}
