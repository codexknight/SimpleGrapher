package org.example;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private TextField functionInput;

    private Label message;

    private GraphCanvas graph;



    @Override
    public void start(Stage stage) {


        graph = new GraphCanvas(new Expr("sin(x)*3 + cos(5*x)"));

        message = new Label("Enter a function and click Enter or press return");

        functionInput = new TextField("sin(x)*3 + cos(5*x)");

        Button graphIt = new Button("Enter");
        graphIt.setDefaultButton(true);


        HBox bottom = new HBox(8, new Label("f(x) ="), functionInput, graphIt);

        BorderPane root = new BorderPane();

        root.setCenter(graph);
        root.setTop(message);
        root.setBottom(bottom);

        root.setStyle("-fx-border-color:gray; -fx-border-width:4px");
        message.setTextFill(Color.RED);
        message.setStyle("-fx-background-color:white; -fx-padding:7px; "
                + "-fx-border-color:gray; -fx-border-width:0 0 4px 0");
        message.setMaxWidth(10000);
        bottom.setStyle("-fx-border-color:gray; -fx-border-width:4px 0 0 0; -fx-padding:8px");
        HBox.setHgrow(functionInput, Priority.ALWAYS);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("A Simple Function Grapher");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static class GraphCanvas extends Canvas {

        Expr func;

        GraphCanvas(Expr firstFunction) {
            super(600, 600);
            func = firstFunction;
            draw();
        }

        private void draw() {
            GraphicsContext g = getGraphicsContext2D();
            g.setFill(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            if (func == null) {
                g.setFill(Color.RED);
                g.fillText("No function is available.", 30, 40);
            } else {
                g.setFill(Color.PURPLE);
                g.fillText("y = ", 5, 15);
                drawAxes(g);
                drawFunction(g);
            }
        }

        private void drawFunction(GraphicsContext g) {
        }

        private void drawAxes(GraphicsContext g) {
        }

    }


}