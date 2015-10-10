package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


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
        VBox mainVbox = new VBox();
        HBox hbox1=new HBox();
        HBox hbox2=new HBox();
        HBox hbox3 = new HBox();
        hbox1.setSpacing(10);
        hbox2.setSpacing(10);
        hbox3.setSpacing(10);


        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);

        VBox manVBox = new VBox();
        Image manImage = new Image("graphics/1_facet.png", true);
        ImageView manImageView = new ImageView();
        manImageView.setImage(manImage);
        manImageView.setSmooth(true);
        manImageView.setFitHeight(IconWidthHeight);
        manImageView.setFitWidth(IconWidthHeight);
        TextField manTextField = new TextField();
        manTextField.setPromptText("Liczba mężczyzn");
        manTextField.setAlignment(Pos.CENTER);
        manTextField.setPrefWidth(180);
        final Tooltip tooltip = new Tooltip();
        tooltip.setText("Podaj liczbę mężczyzn");
        manTextField.setTooltip(tooltip);


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
        manTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                try {
                    System.out.println(Integer.parseInt(t1));
                    manTextField.setStyle(manTextField.getStyle().concat("\n" + "-fx-text-inner-color: black;"));
                } catch(Exception e) {
                    System.out.println("Nieprawidłowa wartość!");
                    manTextField.setStyle(manTextField.getStyle().concat("\n" + "-fx-text-inner-color: red;"));
                }
            }
        });


        VBox womanVBox = new VBox();
        Image womanImage = new Image("graphics/1_kobieta.png", true);
        ImageView womanImageView = new ImageView();
        womanImageView.setImage(womanImage);
        womanImageView.setSmooth(true);
        womanImageView.setFitHeight(IconWidthHeight);
        womanImageView.setFitWidth(IconWidthHeight);
        TextField womanTextField = new TextField();
        womanTextField.setPromptText("Liczba kobiet");
        womanTextField.setAlignment(Pos.CENTER);
        womanTextField.setPrefWidth(180);
        womanVBox.getChildren().addAll(womanImageView, womanTextField);
        womanTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                try {
                    System.out.println(Integer.parseInt(t1));
                    womanTextField.setStyle(womanTextField.getStyle().concat("\n" + "-fx-text-inner-color: black;"));
                } catch (Exception e) {
                    System.out.println("Nieprawidłowa wartość!");
                    womanTextField.setStyle(womanTextField.getStyle().concat("\n" + "-fx-text-inner-color: red;"));
                }
            }
        });
        final Tooltip tooltip2 = new Tooltip();
        tooltip2.setText("Podaj liczbę kobiet");
        womanTextField.setTooltip(tooltip2);


        VBox clockVBox = new VBox();
        Image clockImage = new Image("graphics/3_zegar.png", true);
        ImageView clockImageView = new ImageView();
        clockImageView.setImage(clockImage);
        clockImageView.setSmooth(true);
        clockImageView.setFitHeight(IconWidthHeight);
        clockImageView.setFitWidth(IconWidthHeight);
        TextField clockTextField = new TextField();
        clockTextField.setPrefWidth(180);
        clockTextField.setPromptText("Czas trwania");
        clockTextField.setAlignment(Pos.CENTER);
        clockVBox.getChildren().addAll(clockImageView, clockTextField);
        clockTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                try {
                    System.out.println(Integer.parseInt(t1));
                    clockTextField.setStyle(clockTextField.getStyle().concat("\n" + "-fx-text-inner-color: black;"));
                } catch (Exception e) {
                    System.out.println("Nieprawidłowa wartość!");
                    clockTextField.setStyle(clockTextField.getStyle().concat("\n" + "-fx-text-inner-color: red;"));
                }
            }
        });
        final Tooltip tooltip3 = new Tooltip();
        tooltip3.setText("Podaj dugść czasu imprezy");
        clockTextField.setTooltip(tooltip3);

        VBox alcoholVBox = new VBox();
        Image alcoholImage = new Image("graphics/4_drinki.png", true);
        ImageView alcoholImageView = new ImageView();
        alcoholImageView.setImage(alcoholImage);
        alcoholImageView.setSmooth(true);
        alcoholImageView.setFitHeight( IconWidthHeight);
        alcoholImageView.setFitWidth( IconWidthHeight);
        /*
        TextField alcoholTextField = new TextField();
        alcoholTextField.setPromptText("Typ alkoholu");
        alcoholTextField.setAlignment(Pos.CENTER);
        alcoholVBox.getChildren().addAll(alcoholImageView, alcoholTextField);
        */
        final ComboBox alcohols = new ComboBox(FXCollections.observableArrayList("Piwo", "Wino", "Drinki", "Wódka"));
        alcohols.setPromptText("Typ alkoholu");
        alcoholVBox.getChildren().addAll(alcoholImageView, alcohols);
        alcohols.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                if (t1.equals("Piwo")) {
                    alcoholImageView.setImage(new Image("graphics/napoje_piwo.png", true));
                } else if (t1.equals("Wino")) {
                    alcoholImageView.setImage(new Image("graphics/napoje_wino.png", true));
                } else if (t1.equals("Drinki")) {
                    alcoholImageView.setImage(new Image("graphics/napoje_drinki.png", true));
                } else {
                    alcoholImageView.setImage(new Image("graphics/napoje_wodka.png", true));
                }

            }

            ;
        });
        alcoholVBox.setAlignment(Pos.TOP_CENTER);
        alcohols.setPrefWidth(180);

        VBox sobertyLevelVBox = new VBox();
        Image sobertyLevelImage = new Image("graphics/stopnie.png", true);
        ImageView sobertyLevelImageView = new ImageView();
        sobertyLevelImageView.setImage(sobertyLevelImage);
        sobertyLevelImageView.setSmooth(true);
        sobertyLevelImageView.setFitHeight( IconWidthHeight);
        sobertyLevelImageView.setFitWidth( IconWidthHeight);
        /*
        TextField sobertyLevelTextField = new TextField();
        sobertyLevelTextField.setPromptText("Rodzaj imprezy");
        sobertyLevelTextField.setAlignment(Pos.CENTER);
        sobertyLevelVBox.getChildren().addAll(sobertyLevelImageView,sobertyLevelTextField);
        */
        final ComboBox sobertyLevel = new ComboBox(FXCollections.observableArrayList("Kulturalna prywatka", "Klasyczna domówka", "Mordownia"));
        sobertyLevel.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                if (t1.equals("Kulturalna prywatka")) {
                    sobertyLevelImageView.setImage(new Image("graphics/stopien_1_hipster.png", true));
                } else if (t1.equals("Mordownia")) {
                    sobertyLevelImageView.setImage(new Image("graphics/stopien_3_swinia.png", true));
                } else {
                    sobertyLevelImageView.setImage(new Image("graphics/stopien_2_luzak.png", true));
                }

            }

            ;
        });
        sobertyLevelVBox.getChildren().addAll(sobertyLevelImageView, sobertyLevel);
        sobertyLevel.setPromptText("Rodzaj imprezy");
        sobertyLevelVBox.setAlignment(Pos.TOP_CENTER);
        sobertyLevel.setPrefWidth(180);

        VBox moneyVBox = new VBox();
        Image moneyImage = new Image("graphics/5_kasa.png", true);
        ImageView moneyImageView = new ImageView();
        moneyImageView.setImage(moneyImage);
        moneyImageView.setSmooth(true);
        moneyImageView.setFitHeight(IconWidthHeight);
        moneyImageView.setFitWidth(IconWidthHeight);
        TextField moneyTextField = new TextField();
        moneyTextField.setPromptText("Dostępne fundusze");
        moneyTextField.setAlignment(Pos.CENTER);
        moneyTextField.setPrefWidth(180);

        moneyVBox.getChildren().addAll(moneyImageView, moneyTextField);
        moneyTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                try {
                    System.out.println(Integer.parseInt(t1));
                    moneyTextField.setStyle(moneyTextField.getStyle().concat("\n" + "-fx-text-inner-color: black;"));
                } catch (Exception e) {
                    System.out.println("Nieprawidłowa wartość!");
                    moneyTextField.setStyle(moneyTextField.getStyle().concat("\n" + "-fx-text-inner-color: red;"));
                }
            }
        });
        final Tooltip tooltip4 = new Tooltip();
        tooltip4.setText("Ile masz dostępnych funduszy");
        moneyTextField.setTooltip(tooltip4);

        ArrayList<TextField> tfs = new ArrayList<>();
        tfs.add(moneyTextField);
        tfs.add(clockTextField);
        tfs.add(womanTextField);
        tfs.add(manTextField);

        EventHandler keyEvent = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {

                    if (((TextField) ke.getSource()).getCharacters().toString().equals("")) {
                        ((TextField) ke.getSource()).requestFocus();
                    } else {
                        boolean anyEmpty = false;
                        for(TextField t : tfs){
                            if(t.getCharacters().toString().equals("")){
                                anyEmpty = true;
                                t.requestFocus();
                            }
                        }
                        if(anyEmpty == false) {
                            //uruchomieni aplikacji
                            CountingModule cm = new CountingModule();
                            cm.setTime(Integer.parseInt(clockTextField.getText()));
                            cm.setPrefferedPrice(Integer.parseInt(moneyTextField.getText()));
                            cm.setNumberOfWomen(Integer.parseInt(womanTextField.getText()));
                            cm.setNumberOfMen(Integer.parseInt(manTextField.getText()));
                            cm.setTypeOfParty(sobertyLevel.getValue().toString());
                            cm.setTypeOfAlcochol(alcohols.getValue().toString());
                            cm.countLiters();
                            cm.price();
                            cm.comparePrices();
                            System.out.println(cm.getLiters());
                            System.out.println(cm.getPrice());
                        }
                    }
                }
            }
        };

        manTextField.setOnKeyPressed(keyEvent);
        womanTextField.setOnKeyPressed(keyEvent);
        clockTextField.setOnKeyPressed(keyEvent);
        moneyTextField.setOnKeyPressed(keyEvent);

        ImageView buttonView = new ImageView(new Image(getClass().getResourceAsStream("icon_small.png")));
        buttonView.fitHeightProperty();
        Button button = new Button("Oblicz", buttonView);
        button.setStyle("-fx-font: 22 arial; -fx-base: lightgreen;"); //
        button.setPrefWidth(200);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icon_small.png"))));

        alert.setTitle("Wyniki");
        alert.setHeaderText("Look, a Warning Dialog");
        alert.setContentText("Careful with the next step!");
        Stage alert1 = (Stage) alert.getDialogPane().getScene().getWindow();
        alert1.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                alert.showAndWait();
            }
        });

        hbox1.getChildren().addAll(manVBox, womanVBox,clockVBox);
        hbox2.getChildren().addAll(alcoholVBox,sobertyLevelVBox,moneyVBox);
        hbox3.getChildren().addAll(button);


        //bardzo nieprzyjemna metoda zmienienia marginu dla wszystkich Vboxów naraz.
        for (int i = 0; i <hbox1.getChildren().size() ; i++) {
            hbox1.setMargin(hbox1.getChildren().get(i),new Insets(200,0,0,0)); //tutaj są wartości marginesó
            hbox2.setMargin(hbox1.getChildren().get(i),new Insets(0,0,10,0)); //tutaj są wartości marginesów


            ((VBox)hbox1.getChildren().get(i)).setSpacing(10);
            ((VBox)hbox2.getChildren().get(i)).setSpacing(10);
        }
        hbox3.setMargin(hbox3.getChildren().get(0),new Insets(30, 0, 0, 0));
        HBox hbox0 = new HBox();
        hbox0.setMinHeight(20);
        mainVbox.getChildren().addAll(hbox0,hbox1,hbox2, hbox3);
        Scene scene = new Scene(mainVbox, 700, 600);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
