import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

public class GuessMe extends Application {
    @Override
    public void start(Stage stage) {
        Random randomnum = new Random();
        
        int randomnumber = randomnum.nextInt(100); // Generate random number between 0 and 99
        // create and configure a text field for user entry
        TextField pushMeTextField = new TextField();
        pushMeTextField.setMaxWidth(30);
        
        // create and configure a label to display the output
        Label pushMeLabel= new Label();
        pushMeLabel.setTextFill(Color.RED);
        pushMeLabel.setFont(Font.font("Arial", 20));
        
        // create and configure a button to handle the guess
        Button guessButton = new Button();
        guessButton.setText("Guess!!");
        guessButton.setOnAction(e -> {
            String input = pushMeTextField.getText();
            try {
                int numinput = Integer.parseInt(input);
                if (numinput == randomnumber) {
                    pushMeLabel.setText("Congratulations! You guessed it right!");
                    pushMeLabel.setTextFill(Color.GREEN);
                } else if (numinput > randomnumber) {
                    pushMeLabel.setText("Your guess is higher.");
                    pushMeLabel.setTextFill(Color.RED);
                } else if (numinput < randomnumber) {
                    pushMeLabel.setText("Your guess is lower.");
                    pushMeLabel.setTextFill(Color.RED);
                    }
            } catch (NumberFormatException ex) {
                pushMeLabel.setText("Invalid input. Please enter a number.");
            }
        });
        System.out.print(randomnumber);  
        
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        
        // add the components to the VBox
        root.getChildren().addAll(pushMeTextField, guessButton, pushMeLabel);
       
        // create a new scene
        Scene scene = new Scene(root, 400, 200);
        
        // add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Guess Me Game");
        stage.show();        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}