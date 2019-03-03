package main_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main_Gui extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primary_stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LogScreen.fxml"));
        Scene scene = new Scene(root);
        
        primary_stage.setScene(scene);
		primary_stage.setTitle("Pierwsza appka");
		primary_stage.setResizable(false);
		primary_stage.show();
	}

}
