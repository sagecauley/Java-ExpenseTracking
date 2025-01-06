import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javax.swing.text.Position;

public class HomeView {
    private GridPane root;

    private TextField nameField = new TextField();
    private TextField amountField = new TextField();
    private DatePicker dateField = new DatePicker();
    public HomeView() {
        root = new GridPane();
        for(int i = 0; i < 5; i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0/5);
            root.getRowConstraints().add(row);
        }
        for (int i = 0; i < 5; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / 5);
            root.getColumnConstraints().add(col);
        }

        //TextBoxs
        HBox textBoxs = makeTextFields();
        GridPane.setHgrow(textBoxs, Priority.ALWAYS);
        textBoxs.setPadding(new Insets(25));
        root.add(textBoxs, 0, 3, 5, 1);

        //Add Income/Expense Buttons
        Button addIncomeButton = new Button();
        Button addExpenseButton = new Button();
        
        GridPane.setHgrow(addIncomeButton, Priority.ALWAYS);
        GridPane.setHgrow(addExpenseButton, Priority.ALWAYS);

        addIncomeButton.setAlignment(Pos.CENTER);
        addIncomeButton.setText("Add Income");

        addExpenseButton.setAlignment(Pos.CENTER);
        addExpenseButton.setText("Add Expense");

        root.add(addIncomeButton, 1, 4);
        root.add(addExpenseButton, 4, 4);
        
    }

    private HBox makeTextFields(){
        HBox textFields = new HBox(10);

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateField.setConverter(new javafx.util.converter.LocalDateStringConverter(formatter, DateTimeFormatter.ISO_LOCAL_DATE));

        nameField.setPromptText("Enter name of Expense/Income here");

        amountField.setPromptText("Enter amount here");

        HBox.setHgrow(nameField, Priority.ALWAYS);
        HBox.setHgrow(amountField, Priority.ALWAYS);
        HBox.setHgrow(dateField, Priority.ALWAYS);

        textFields.getChildren().addAll(nameField, amountField, dateField);
        return textFields;
    }
    public GridPane getRoot() {
        return root;
    }
}