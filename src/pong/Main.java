package pong;

//https://www.youtube.com/watch?v=jkYKoRX8i3Q
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle = new Circle();
        circle.setFill(Color.AQUAMARINE);
        circle.setRadius(30);
        circle.setLayoutX(50);
        circle.setLayoutY(50);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setToX(500);
        transition.setToY(500);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(circle);
        transition.play();

        Pane root = new Pane();
        //Parent root = FXMLLoader.load(getClass().getResource("pong.fxml"));
        root.getChildren().add(circle);
        Scene scene = new Scene(root,600,600);
        primaryStage.setTitle("Pong");
        scene.getStylesheets().add(getClass().getResource("pong.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

