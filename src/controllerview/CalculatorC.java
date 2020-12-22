package controllerview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class CalculatorC implements Initializable {
    private Stage stage;
    @FXML
    private TextField txt_input;
    private Stack<String> stack = new Stack<String>();
    private StringBuilder stringBuilder = new StringBuilder();
    @FXML
    private TextArea txt;



    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CalculatorC.class.getResource("calculator.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            CalculatorC ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            stage.setTitle("Calculator");
            stage.setScene(new Scene(root, 650, 500));
            stage.show();
        }
        catch (IOException e) {
            System.err.println("Something wrong with calculator.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    public void push()
    {
        txt.setText(stack.toString());
    }

    public void number0()
    {
        stringBuilder.append(0);
        txt_input.setText(stringBuilder.toString());
    }
    public void number1() {
        stringBuilder.append(1);
        txt_input.setText(stringBuilder.toString());
    }
    public void number2() {
        stringBuilder.append(2);
        txt_input.setText(stringBuilder.toString());
    }
    public void number3() {
        stringBuilder.append(3);
        txt_input.setText(stringBuilder.toString());
    }
    public void number4() {
        stringBuilder.append(4);
        txt_input.setText(stringBuilder.toString());
    }
    public void number5() {
        stringBuilder.append(5);
        txt_input.setText(stringBuilder.toString());
    }
    public void number6() {
        stringBuilder.append(6);
        txt_input.setText(stringBuilder.toString());
    }
    public void number7() {
        stringBuilder.append(7);
        txt_input.setText(stringBuilder.toString());
    }
    public void number8() {
        stringBuilder.append(8);
        txt_input.setText(stringBuilder.toString());
    }
    public void number9() {
        stringBuilder.append(9);
        txt_input.setText(stringBuilder.toString());
    }
    public void punkt()
    {
        stringBuilder.append(".");
        txt_input.setText(stringBuilder.toString());
    }
    public void enter()
    {
        if (txt_input.equals(""))
        {
            System.out.println("Keine Eingabe!");
        }

        else {
            stack.push(txt_input.getText());
            txt_input.setText("");
            stringBuilder.delete(0, stringBuilder.length());
            push();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
