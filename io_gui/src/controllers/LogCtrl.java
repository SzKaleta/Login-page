package controllers;

import java.io.IOException;
import project_io.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LogCtrl {

    @FXML
    private Button reg;

    @FXML
    private Button log;
    @FXML
    private Label labb;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField logg;

    @FXML
    private ProgressBar barr;
    

    double prog=0;
    @FXML
    void log_next(ActionEvent event) throws IOException {
    	
    	
    	if(logg.getText().trim().isEmpty()||pass.getText().trim().isEmpty())
    		labb.setText("Nie podano danych!");
    	else
    		
    	{
    	    User_Login login = new User_Login();

        	String l=logg.getText();
        	String p=pass.getText();
        	//System.out.println(l+" "+p);
    		if(login.Log_in(l, p))
    		{
	    	Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("main_gui/SearchScreen.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
    		}
    		else
    		{
        		labb.setText("Nieprawid³owe dane!");
        		if(barr.getProgress()<1)
        		{
            		prog=prog+0.25;
        			barr.setProgress(prog);
        		}
        		else
        			Platform.exit();
    		}
    	}


    }

    @FXML
    void reg_next(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("main_gui/RegisterScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();

    }



}
