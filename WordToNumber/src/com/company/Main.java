package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class Main extends Application {

    //create the three input strings

    String firstString;
    String secondString;
    String thirdString;

    WordToNumber wordToNumber = new WordToNumber();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage window) throws Exception {

        //Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(5);
        grid.setHgap(5);

        //create input 1
        final TextField inputOne = new TextField();
        inputOne.setPromptText("Enter Input One");
        inputOne.setPrefColumnCount(10);
        inputOne.getText();
        GridPane.setConstraints(inputOne, 0, 0);
        grid.getChildren().add(inputOne);

        //create input 2
        final TextField inputTwo = new TextField();
        inputTwo.setPromptText("Enter Input Two");
        GridPane.setConstraints(inputTwo, 0, 1);
        grid.getChildren().add(inputTwo);

        //create input 3
        final TextField inputThree = new TextField();
        //preferred width of the column
        inputThree.setPrefColumnCount(15);
        inputThree.setPromptText("Enter Input Three");
        GridPane.setConstraints(inputThree, 0, 2);
        grid.getChildren().add(inputThree);

        //create the submit button
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);

        //Adding the error label
        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);


        //creating second window layout
        VBox layout2 = new VBox();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();

        //set margins of the result box
        VBox.setMargin(label1, new Insets(20, 20, 10,20));
        VBox.setMargin(label2, new Insets(20, 20, 10,20));
        VBox.setMargin(label3, new Insets(20, 20, 10,20));

        //create a go back button and set margins
        Button goBack = new Button("Go Back");
        VBox.setMargin(goBack, new Insets(20, 20, 10,20));

        //create the second layout
        layout2.getChildren().addAll(label1, label2, label3, goBack);

        //initiate Scene 1 and Scene 2
        Scene scene = new Scene(grid, 400, 200);
        Scene scene2 = new Scene(layout2, 400, 200);


        /**
         * Note the functionality of the submit button
         * When the button is pressed the function checks the three inputs to make sure only alphabetical characters are used
         * Uses the isAtoZ method of the WordToNumber class
         * If check comes back false then error message is displayed and fields are cleared
         */
        //defining submit button properties
        submit.setOnAction(e ->{
            if ((wordToNumber.isAToZ(inputOne.getText())) && (wordToNumber.isAToZ(inputTwo.getText())) && (wordToNumber.isAToZ(inputThree.getText()))) {

                firstString = inputOne.getText();
                secondString = inputTwo.getText();
                thirdString = inputThree.getText();

                label1.setText("First String output: " + wordToNumber.convert(firstString));
                label2.setText("Second String output: " + wordToNumber.convert(secondString));
                label3.setText("Third String Output: " + wordToNumber.convert(thirdString));

                window.setScene(scene2);


            } else {
                label.setText("Invalid Character Was detected in the Field");
                inputOne.clear();
                inputTwo.clear();
                inputThree.clear();
            }
        });


        //creates the functionality of the go back button in scene 2
        goBack.setOnAction(e -> {
            window.setScene(scene);
            label.setText("");
        });


        window.setScene(scene);
        window.show();




    }
}


