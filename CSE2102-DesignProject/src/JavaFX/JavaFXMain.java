package JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

		//Defining the input screen
		GridPane griddy = new GridPane();
		griddy.setAlignment(Pos.TOP_CENTER);
		griddy.setHgap(10);
		griddy.setVgap(10);
		griddy.setPadding(new Insets(25, 25, 25, 25));
		Scene input = new Scene(griddy, 400, 300, Color.IVORY);
		
		//Defining the output screen
		GridPane outputGrid = new GridPane();
		Scene output = new Scene(outputGrid, 400, 300, Color.IVORY);
		
		//Input objects
		//Adding the TextFields
		TextField ZIPCode = new TextField("ZIP");
		TextField Geo = new TextField("Geographic Location");
		griddy.add(ZIPCode, 0, 1);
		griddy.add(Geo, 0, 2);
		
		//Adding text
		Text blah = new Text("Input either a ZIP Code or a Geographic Address");
		griddy.add(blah, 0, 0);
		Text more = new Text("Select the restaraunts you want to look for");
		griddy.add(more, 0,3);
		
		//grid for the ToggleButtons
		GridPane grid2 = new GridPane();
		grid2.setHgap(10);
		grid2.setVgap(10);
		grid2.setPadding(new Insets(25));
		
		ToggleButton McD = new ToggleButton();
		grid2.add(McD, 0, 0);
		ToggleButton BK = new ToggleButton();
		grid2.add(BK, 1, 0);
		ToggleButton W = new ToggleButton();
		grid2.add(W, 2, 0);
		ToggleButton PH = new ToggleButton();
		grid2.add(PH, 3, 0);
		ToggleButton TJ = new ToggleButton();
		grid2.add(TJ, 4, 0);
		ToggleButton WF = new ToggleButton();
		grid2.add(WF, 5, 0);
		
		griddy.add(grid2, 0, 4);
		
		//Go Button
		Button go = new Button("Go!");
		go.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(output);
			}
		});
		griddy.add(go, 0, 5);
		
		//Output objects
		//Back button
		Button back = new Button("<-");
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(input);
			}
		});
		outputGrid.add(back, 0, 0);
		
		primaryStage.setScene(input);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
