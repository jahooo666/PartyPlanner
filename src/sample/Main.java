package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    Stage window;
    BorderPane layout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Party Planner");

        HBox hbox=new HBox();
        Image manImage = new Image("graphics/1_facet.png", true);
        ImageView manImageView = new ImageView();
        manImageView.setImage(manImage);
        manImageView.setSmooth(true);
        manImageView.setFitHeight(250);
        manImageView.setFitWidth(250);


        Image womanImage = new Image("graphics/1_kobieta.png", true);
        ImageView womanImageView = new ImageView();
        womanImageView.setImage(womanImage);
        womanImageView.setSmooth(true);
        womanImageView.setFitHeight(250);
        womanImageView.setFitWidth(250);

        hbox.getChildren().addAll(manImageView, womanImageView);



        Scene scene = new Scene(hbox,1000, 600);
        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
