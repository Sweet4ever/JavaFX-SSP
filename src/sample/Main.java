package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage){
        double height = 700;
        double width = 600;
        // Use a FlowPane for the root node. In this case,
        // vertical and horizontal gaps of 10.
        FlowPane rootNode = new FlowPane();

        // Center the controls in the scene.
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPrefWrapLength(600);
        rootNode.setPrefHeight(700);

        // Create a scene.
        Scene myScene = new Scene(rootNode, width, height);
        myScene.getStylesheets().add("stylesheet.css");

        // Give the stage a title.
        myStage.setTitle("Sten Sax Påse");

        GridPane computerSide = new GridPane();
        computerSide.getStyleClass().add("computer");
        computerSide.setPrefSize(width, 5*(height/12));
        
        GridPane playerSide = new GridPane();
        playerSide.getStyleClass().add("player");
        playerSide.setPrefSize(width, 5*(height/12));


        // Create a button that gets the text.
        Image imageRock = new Image("file:Rock.png");
        ImageView rockView = new ImageView(imageRock);
        rockView.setFitHeight(80);
        rockView.setFitWidth(80);
        Button btnRock = new Button("",rockView);
        btnRock.getStyleClass().add("choice");
        btnRock.setPrefSize(80, 80);

        Image imageScissor = new Image("file:Scissor.png");
        ImageView scissorView = new ImageView(imageScissor);
        scissorView.setFitHeight(80);
        scissorView.setFitWidth(80);
        Button btnScissor = new Button("", scissorView);
        btnScissor.getStyleClass().add("choice");
        btnScissor.setPrefSize(80, 80);

        Image imagePaper = new Image("file:Paper.png");
        ImageView paperView = new ImageView(imagePaper);
        paperView.setFitHeight(80);
        paperView.setFitWidth(80);
        Button btnPaper = new Button("", paperView);
        btnPaper.getStyleClass().add("choice");
        btnPaper.setPrefSize(80, 80);

        FlowPane btnWrapper = new FlowPane(70, 10);
        btnWrapper.getStyleClass().add("wrapper");
        btnWrapper.setAlignment(Pos.CENTER);
        btnWrapper.setPrefWrapLength(width);
        btnWrapper.setPrefHeight(height/6);
        btnWrapper.getChildren().addAll(btnRock, btnScissor, btnPaper);

        rootNode.getChildren().addAll(computerSide, playerSide, btnWrapper);

        // Set the scene on the stage.
        myStage.setScene(myScene);
        myStage.show();
    }
}
