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
		Scene input = new Scene(griddy, 800, 600, Color.IVORY);
		
		//Defining the output screen
		GridPane outputGrid = new GridPane();
		ScrollPane spOut = new ScrollPane();
		GridPane outGrid2 = new GridPane();
		Scene output = new Scene(outputGrid, 800, 600, Color.IVORY);
		spOut.setContent(outGrid2);
		spOut.setPrefSize(700, 600);
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
		
		ToggleButton McD = new ToggleButton("McDonald's");
		grid2.add(McD, 0, 0);
		ToggleButton BK = new ToggleButton("Burger King");
		grid2.add(BK, 0, 1);
		ToggleButton W = new ToggleButton("Wendy's");
		grid2.add(W, 1, 0);
		ToggleButton PH = new ToggleButton("Pizza Hut");
		grid2.add(PH, 1, 1);
		ToggleButton TJ = new ToggleButton("Trader Joe's");
		grid2.add(TJ, 2, 0);
		ToggleButton WF = new ToggleButton("Whole Foods");
		grid2.add(WF, 2, 1);
		
		griddy.add(grid2, 0, 4);
		
		//Go Button
		Button go = new Button("Go!");
		go.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(output);
			}
		});
		griddy.add(go, 0, 6);
		
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
		outputGrid.add(spOut, 0, 1);
		for(int i = 0; i <= 500; i++){
			Text t = new Text(10, 50, "42 Walloby Way, Melbourne, Sydney\n");
			t.setFont(new Font(20));
			outGrid2.add(t, 0, i);
		}
		primaryStage.setScene(input);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}}