package project_io;
import java.io.IOException;
import Abstract_classes.*;

public class User_session extends Session {
	static User_Login log= new User_Login();
	static User_Searching ser = new User_Searching();
	public static void main(String[] args) {
		log= new User_Login();
		LoadMenu();
	}


	public static void LoadMenu() 
	{
		
		System.out.println("Main menu");
		Login("Szymonn", "999", "Kaleta");
		ser.Search("retert", null, null, null);
	}
	public static void Login(String l, String p, String n)
{
		
		System.out.println("1. Login");
		System.out.println("2. Register");
		if (n!=null)
		{
			System.out.println("Enter login");
			System.out.println("Enter username");
			System.out.println("Enter password");
			System.out.println("Repeat password");
				if(log.Register(l,p,n))
					System.out.println("User has been registered");
				else 
					System.out.println("User is already in database");

		}
		
		
		System.out.println("Enter login");
		System.out.println("Enter password");
		if(log.Log_in(l, p)) 
			System.out.println("User logged");
		else
		{
						System.out.println("User not logged");
						System.exit(0);
		}
}
}

