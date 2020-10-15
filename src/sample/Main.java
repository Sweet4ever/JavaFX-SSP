package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public static int res;
    public static int playerScore = 0;
    public static int computerScore = 0;

    public void start(Stage myStage){
        double height = 700;
        double width = 600;
        Image[] choiceArray = new Image[]{new Image("file:Rock.png"), new Image("file:Scissor.png"), new Image("file:Paper.png")};
        Image imageWin = new Image("file:Winner.png");
        Image imageLose = new Image("file:Lose.png");
        Image imageTie = new Image("file:Tie.png");
        FlowPane rootNode = new FlowPane();

        // Center the controls in the scene.
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPrefWrapLength(width);
        rootNode.setPrefHeight(height);

        // Create a scene.
        Scene myScene = new Scene(rootNode, width, height);
        myScene.getStylesheets().add("stylesheet.css");

        // Give the stage a title.
        myStage.setTitle("Rock Paper Scissor");

        //Drawing a Rectangle
        Rectangle shape1 = new Rectangle();
        //Setting the properties of the rectangle
        shape1.setWidth(150.0f);
        shape1.setHeight(150.0f);
        shape1.setX((width/2)-(shape1.getWidth()/2));
        shape1.setY(70.0f);
        //Setting other properties
        shape1.setFill(new ImagePattern(choiceArray[0]));

        Rectangle shape2=new Rectangle();
        shape2.setWidth(100.0f);
        shape2.setHeight(40.0f);
        shape2.setX((width/2)-(shape2.getWidth()/2));
        shape2.setY(270.0f);
        //Setting other properties
        shape2.setFill(new ImagePattern(imageTie));

        Rectangle shape3=new Rectangle();
        shape3.setWidth(150.0f);
        shape3.setHeight(150.0f);
        shape3.setX((width/2)-(shape3.getWidth()/2));
        shape3.setY(70.0f);
        //Setting other properties
        shape3.setFill(new ImagePattern(choiceArray[0]));

        Rectangle shape4=new Rectangle();
        shape4.setWidth(100.0f);
        shape4.setHeight(40.0f);
        shape4.setX((width/2)-(shape4.getWidth()/2));
        shape4.setY(-20);
        //Setting other properties
        shape4.setFill(new ImagePattern(imageTie));

        TextField computerPoints = new TextField();
        computerPoints.setEditable(false);
        computerPoints.setPrefSize(40, 40);
        computerPoints.getStyleClass().add("textField");
        computerPoints.setText(String.valueOf(computerScore));
        computerPoints.setAlignment(Pos.CENTER);

        Pane computerSide = new Pane();
        computerSide.getStyleClass().add("computer");
        computerSide.setPrefSize(width, 5*(height/12));
        computerSide.getChildren().addAll(shape1, shape2, computerPoints);

        TextField playerPoints = new TextField();
        playerPoints.setEditable(false);
        playerPoints.setPrefSize(40, 40);
        playerPoints.getStyleClass().add("textField");
        playerPoints.setText(String.valueOf(playerScore));
        playerPoints.setAlignment(Pos.CENTER);

        Pane playerSide = new Pane();
        playerSide.getStyleClass().add("player");
        playerSide.setPrefSize(width, 5*(height/12));
        playerSide.getChildren().addAll(shape3, shape4, playerPoints);

        // Create a button that gets the text.
        ImageView rockView = new ImageView(choiceArray[0]);
        rockView.setFitHeight(80);
        rockView.setFitWidth(80);
        Button btnRock = new Button("",rockView);
        btnRock.getStyleClass().add("choice");
        btnRock.setPrefSize(80, 80);
        btnRock.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                shape3.setFill(new ImagePattern(choiceArray[0]));
                res = Game.rock();

                switch (res){
                    case 0:
                        shape2.setFill(new ImagePattern(imageTie));
                        shape4.setFill(new ImagePattern(imageTie));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        break;
                    case 1:
                        shape2.setFill(new ImagePattern(imageWin));
                        shape4.setFill(new ImagePattern(imageWin));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        playerScore++;
                        playerPoints.setText(String.valueOf(playerScore));
                        break;
                    case 2:
                        shape2.setFill(new ImagePattern(imageLose));
                        shape4.setFill(new ImagePattern(imageLose));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        computerScore++;
                        computerPoints.setText(String.valueOf(computerScore));
                        break;
                }
            }
        });

        ImageView scissorView = new ImageView(choiceArray[1]);
        scissorView.setFitHeight(80);
        scissorView.setFitWidth(80);
        Button btnScissor = new Button("", scissorView);
        btnScissor.getStyleClass().add("choice");
        btnScissor.setPrefSize(80, 80);
        btnScissor.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                shape3.setFill(new ImagePattern(choiceArray[1]));
                res = Game.scissor();

                switch (res){
                    case 0:
                        shape2.setFill(new ImagePattern(imageTie));
                        shape4.setFill(new ImagePattern(imageTie));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        break;
                    case 1:
                        shape2.setFill(new ImagePattern(imageWin));
                        shape4.setFill(new ImagePattern(imageWin));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        playerScore++;
                        playerPoints.setText(String.valueOf(playerScore));
                        break;
                    case 2:
                        shape2.setFill(new ImagePattern(imageLose));
                        shape4.setFill(new ImagePattern(imageLose));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        computerScore++;
                        computerPoints.setText(String.valueOf(computerScore));
                        break;
                }
            }
        });

        ImageView paperView = new ImageView(choiceArray[2]);
        paperView.setFitHeight(80);
        paperView.setFitWidth(80);
        Button btnPaper = new Button("", paperView);
        btnPaper.getStyleClass().add("choice");
        btnPaper.setPrefSize(80, 80);
        btnPaper.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                shape3.setFill(new ImagePattern(choiceArray[2]));
                res = Game.paper();

                switch (res){
                    case 0:
                        shape2.setFill(new ImagePattern(imageTie));
                        shape4.setFill(new ImagePattern(imageTie));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        break;
                    case 1:
                        shape2.setFill(new ImagePattern(imageWin));
                        shape4.setFill(new ImagePattern(imageWin));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        playerScore++;
                        playerPoints.setText(String.valueOf(playerScore));
                        break;
                    case 2:
                        shape2.setFill(new ImagePattern(imageLose));
                        shape4.setFill(new ImagePattern(imageLose));
                        shape1.setFill(new ImagePattern(choiceArray[Game.computerChoice]));
                        computerScore++;
                        computerPoints.setText(String.valueOf(computerScore));
                        break;
                }
            }
        });

        FlowPane btnWrapper = new FlowPane(70, 10);
        btnWrapper.getStyleClass().add("wrapper");
        btnWrapper.setAlignment(Pos.CENTER);
        btnWrapper.setPrefWrapLength(width);
        btnWrapper.setPrefHeight(height/6);
        btnWrapper.getChildren().addAll(btnRock, btnScissor, btnPaper);



        rootNode.getChildren().addAll(computerSide, playerSide, btnWrapper);

        // Set the scene on the stage.
        myStage.setScene(myScene);
        myStage.setResizable(false);
        myStage.show();
    }
}
