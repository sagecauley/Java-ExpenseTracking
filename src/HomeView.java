
import java.math.BigDecimal;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javax.print.attribute.standard.DateTimeAtCreation;
import javax.swing.text.Position;

public class HomeView {
    private GridPane root;

    private TextField nameField = new TextField();
    private TextField amountField = new TextField();
    private DatePicker dateField = new DatePicker();

    private Controller controller;
    private Model model;
    public HomeView(Controller c, Model m) {
        controller = c;
        model = m;

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
        addIncomeButton.setOnAction(event -> AddIncome());

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
        amountField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String currentText = amountField.getText();
            // Allow only digits and one decimal point
            if (!event.getCharacter().matches("[0-9.]")) {
                event.consume();  // Prevent invalid characters from being entered
            }

            // Ensure there's only one decimal point
            if (currentText.contains(".") && event.getCharacter().equals(".")) {
                event.consume();  // Prevent more than one decimal point
            }
        });

        HBox.setHgrow(nameField, Priority.ALWAYS);
        HBox.setHgrow(amountField, Priority.ALWAYS);
        HBox.setHgrow(dateField, Priority.ALWAYS);

        textFields.getChildren().addAll(nameField, amountField, dateField);
        return textFields;
    }

    private void AddIncome(){
        if(CheckFields()){
            try{
            BigDecimal amount = new BigDecimal(amountField.getText());
            controller.AddIncome(new CommonIncome(nameField.getText(), dateField.getValue(), amount));
            }
            catch(NumberFormatException e){
                showErrorMessage("Amount not in correct format");
            }
        }
    }

    private boolean CheckFields(){
        if(nameField.getText() == null || nameField.getText().length() <= 0){
            showErrorMessage("No name entered. Add a name");
            return false;
        }
        if(amountField.getText() == null || amountField.getText().length() <= 0){
            showErrorMessage("No amount entered. Enter an amount");
            return false;
        }
        if(dateField.getValue().toString().length() <= 0){
            showErrorMessage("No date entered. Enter a Date");
            return false;
        }

        return true;
    }

    private void showErrorMessage(String message){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(message);

        alert.showAndWait();
    }
    public GridPane getRoot() {
        return root;
    }
}