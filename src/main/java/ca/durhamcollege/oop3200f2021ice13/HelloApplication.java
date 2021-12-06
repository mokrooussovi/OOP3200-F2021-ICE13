package ca.durhamcollege.oop3200f2021ice13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class HelloApplication extends Application
{
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello, World!");

        // Step 1 - create one or more control
        Label helloLabel = new Label("Hello, World");

        Label goodByeLabel = new Label("Good Bye!");

        Button clickMeButton = new Button("Click me");

        // Step 1.1 - Configure your controls
        Font font = Font.font("Consolas", FontWeight.BOLD, 20);
        clickMeButton.setFont(font);

        // Step 1.2 - For button controls (or other event-type controls) - set the event
        clickMeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ClickMe Button Clicked!");

                helloLabel.setText("Clicked!");
            }
        });

        // Step 2 - create a container
        // HBox hbox = new HBox(helloLabel, clickMeBUtton);
        //VBox vbox = new VBox(helloLabel, clickMeBUtton);

        GridPane gridPane = new GridPane();

        gridPane.add(helloLabel, 1, 0);
        gridPane.add(goodByeLabel, 1, 1);
        gridPane.add(clickMeButton, 2, 2);

        // Step 3 - add layout container to scene
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // Step 4 - add scene to stage
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}