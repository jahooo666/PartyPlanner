package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
    Stage window;
    BorderPane layout;
    final int IconWidthHeight= 220;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Party Planner");
        window.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));

        HBox hbox=new HBox();

        VBox manVBox = new VBox();
        Image manImage = new Image("graphics/1_facet.png", true);
        ImageView manImageView = new ImageView();
        manImageView.setImage(manImage);
        manImageView.setSmooth(true);
        manImageView.setFitHeight( IconWidthHeight);
        manImageView.setFitWidth( IconWidthHeight);
        TextField manTextField = new TextField();
        manTextField.setPromptText("Liczba mê¿czyzn");
        manTextField.setAlignment(Pos.CENTER);

        /*        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3"
                );
        final ComboBox comboBox = new ComboBox(options);
        */
        manVBox.getChildren().addAll(manImageView,manTextField);
        manVBox.setAlignment(Pos.TOP_CENTER);


        VBox womanVBox = new VBox();
        Image womanImage = new Image("graphics/1_kobieta.png", true);
        ImageView womanImageView = new ImageView();
        womanImageView.setImage(womanImage);
        womanImageView.setSmooth(true);
        womanImageView.setFitHeight( IconWidthHeight);
        womanImageView.setFitWidth( IconWidthHeight);
        TextField womanTextField = new TextField();
        womanTextField.setPromptText("Liczba kobiet");
        womanTextField.setAlignment(Pos.CENTER);
        womanVBox.getChildren().addAll(womanImageView,womanTextField);


        VBox clockVBox = new VBox();
        Image clockImage = new Image("graphics/3_zegar.png", true);
        ImageView clockImageView = new ImageView();
        clockImageView.setImage(clockImage);
        clockImageView.setSmooth(true);
        clockImageView.setFitHeight( IconWidthHeight);
        clockImageView.setFitWidth( IconWidthHeight);
        TextField clockTextField = new TextField();
        clockTextField.setPromptText("Czas trwania");
        clockTextField.setAlignment(Pos.CENTER);
        clockVBox.getChildren().addAll(clockImageView,clockTextField);
        
        
        
        
        

        hbox.getChildren().addAll(manVBox, womanVBox,clockVBox);



        Scene scene = new Scene(hbox,1200, 600);
        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
