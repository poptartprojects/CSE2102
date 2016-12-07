package JavaFX;

import backend.Database;
import backend.Search;
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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class JavaFXMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		//Setting up the database
		Database datey = new Database();
		//Defining the input screen
		GridPane griddy = new GridPane();
		griddy.setAlignment(Pos.TOP_CENTER);
		griddy.setHgap(10);
		griddy.setVgap(10);
		griddy.setPadding(new Insets(25, 25, 25, 25));
		Scene input = new Scene(griddy, 800, 600, Color.IVORY);

		//Defining the output screen
		GridPane outputGrid = new GridPane();
		ColumnConstraints columnO = new ColumnConstraints();
		columnO.setPercentWidth(100);
		outputGrid.getColumnConstraints().add(columnO);
		ScrollPane spOut = new ScrollPane();
		GridPane outGrid2 = new GridPane();
		Scene output = new Scene(outputGrid, 800, 600, Color.IVORY);
		spOut.setContent(outGrid2);
		spOut.setPrefSize(700, input.getWidth());
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
		Text error = new Text();
		griddy.add(error, 0, 7);
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

		//Loading image assets
		Image McDLogo, BKLogo, WLogo, PHLogo, TJLogo, WFLogo, UnknownLogo;
		McDLogo = new Image("/Logos/McD.png");
		BKLogo = new Image("/Logos/BK.png");
		WLogo = new Image("/Logos/W.png");
		PHLogo = new Image("/Logos/PH.png");
		TJLogo = new Image("/Logos/TJ.png");
		WFLogo = new Image("/Logos/WF.png");
		UnknownLogo = new Image("/Logos/Unknown.png");
		
		//Go Button
		Button go = new Button("Go!");
		go.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				String UZIP = ZIPCode.getText();
				String UGeo = Geo.getText();
				error.setText("");
				//verify user input
				if(!McD.isSelected() && !BK.isSelected() && !W.isSelected() && !PH.isSelected() && !TJ.isSelected() && !WF.isSelected()){
					error.setText("You must select at least one store");
				}else if(UZIP.equals("ZIP") && UGeo.equals("Geographic Location")){
					error.setText("You must provide a ZIP code or an address as your search location");
				}else{
					//tell the application what to search for
					Search searcher = new Search();
					searcher.setMcD(McD.isSelected());
					searcher.setBK(BK.isSelected());
					searcher.setW(W.isSelected());
					searcher.setPH(PH.isSelected());
					searcher.setTJ(TJ.isSelected());
					searcher.setWF(WF.isSelected());
					if(UGeo.equals("Geographic Location")){
						searcher.setInput(UZIP);
					}else{
						searcher.setInput(UGeo);
					}


					//Searching
					boolean inDatabase = false;
					for(Search s : datey.getHistory()){
						if(searcher.equals(s)){
							inDatabase = true;
							searcher.setResults(s.getResults());
							break;
						}
					}
					if(!inDatabase){	
						searcher.showMe();
					}
					//add if statement is results are all empty
					if(searcher.getResults()[0] == null)
						error.setText("There were no results. Did you put in a proper ZIP code or address?");
					else{
						for(int i = 0; i < searcher.getResults().length; i++/*PlacesSearchResult result : searcher.getResults().results*/){
							if(searcher.getResults()[i] != null){
								String storeName = searcher.getResults()[i].name; 
								GridPane tgrid = new GridPane();
								tgrid.setHgap(15);
								ColumnConstraints column1 = new ColumnConstraints();
								column1.setPercentWidth(10);
								ColumnConstraints column2 = new ColumnConstraints();
								column2.setPercentWidth(75);
								ColumnConstraints column3 = new ColumnConstraints();
								column3.setPercentWidth(8);
								ColumnConstraints column4 = new ColumnConstraints();
								column4.setPercentWidth(7);
								
								tgrid.getColumnConstraints().add(column1);
								tgrid.getColumnConstraints().add(column2);
								tgrid.getColumnConstraints().add(column3);
								tgrid.getColumnConstraints().add(column4);
								
								ImageView l;
								Text hours;
								Text fee;
								if(storeName.equals("McDonald's")){
									l = new ImageView(McDLogo);
									hours = new Text("24/7");
									fee = new Text("-");
								}else if(storeName.equals("Burger King")){
									l = new ImageView(BKLogo);
									hours = new Text("24/7");
									fee = new Text("-");
								}else if(storeName.equals("Wendy's")){
									l = new ImageView(WLogo);
									hours = new Text("6am - midnight");
									fee = new Text("-");
								}else if(storeName.equals("Pizza Hut")){
									l = new ImageView(PHLogo);
									hours = new Text("8am - 11pm");
									fee = new Text("-");
								}else if(storeName.equals("Trader Joe's")){
									l = new ImageView(TJLogo);
									hours = new Text("7am - 10pm");
									fee = new Text("$8/month");
								}else if(storeName.contains("Whole Foods")){
									l = new ImageView(WFLogo);
									hours = new Text("7am - 11pm");
									fee = new Text("$10/month");
								}else{
									l = new ImageView(UnknownLogo);
									hours = new Text("N/A");
									fee = new Text("N/A");
								}
								l.setPreserveRatio(true);
								l.setFitHeight(50);
								//Text b = new Text(storeName);
								Text t = new Text(10, 50, searcher.getResults()[i].formattedAddress);
								t.setFont(new Font(20));
								tgrid.add(l, 0, 0);
								//tgrid.add(b, 1, 0);
								tgrid.add(t, 1, 0);
								hours.setTextAlignment(TextAlignment.CENTER);
								tgrid.add(hours, 2, 0);
								fee.setTextAlignment(TextAlignment.CENTER);
								tgrid.add(fee, 3, 0);
								outGrid2.add(tgrid, 0, i);
							}
						}
						primaryStage.setScene(output);
					}
				}
			}
		}
				);
		griddy.add(go, 0, 6);

		//Output objects
		//Back button
		Button back = new Button("<-");
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(input);
				outGrid2.getChildren().clear();
			}
		}
		);
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		GridPane title = new GridPane();
		Text log = new Text("");
		Text add = new Text("Address");
		Text hour = new Text("Hours");
		Text fee = new Text("Fee");
		title.setHgap(15);
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(10);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(8);
		ColumnConstraints column4 = new ColumnConstraints();
		column4.setPercentWidth(7);
		
		title.getColumnConstraints().add(column1);
		title.getColumnConstraints().add(column2);
		title.getColumnConstraints().add(column3);
		title.getColumnConstraints().add(column4);
		title.add(log, 0, 0);
		title.add(add, 1, 0);
		title.add(hour, 2, 0);
		title.add(fee, 3, 0);
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		outputGrid.add(back, 0, 0);
		outputGrid.add(title, 0, 1);
		outputGrid.add(spOut, 0, 2);
		/*for(int i = 0; i <= 500; i++){
			Text t = new Text(10, 50, "42 Walloby Way, Melbourne, Sydney\n");
			t.setFont(new Font(20));
			outGrid2.add(t, 0, i);
		}*/
		primaryStage.setScene(input);
		primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}}