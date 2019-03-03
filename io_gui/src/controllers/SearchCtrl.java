package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project_io.*;
import Abstract_classes.*;

public class SearchCtrl {


    @FXML
    private TextField title;

    @FXML
    private TextField director;

    @FXML
    private TextField year;

    @FXML
    private Button sea;

    @FXML
    private ComboBox<String> genre;

    @FXML
    private ListView<String> mobies;

    @FXML
    private Button out;

    @FXML
    void log_out(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("main_gui/LogScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information.toSting
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void search_title(ActionEvent event) {
    	mobies.getItems().clear();
    	User_Searching ser= new User_Searching();
    	
    	String tit;
        if(!title.getText().equals(""))
        {
        	tit = title.getText();
        }
        else tit= null;
    	
    	String dir;
        if(!director.getText().equals(""))
        {
        	dir = director.getText();
        }
        else dir= null;
    	
    	
    	Integer number;
        if(!year.getText().equals(""))
        {
              number = Integer.parseInt(year.getText());
        }
        else number= null;
        String gen;
        if(genre.getValue()!=null&&!genre.getValue().toString().equals("-"))
        {
        	gen = genre.getValue().toString();
        }
        else gen= null;
    	ArrayList <Movie> lista1= ser.Search(tit, dir, number, gen);
    	ArrayList <String> lista2 =new ArrayList<String>();
    	for(Movie m :lista1)
    		lista2.add(m.Title);
    	ObservableList<String> items =FXCollections.observableArrayList (lista2);
    	mobies.setItems(items);
    }
    @FXML
    public void initialize()
    {
    	genre.setItems(FXCollections.observableArrayList(
    		    new String("thiller"),
    		    new String("sci-fi"), 
    		    new String("drama"),
    		    new String("comedy"),
    		    new String("family"),
    		    new String("-")));
    }

}
