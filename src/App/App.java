package App;

import ParkingLot.*;
import Vehicle.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

import java.util.Calendar;
import java.util.function.UnaryOperator;

public class App extends Application {

    ParkingLot mainLot = new ParkingLot();
    int vehicleSize;
    int duration = 1;
    int spaceNumInput;
    Calendar cal = Calendar.getInstance();
    String licensePlateID;
    String vehicleColor;

    Scene receptionWindow;
    Scene payInfoWindow;
    Scene durationWindow;
    Scene spotWindow;
    Scene retrieveVehicleWindow;

    public static void main(String[] args) {
            launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Parking Lot");


        // RetrieveVehicleWindow Scene
        VBox retrievalVBox = new VBox();
        Label lblPlateRetrievalTitle = new Label("Enter License Plate Number to check-out your vehicle");
        TextField plateRetrievalTF = new TextField();
        Button btnRetrieve = new Button("Retrieve Vehicle");
        btnRetrieve.setOnAction(e -> {
            if (mainLot.hasVehicle(plateRetrievalTF.getText())) {
                mainLot.makeSpaceAvailable(plateRetrievalTF.getText());
                primaryStage.setScene(receptionWindow);
            }
            else
                AlertWindow.display("Vehicle Not Found. Make sure you entered everything correctly!");
        });

        retrievalVBox.getChildren().addAll(lblPlateRetrievalTitle, plateRetrievalTF, btnRetrieve);
        retrieveVehicleWindow = new Scene(retrievalVBox, 1280, 720);


        // PaymentInfoWindow Scene
        VBox payInfoVBox = new VBox();
        payInfoVBox.setAlignment(Pos.CENTER);

        Label lblLicensePlateTitle = new Label("Enter License Plate Number");
        TextField licensePlateTF = new TextField();
        Label lblVehicleColorTitle = new Label("Enter your Vehicles Color");
        TextField vehicleColorTF = new TextField();
        Button btnSubmit = new Button("Submit & Pay");
        btnSubmit.setOnAction(e -> {
            licensePlateID = licensePlateTF.getText();
            vehicleColor = vehicleColorTF.getText();
            if (vehicleSize < 2)
                mainLot.occupySpace(new Motorcycle(licensePlateID, vehicleColor), spaceNumInput);
            primaryStage.setScene(receptionWindow);
        });
        payInfoVBox.getChildren().addAll(lblLicensePlateTitle, licensePlateTF, lblVehicleColorTitle, vehicleColorTF, btnSubmit);
        payInfoWindow = new Scene(payInfoVBox, 1280, 720);


        // DurationWindow Scene
        GridPane durationGridPane = new GridPane();
        durationGridPane.setAlignment(Pos.CENTER);
        durationGridPane.setVgap(10);
        durationGridPane.setHgap(20);
        Button btnPayment = new Button("Payment");
        btnPayment.setOnAction(e -> primaryStage.setScene(payInfoWindow));

        // Clock
        Label lblCurrentTimeTitle = new Label("Current Time");
        Label lblTime = new Label();
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            lblTime.setText(cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        Label lblReturnTimeTitle = new Label("Return Time");
        Label lblReturnTime = new Label((cal.get(Calendar.HOUR) + duration) + ":" + cal.get(Calendar.MINUTE));

        Label lblDuration = new Label(Integer.toString(duration) + ":00 HOURS");
        Button btnHourUp = new Button("+1 Hour");
        btnHourUp.setOnAction(e -> {
            if (duration < 12) {
                duration += 1;
                int hour = cal.get(Calendar.HOUR) + duration;
                int minute = cal.get(Calendar.MINUTE);
                lblDuration.setText(Integer.toString(duration) + ":00 HOURS");
                lblReturnTime.setText(Integer.toString(hour) + ":" + Integer.toString(minute));
            }
            else if (duration >= 12)
                AlertWindow.display("Maximum Parking Time exceeded");
        });
        Button btnHourDown = new Button("-1 Hour");
        btnHourDown.setOnAction(e -> {
            if (duration > 1) {
                duration -= 1;
                int hour = cal.get(Calendar.HOUR) + duration;
                int minute = cal.get(Calendar.MINUTE);
                lblDuration.setText(Integer.toString(duration) + ":00 HOURS");
                lblReturnTime.setText(Integer.toString(hour) + ":" + Integer.toString(minute));
            }
        });

        durationGridPane.add(btnHourUp, 0, 0);
        durationGridPane.add(btnHourDown, 0, 2);
        durationGridPane.add(lblDuration, 0, 1);
        durationGridPane.add(lblCurrentTimeTitle, 1, 0);
        durationGridPane.add(lblTime, 1, 1);
        durationGridPane.add(lblReturnTimeTitle, 2, 0);
        durationGridPane.add(lblReturnTime, 2, 1);
        durationGridPane.add(btnPayment, 3, 1);
        durationWindow = new Scene(durationGridPane, 1280, 720);


        // SpotWindow Scene
        VBox spotVBox = new VBox();
        spotVBox.setSpacing(20);
        spotVBox.setAlignment(Pos.CENTER);

        // Vehicle Layout
        Button btnMotorcycle = new Button("Motorcycle");
        btnMotorcycle.setPrefSize(100, 80);
        btnMotorcycle.setOnAction(e -> vehicleSize = 1);
        Button btnCar = new Button("Car");
        btnCar.setPrefSize(100, 80);
        btnCar.setOnAction(e -> vehicleSize = 2);
        Button btnBus = new Button("Bus");
        btnBus.setPrefSize(100, 80);
        btnBus.setOnAction(e -> vehicleSize = 4);

        HBox vehicleBtnHBox = new HBox();
        vehicleBtnHBox.setAlignment(Pos.CENTER);
        vehicleBtnHBox.setSpacing(30);
        vehicleBtnHBox.getChildren().addAll(btnMotorcycle, btnCar, btnBus);

        // Spot Layout
        Button btnSpaceNumEnter;

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
            spaceNumInput = Integer.parseInt(spaceNumTF.getText());
            if (spaceIsValid(spaceNumInput))
                primaryStage.setScene(durationWindow);
        });
        HBox spotNumHBox = new HBox();
        spotNumHBox.setAlignment(Pos.CENTER);
        spotNumHBox.setSpacing(20);
        spotNumHBox.getChildren().addAll(spaceNumTF, btnSpaceNumEnter);

        spotVBox.getChildren().addAll(vehicleBtnHBox, spotNumHBox);
        BorderPane spotBorderPane = new BorderPane();
        spotBorderPane.setCenter(spotVBox);
        spotWindow = new Scene(spotBorderPane, 1280, 720);


        // receptionWindow Scene
        Button btnCheckIn;
        Button btnCheckOut;

        btnCheckIn = new Button("Check-in");
        btnCheckIn.setPrefSize(250, 100);
        btnCheckIn.setOnAction(e -> primaryStage.setScene(spotWindow));
        btnCheckOut = new Button("Check-out");
        btnCheckOut.setPrefSize(250, 100);
        btnCheckOut.setOnAction(e -> primaryStage.setScene(retrieveVehicleWindow));

        HBox checkBtnHBox = new HBox();
        checkBtnHBox.setAlignment(Pos.CENTER);
        checkBtnHBox.setSpacing(50);
        checkBtnHBox.getChildren().addAll(btnCheckIn, btnCheckOut);

        BorderPane mainBorderPane = new BorderPane();
        mainBorderPane.setCenter(checkBtnHBox);
        receptionWindow = new Scene(mainBorderPane, 1280, 720);


        // First Run
        primaryStage.setScene(receptionWindow);
        primaryStage.show();
    }

    public boolean spaceIsValid(int num) {
        if (!mainLot.getSpace(num).getSpaceAvailable()) {
            AlertWindow.display("Space taken. \nPlease make sure you have the correct space number!");
            return false;
        }

        if (!mainLot.isValidSpaceNum(num)) {
            AlertWindow.display("Invalid Space. \nPlease make sure you have the correct space number!");
            return false;
        }

        int spaceSize = mainLot.getSpace(num).getSpaceSize();
        if (vehicleSize > spaceSize) {
            AlertWindow.display("Invalid Space. \nPlease make sure you are parked in the appropriate space!");
            return false;
        }

        return true;
    }

}
