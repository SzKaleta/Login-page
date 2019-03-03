package Abstract_classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class Profile {
	
	public void ViewProfile() {
		
	}
	
	public void SendMessege(String mess) throws IOException {
		File file = new File("C:\\Users\\kompjuta\\Desktop\\msg.txt");
		FileWriter output = new FileWriter(file, true);
		
		output.write(mess + "\r\n");
		output.close();
	}
}
