//package App;
//
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.control.TextFormatter;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.util.converter.IntegerStringConverter;
//
//import java.util.function.UnaryOperator;
//
//public class SpotWindow extends App {
//
//    Scene spotScene;
//
//    public Scene getSpotWindowScene() {
//        Button btnSpaceNumEnter;
//
////        Number Pad Test
////        String[] numKeys = {"1", "2", "3",
////                "4", "5", "6",
////                "7", "8", "9",
////                "Del.", "0", "Enter"};
////
////        GridPane numPadGridPane = new GridPane();
////        for (int i = 0; i < 12; i++) {
////            Button btnNum = new Button(numKeys[i]);
////            btnNum.setPrefSize(50, 50);
////            numPadGridPane.add(btnNum, i % 3, (int)Math.ceil(i / 3));
////        }
////        numPadGridPane.setAlignment(Pos.CENTER);
//
//
//        TextField spaceNumTF = new TextField();
//        UnaryOperator<TextFormatter.Change> intFilter = change -> {
//            String newText = change.getControlNewText();
//            if (newText.matches("-?([1-9][0-9]*)?"))
//                return change;
//            return null;
//        };
//        spaceNumTF.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0, intFilter));
//        btnSpaceNumEnter = new Button("Enter");
//        btnSpaceNumEnter.setOnAction(e -> {
//            int spaceNumInput = Integer.parseInt(spaceNumTF.getText());
//            //spaceIsValid(spaceNumInput, super.mainLot.getTotalSpaces());
//        });
//        HBox spotNumHBox = new HBox();
//        spotNumHBox.setAlignment(Pos.CENTER);
//        spotNumHBox.getChildren().addAll(spaceNumTF, btnSpaceNumEnter);
//
//        BorderPane spotBorderPane = new BorderPane();
//        spotBorderPane.setBottom(spotNumHBox);
//        spotScene = new Scene(spotBorderPane, 1280, 720);
//
//        return spotScene;
//    }
//
//    public boolean spaceIsValid(int num, int max, String spaceType, String vehicleType) {
//        if (num > max || num < 1)
//            return false;
//        if (!spaceType.equals(vehicleType))
//            return false;
//        return true;
//    }
//}
