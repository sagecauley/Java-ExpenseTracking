import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;

public class HomeView {
    private StackPane root;

    public HomeView() {
        root = new StackPane();  // Create the layout
        Label label = new Label("Hello World, JavaFX! On HomeView");
        label.setAlignment(Pos.CENTER);  // Center the label text
        root.getChildren().add(label);  // Add the label to the root
        
    }

    public StackPane getRoot() {
        return root;
    }
}