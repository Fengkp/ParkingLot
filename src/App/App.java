package App;

import ParkingLot.*;
import Vehicle.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.converter.IntegerStringConverter;

import java.text.ParsePosition;
import java.util.function.UnaryOperator;

public class App extends Application {

    public static void main(String[] args) {
            launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ParkingLot mainLot = new ParkingLot();
        primaryStage.setTitle("Parking Lot");

        // SpotWindow Scene
        Scene spotScene;
        Button btnSpaceNumEnter;

//        Number Pad Test
//        String[] numKeys = {"1", "2", "3",
//                "4", "5", "6",
//                "7", "8", "9",
//                "Del.", "0", "Enter"};
//
//        GridPane numPadGridPane = new GridPane();
//        for (int i = 0; i < 12; i++) {
//            Button btnNum = new Button(numKeys[i]);
//            btnNum.setPrefSize(50, 50);
//            numPadGridPane.add(btnNum, i % 3, (int)Math.ceil(i / 3));
//        }
//        numPadGridPane.setAlignment(Pos.CENTER);


        TextField spaceNumTF = new TextField();
        UnaryOperator<TextFormatter.Change> intFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?"))
                return change;
            return null;
        };
        spaceNumTF.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0, intFilter));
        btnSpaceNumEnter = new Button("Enter");
        btnSpaceNumEnter.setOnAction(e -> {
            int spaceNumInput = Integer.parseInt(spaceNumTF.getText());
            spaceIsValid(spaceNumInput, mainLot.getTotalSpaces());
        });

        BorderPane spotBorderPane = new BorderPane();
        spotBorderPane.setCenter();
        spotScene = new Scene(spotBorderPane, 1280, 720);


        // MainWindow Scene
        Scene mainScene;
        Button btnCheckIn;
        Button btnCheckOut;

        btnCheckIn = new Button("Check-in");
        btnCheckIn.setPrefSize(250, 100);
        btnCheckIn.setOnAction((ActionEvent e) -> primaryStage.setScene(spotScene));
        btnCheckOut = new Button("Check-out");
        btnCheckOut.setPrefSize(250, 100);

        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(50);
        buttonHBox.getChildren().addAll(btnCheckIn, btnCheckOut);

        BorderPane mainBorderPane = new BorderPane();
        mainBorderPane.setCenter(buttonHBox);
        mainScene = new Scene(mainBorderPane, 1280, 720);


        // First Run
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public boolean spaceIsValid(int num, int max) {
        boolean isValid = false;

        if (num > max || num < 1)
            return isValid;
    }

}
