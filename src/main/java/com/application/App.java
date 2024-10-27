package com.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private double xOffset = 0;
    private double yOffset = 0;
    private boolean moving = false;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu"), 768, 600);
        stage.setTitle("Bibli Sapien");
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        scene.setOnMousePressed(event -> {
            if (event.getY() < 40) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
                moving = true;
            }
        });

        scene.setOnMouseDragged(event -> {
            if (moving) {
                double targetX = event.getScreenX() - xOffset;
                double targetY = event.getScreenY() - yOffset;
                stage.setX(stage.getX() + (targetX - stage.getX()) * 0.1);
                stage.setY(stage.getY() + (targetY - stage.getY()) * 0.1);
            }
        });

        scene.setOnMouseReleased(event -> {
            moving = false;
        });

        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}