package project_io;

import java.util.ArrayList;

public class User 
{
	public String Login, Password, Name;
	public ArrayList<Integer> Movies = new ArrayList<Integer>();
	
	public User(String l, String p, String n,ArrayList<Integer> a) {
		
		Login=l;
		Password=p;
		Name=n;
		Movies=a;
	}
}


