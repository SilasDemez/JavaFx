package sample;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.awt.*;

public class Controller {

    public javafx.scene.control.TextField id1;
    public javafx.scene.control.PasswordField pwd;
    public javafx.scene.control.Label errMsg;
    //@FXML private TextField id;
    //@FXML private PasswordField pwd;
    //@FXML private Label errMsg;

    SimpleStringProperty signinError = new SimpleStringProperty();
    @FXML public void initialize() {

        errMsg.textProperty().bind(signinError);
    }

    /*
    public void signInClicked(ActionEvent evt){

        String userID = id1.getText();
        String password = pwd.getText();

        if (!"admin".equals(userID)){
            id1.setStyle("-fx-background-color:lightpink;");
            signinError.set("Wrong id: " + userID);
        } else{
            id1.setStyle("-fx-background-color:white;");
            signinError.set("");
        }

        if (!"admin".equals(password)){
            pwd.setStyle("-fx-background-color:lightpink;");
            signinError.set("Wrong password: " + password);
        } else{
            pwd.setStyle("-fx-background-color:white;");
            signinError.set("");
        }

        System.out.println("got id:" + userID + ", got password: " + password);
    }


     */

    public void signInClicked(ActionEvent evt){

        String userID = id1.getText();
        String password = pwd.getText();

        rightStartOfLongRunningProcess(userID);

        System.out.println("got id:" + userID +
                ", got password: " + password);
    }

    private void rightStartOfLongRunningProcess(String uID) {

        Runnable loginTask = () -> {
            try {
                Thread.sleep(10000);

                Platform.runLater(() -> {
                    if (!"Yakov".equals(uID)){
                        id1.setStyle("-fx-background-color: lightpink;");
                    } else{
                        id1.setStyle("-fx-background-color: white;");
                    }
                });

            } catch (InterruptedException interExp) {
                interExp.printStackTrace();
            }
        };

        Thread workerThread = new Thread(loginTask);
        workerThread.start();
    }
}
