import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Text fields for input numbers
        TextField num1Field = new TextField();
        TextField num2Field = new TextField();

        // Label for displaying result
        Label resultLabel = new Label();

        // Buttons for operators
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        // Button action for addition
        addButton.setOnAction(event -> {
        try{
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = num1 + num2;
            resultLabel.setText("Result: " + result);
                    }catch(NumberFormatException ex){
            resultLabel.setText("There is no number to calculate!");
            }
        });

        // Similar actions for other buttons (subtract, multiply, divide)
        subtractButton.setOnAction(event -> {
        try{
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = num1 - num2;
            resultLabel.setText("Result: " + result);
        }catch(NumberFormatException ex){
            resultLabel.setText("There is no number to calculate!");
            }
        });

        multiplyButton.setOnAction(event -> {
        try{
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = num1 * num2;
            resultLabel.setText("Result: " + result);
                    }catch(NumberFormatException ex){
            resultLabel.setText("There is no number to calculate!");
            }
        });

        divideButton.setOnAction(event -> {
        try{
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            if (num2 == 0) {
                resultLabel.setText("Error: Division by zero!");
            } else {
                double result = num1 / num2;
                resultLabel.setText("Result: " + result);
                
            }
                    }catch(NumberFormatException ex){
            resultLabel.setText("There is no number to calculate!");
            }
            
        });

        // Layout using GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        grid.add(num1Field, 0, 0);
        grid.add(num2Field, 1, 0);
        grid.add(addButton, 0, 1);
        grid.add(subtractButton, 1, 1);
        grid.add(multiplyButton, 2, 1);
        grid.add(divideButton, 3, 1);
        grid.add(resultLabel, 0, 2, 4, 1);

        // Scene and Stage setup
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}