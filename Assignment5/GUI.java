package com.bham.pij.assignments.edgedetector;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.event.TreeModelEvent;
import java.io.File;
public class GUI extends Application{
    VBox root = new VBox();
    ImageView imageView = null;
    ImageView filteredImage = null;
    @Override
    public void start(Stage stage) {
        stage.setTitle("Image Filter GUI");
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem closeItem = new MenuItem("Close");
        closeItem.setDisable(true);
        fileMenu.getItems().addAll(openItem, closeItem);
        Menu toolMenu = new Menu("Tools");
        MenuItem filterItem = new MenuItem("Edge Detection");
        MenuItem revertItem = new MenuItem("Revert");
        filterItem.setDisable(true);
        revertItem.setDisable(true);
        toolMenu.getItems().addAll(filterItem, revertItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(toolMenu);
        root.getChildren().add(menuBar);
        openItem.setOnAction(new EventHandler<ActionEvent>() {

            private void loadImageFile(File file) {
                Image image = new Image("file:" + file.getPath());
                imageView = new ImageView(image);
                root.getChildren().add(imageView);
            }
            @Override
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Image File");
                File file =fileChooser.showOpenDialog(stage);
                if (file != null) {
                    loadImageFile(file);
                }
                if(imageView!=null) {
                	openItem.setDisable(true);
                    filterItem.setDisable(false);
                    closeItem.setDisable(false);
                }
            }
        });


        filterItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                EdgeDetector edgeDetector = new EdgeDetector();
                Image newImage = edgeDetector.filterImage(imageView.getImage());
                filteredImage = new ImageView(newImage);
                filterItem.setDisable(true);
                revertItem.setDisable(false);
                closeItem.setDisable(true);
                root.getChildren().remove(imageView);
                root.getChildren().add(filteredImage);

            }
        });

        revertItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            root.getChildren().remove(filteredImage);
            root.getChildren().add(imageView);
            filteredImage = null;
            revertItem.setDisable(true);
            filterItem.setDisable(false);
            closeItem.setDisable(false);
            }
        });
        closeItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (imageView != null) {
                    root.getChildren().remove(imageView);
                    imageView = null;
                }
                closeItem.setDisable(true);
                openItem.setDisable(false);
            }
        });
        System.out.println();

        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
