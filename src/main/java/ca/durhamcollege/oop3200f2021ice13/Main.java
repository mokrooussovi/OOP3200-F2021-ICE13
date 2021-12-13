package ca.durhamcollege.oop3200f2021ice13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application
{
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello, World!");

        // Step 1 - create one or more control
        Label imageLabel = new Label("Xbox Series X!");

        Button clickMeButton = new Button("Click me");
        clickMeButton.setStyle("-fx-font-family: Arial");

        FileInputStream imagePath = new FileInputStream("src/sample/xboxseriesx.jpg");

        // step 1 for images - is load the image
        Image xboxSeriesX = new Image(imagePath);

        // step 2 for images - is setup a ImageView to "contain it"
        ImageView consoleImageView = new ImageView(xboxSeriesX);
        consoleImageView.setFitWidth(400);
        consoleImageView.setPreserveRatio(true);

        FileInputStream ps5Path = new FileInputStream("src/sample/ps5.jpg");
        Image ps5 = new Image(ps5Path);

 /*
        Label helloLabel = new Label("Hello, World");

        Label goodByeLabel = new Label("Good Bye!");

        Button clickMeButton = new Button("Click me");
*/

        // Step 1.1 - Configure your controls
        //Font font = Font.font("Consolas", FontWeight.BOLD, 20);
        //clickMeButton.setFont(font);

        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                imageLabel.setText("PS5!");
                consoleImageView.setImage(ps5);
            }
        }

        clickMeButton.setOnAction(new ButtonClickHandler());

        // Step 1.2 - For button controls (or other event-type controls)
        // - set the event
        /*
        clickMeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ClickMe Button Clicked!");

                helloLabel.setText("Clicked!");
            }
        });

         */

        // Step 2 - create a container
        /*
        HBox hBox = new HBox(10, helloLabel, goodByeLabel);
        //hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-border-color: black; -fx-alignment: center; -fx-font-size: 20px;");
        //hBox.setStyle("-fx-alignment: center");

         */
        HBox hbox = new HBox(10, imageLabel);
        hbox.setStyle("-fx-alignment: center; ");

        HBox hbox2 = new HBox(10, consoleImageView);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(hbox, 0, 0);
        gridPane.add(hbox2, 0, 1);
        gridPane.add(consoleImageView, 0, 2);
        gridPane.add(clickMeButton, 2, 2);

        //gridPane.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        gridPane.setStyle("-fx-border-color: red; -fx-font-size: 20px; -fx-font-family: " +
                "Consolas; -fx-font-weight: bold; -fx-cell-size: 60px;");

        // Step 3 - add layout container to scene
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // Step 4 - add scene to stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}