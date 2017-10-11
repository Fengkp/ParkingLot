//package App;
//
//import javafx.event.ActionEvent;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//
//public class CheckWindow extends App {
//
//    Scene mainScene;
//
//    public Scene getCheckWindow() {
//        Button btnCheckIn;
//        Button btnCheckOut;
//
//        btnCheckIn = new Button("Check-in");
//        btnCheckIn.setPrefSize(250, 100);
//        btnCheckIn.setOnAction((ActionEvent e) -> {
//            mainScene = new SpotWindow().getSpotWindowScene();
//            return mainScene;
//        });
//        btnCheckOut = new Button("Check-out");
//        btnCheckOut.setPrefSize(250, 100);
//
//        HBox checkBtnHBox = new HBox();
//        checkBtnHBox.setAlignment(Pos.CENTER);
//        checkBtnHBox.setSpacing(50);
//        checkBtnHBox.getChildren().addAll(btnCheckIn, btnCheckOut);
//
//        BorderPane mainBorderPane = new BorderPane();
//        mainBorderPane.setCenter(checkBtnHBox);
//        mainScene = new Scene(mainBorderPane, 1280, 720);
//
//        return mainScene;
//    }
//}
