import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the HomeView and set it as the scene's root
        HomeView homeView = new HomeView();

        // Set the scene with the HomeView as the root
        Scene scene = new Scene(homeView.getRoot(), 1200, 600);
        primaryStage.setTitle("My JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
