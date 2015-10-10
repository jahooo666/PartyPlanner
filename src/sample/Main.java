package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
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
    final int IconWidthHeight= 200;
    final int margin=10;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Party Planner");
        window.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));

        HBox hbox=new HBox();
        hbox.setSpacing(10);

        hbox.setAlignment(Pos.CENTER);
        VBox manVBox = new VBox();
        Image manImage = new Image("graphics/1_facet.png", true);
        ImageView manImageView = new ImageView();
        manImageView.setImage(manImage);
        manImageView.setSmooth(true);
        manImageView.setFitHeight( IconWidthHeight);
        manImageView.setFitWidth( IconWidthHeight);
        TextField manTextField = new TextField();
        manTextField.setPromptText("Liczba mężczyzn");
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

        VBox alcoholVBox = new VBox();
        Image alcoholImage = new Image("graphics/4_drinki.png", true);
        ImageView alcoholImageView = new ImageView();
        alcoholImageView.setImage(alcoholImage);
        alcoholImageView.setSmooth(true);
        alcoholImageView.setFitHeight( IconWidthHeight);
        alcoholImageView.setFitWidth( IconWidthHeight);
        TextField alcoholTextField = new TextField();
        alcoholTextField.setPromptText("Typ alkoholu");
        alcoholTextField.setAlignment(Pos.CENTER);
        alcoholVBox.getChildren().addAll(alcoholImageView,alcoholTextField);

        VBox sobertyLevelVBox = new VBox();
        Image sobertyLevelImage = new Image("graphics/stopien_1_hipster.png", true);
        ImageView sobertyLevelImageView = new ImageView();
        sobertyLevelImageView.setImage(sobertyLevelImage);
        sobertyLevelImageView.setSmooth(true);
        sobertyLevelImageView.setFitHeight( IconWidthHeight);
        sobertyLevelImageView.setFitWidth( IconWidthHeight);
        TextField sobertyLevelTextField = new TextField();
        sobertyLevelTextField.setPromptText("Rodzaj imprezy");
        sobertyLevelTextField.setAlignment(Pos.CENTER);
        sobertyLevelVBox.getChildren().addAll(sobertyLevelImageView,sobertyLevelTextField);
        VBox moneyVBox = new VBox();
        Image moneyImage = new Image("graphics/5_kasa.png", true);
        ImageView moneyImageView = new ImageView();
        moneyImageView.setImage(moneyImage);
        moneyImageView.setSmooth(true);
        moneyImageView.setFitHeight( IconWidthHeight);
        moneyImageView.setFitWidth(IconWidthHeight);
        TextField moneyTextField = new TextField();
        moneyTextField.setPromptText("Dostępne fundusze");
        moneyTextField.setAlignment(Pos.CENTER);
        moneyVBox.getChildren().addAll(moneyImageView,moneyTextField);
        
        hbox.getChildren().addAll(manVBox, womanVBox,clockVBox,alcoholVBox,sobertyLevelVBox,moneyVBox);


        //bardzo nieprzyjemna metoda zmienienia marginu dla wszystkich Vboxów naraz.
        for (int i = 0; i <hbox.getChildren().size() ; i++) {
            hbox.setMargin(hbox.getChildren().get(i),new Insets(10,0,0,0)); //tutaj są wartości marginesów
            ((VBox)hbox.getChildren().get(i)).setSpacing(10);
        }
        Scene scene = new Scene(hbox,1300, 600);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
