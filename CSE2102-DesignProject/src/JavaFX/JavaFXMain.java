package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.control.TextField;


public class JavaFXMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene sceney = new Scene(root, 400, 300, Color.IVORY);
		primaryStage.setScene(sceney);
		//Adding the TextFields
		Group textFields = new Group();
		TextField ZIPCode = new TextField("ZIP");
		TextField Geo = new TextField("Geographic Location");
		textFields.getChildren().add(ZIPCode);
		textFields.getChildren().add(Geo);
		root.getChildren().add(textFields);
		primaryStage.setScene(sceney);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
