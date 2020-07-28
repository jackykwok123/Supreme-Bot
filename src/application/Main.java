package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root,1280,750);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Image img = new Image ("https://i.ibb.co/7gW9k1m/icon.png");
			primaryStage.getIcons().add(img);
			primaryStage.setScene(scene);
			primaryStage.setTitle("JKBOT");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
