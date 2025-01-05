import javafx.application.Application;
import javafx.geometry.Pos;  // Import for Pos
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");

        Label label = new Label("Hello World, JavaFX !");
        label.setAlignment(Pos.CENTER);  // Center the text
        Scene scene = new Scene(label, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
