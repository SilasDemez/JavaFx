package calculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    ArrayList<String> strNumbers = new ArrayList<>();

    int i = 0;
    double result = 0;
    String number = "";
    String operator = "";

    public javafx.scene.control.TextField display;


    @FXML
    public void initialize() {
        display.setText("0");
    }


    public void digitClickedHandler(ActionEvent evt) {

        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();

        number = number.concat(buttonLabel);
        display.setText(number);
        System.out.println("Number is: " + number);

        }


    public void operationClickHandler(ActionEvent evt) {

        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (number.equals("")) {

        }else{strNumbers.add(number);}

        System.out.println(strNumbers);



        if (buttonLabel.equals("=")){
            switch (operator){
                case "+":
                    for (String num:strNumbers) {
                        result+= Double.parseDouble(num);
                    }
                    break;
                case "-":
                    result = Double.parseDouble(strNumbers.get(0))*2;
                    for (String num:strNumbers) {
                        result-= Double.parseDouble(num);
                    }
                    break;
                case "/":
                    result = Double.parseDouble(strNumbers.get(0));
                    for (int i=1;i<strNumbers.size();i++){
                        result/= Double.parseDouble(strNumbers.get(i));
                    }
                    break;
                case "x":
                    result = 1;
                    for (String num:strNumbers) {
                        result*= Double.parseDouble(num);
                    }
                    break;
                default:
                    System.out.println("Problem!");
            }

            strNumbers.clear();
            strNumbers.add(String.valueOf(result));
            number = "";
            operator = "";
            System.out.println("Result: " + result);
            display.setText(String.valueOf(result));
            result = 0.0;



        }else if (buttonLabel.equals("C")){

            display.setText("0.0");
            strNumbers.clear();
            number = "";
            operator = "";
            result = 0.0;

        }else {

            operator = buttonLabel;
            display.setText(buttonLabel);
            number = "";

        }
    }
}

/*
        switch (buttonLabel){
            case "+":
                result =
        }
 */