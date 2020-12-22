package controllerview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorC implements Initializable {
    private Stage stage;
    @FXML
    private Button btn_0;
    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_3;
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_5;
    @FXML
    private Button btn_6;
    @FXML
    private Button btn_7;
    @FXML
    private Button btn_8;
    @FXML
    private Button btn_9;



    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CalculatorC.class.getResource("calculator.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            CalculatorC ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            stage.setTitle("Calculator");
            stage.setScene(new Scene(root, 600, 500));
            stage.show();
        }
        catch (IOException e) {
            System.err.println("Something wrong with LoginV.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    @FXML
    private void clickButton(MouseEvent event) {
        Object node = event.getSource(); //returns the object that generated the event
        //since the returned object is a Button we can do a typecast
        Button btn = (Button)node;
        String s = btn.getText();
        System.out.println(s);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
