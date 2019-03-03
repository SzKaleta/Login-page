package controllers;

import java.io.IOException;
import project_io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegCtrl {

    @FXML
    private PasswordField pas;

    @FXML
    private PasswordField reppas;

    @FXML
    private TextField name;

    @FXML
    private TextField log;

    @FXML
    private Button reg_btn;

    @FXML
    private Label info;

    @FXML
    void reg_fin(ActionEvent event) throws IOException {
    	if(log.getText().trim().isEmpty()||pas.getText().trim().isEmpty()||reppas.getText().trim().isEmpty()||name.getText().trim().isEmpty())
    		info.setText("Brak danych!");
    	else if (pas.getText().equals(reppas.getText()))
    	{
    		User_Login register= new User_Login();
    		if(register.Register(log.getText(), pas.getText(), name.getText()))
    		{
    	        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("main_gui/LogScreen.fxml"));
    	        Scene tableViewScene = new Scene(tableViewParent);
    	        
    	        //This line gets the Stage information
    	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	        
    	        window.setScene(tableViewScene);
    	        window.show();
    		}
    		else    info.setText("Taki u¿ytkownik ju¿ istnieje!");

    	}
    	else info.setText("Niepoprawnioe podane has³o!");

    }

}
