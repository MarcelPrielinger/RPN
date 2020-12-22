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
    private Stack<Double> stack = new Stack<Double>();
    private StringBuilder stringBuilder = new StringBuilder();
    @FXML
    private TextArea txt;
    @FXML
    private Label txt_exception;


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
    public String txt_stage(Stack<Double> stack1)
    {
        StringBuilder stringBuilder1 = new StringBuilder();
        for(int i = stack1.size()-1; i >= 0;i--)
        {
            stringBuilder1.append(stack1.elementAt(i) + "\n");
        }
        return stringBuilder1.toString();
    }

    public void number0()
    {
        txt_exception.setText("");
        stringBuilder.append(0);
        txt_input.setText(stringBuilder.toString());
    }
    public void number1() {
        txt_exception.setText("");
        stringBuilder.append(1);
        txt_input.setText(stringBuilder.toString());
    }
    public void number2() {
        txt_exception.setText("");
        stringBuilder.append(2);
        txt_input.setText(stringBuilder.toString());
    }
    public void number3() {
        txt_exception.setText("");
        stringBuilder.append(3);
        txt_input.setText(stringBuilder.toString());
    }
    public void number4() {
        txt_exception.setText("");
        stringBuilder.append(4);
        txt_input.setText(stringBuilder.toString());
    }
    public void number5() {
        txt_exception.setText("");
        stringBuilder.append(5);
        txt_input.setText(stringBuilder.toString());
    }
    public void number6() {
        txt_exception.setText("");
        stringBuilder.append(6);
        txt_input.setText(stringBuilder.toString());
    }
    public void number7() {
        txt_exception.setText("");
        stringBuilder.append(7);
        txt_input.setText(stringBuilder.toString());
    }
    public void number8() {
        txt_exception.setText("");
        stringBuilder.append(8);
        txt_input.setText(stringBuilder.toString());
    }
    public void number9() {
        txt_exception.setText("");
        stringBuilder.append(9);
        txt_input.setText(stringBuilder.toString());
    }
    public void punkt()
    {
        txt_exception.setText("");
        stringBuilder.append(".");
        txt_input.setText(stringBuilder.toString());
    }
    public void enter()
    {
        if (stringBuilder.toString().equals(""))
        {

        }
        else if(stringBuilder.toString().contains("..") || stringBuilder.indexOf(".") == stringBuilder.length()-1 || stringBuilder.indexOf(".") == 0)
        {
            System.out.println("Falsche Eingabe!");
            txt_exception.setText("Falsche Eingabe!");
            txt_input.setText("");
            stringBuilder.delete(0, stringBuilder.length());
        }
        else {
            txt_exception.setText("");
            stack.push(Double.parseDouble(txt_input.getText()));
            txt.setText(txt_stage(stack));
            txt_input.setText("");
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    public void btn_c()
    {
        try {
            txt_exception.setText("");
            while (!stack.empty()) {
                stack.pop();
            }
            txt_input.setText("");
            stringBuilder.delete(0, stringBuilder.length());
            txt.setText("");
        }
        catch (Exception e)
        {
            txt_exception.setText("Exception found!");
        }
    }
    public void btn_ce()
    {
        try {
            txt_exception.setText("");
            txt_input.setText("");
            stringBuilder.delete(0, stringBuilder.length());
        }
        catch (Exception e)
        {
            txt_exception.setText("Exception found!");
        }
    }

    public void plus()
    {
        enter();
        try {
            if(stack.size() < 2)
            {
                txt_exception.setText("Not enough values!");
            }
            else {
                enter();
                double n1 = stack.pop();
                double n2 = stack.pop();
                double result = n1 + n2;
                stack.push(result);
                txt.setText(txt_stage(stack));
            }
        }
        catch (ArithmeticException e)
        {
            System.out.printf("ArithmeticException");
        }
    }
    public void minus()
    {
        enter();
        try {
            if(stack.size() < 2)
            {
                txt_exception.setText("Not enough values!");
            }
            else {
                enter();
                double n1 = stack.pop();
                double n2 = stack.pop();
                double result = n2 - n1;
                stack.push(result);
                txt.setText(txt_stage(stack));
            }
        }
        catch (ArithmeticException e)
        {
            System.out.printf("ArithmeticException");
        }
    }
    public void mal()
    {
        enter();
        try {
            if(stack.size() < 2)
            {
                txt_exception.setText("Not enough values!");
            }
            else {
                enter();
                double n1 = stack.pop();
                double n2 = stack.pop();
                double result = n1 * n2;
                stack.push(result);
                txt.setText(txt_stage(stack));
            }
        }
        catch (ArithmeticException e)
        {
            System.out.printf("ArithmeticException");
        }
    }
    public void durch()
    {
        enter();
        try {
            if(stack.size() < 2)
            {
                txt_exception.setText("Not enough values!");
            }
            else {
                enter();
                double n1 = stack.pop();
                double n2 = stack.pop();
                double result = n2 / n1;
                stack.push(result);
                txt.setText(txt_stage(stack));
            }
        }
        catch (ArithmeticException e)
        {
            System.out.printf("ArithmeticException");
        }
    }
    public void kehrwert()
    {
        try
        {
            double n1 = stack.pop();
            double result = 1/n1;
            stack.push(result);
            txt.setText(txt_stage(stack));
        }
        catch (ArithmeticException e)
        {
            System.out.printf("ArithmeticException");
        }
    }

    public void tausch()
    {
        try {
            if(stack.size() < 2)
            {
                txt_exception.setText("Not enough values!");
            }
            else {
                enter();
                double n1 = stack.pop();
                double n2 = stack.pop();
                stack.push(n1);
                stack.push(n2);
                txt.setText(txt_stage(stack));
            }
        }
        catch (ArithmeticException e)
        {
            System.out.printf("ArithmeticException");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
