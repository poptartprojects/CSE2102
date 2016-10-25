package JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;


public class JavaFXMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		
		GridPane griddy = new GridPane();
		griddy.setAlignment(Pos.CENTER);
		griddy.setHgap(10);
		griddy.setVgap(10);
		griddy.setPadding(new Insets(25, 25, 25, 25));
		
		
		//Adding the TextFields
		TextField ZIPCode = new TextField("ZIP");
		TextField Geo = new TextField("Geographic Location");
		griddy.add(ZIPCode, 0, 0);
		griddy.add(Geo, 1, 0);
		
		Scene input = new Scene(griddy, 400, 300, Color.IVORY);
		primaryStage.setScene(input);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
