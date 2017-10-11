package App;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {

    public static void display(String message) {
        Stage alertStage = new Stage();
        Scene alertScene;

        VBox alertVBox = new VBox();
        alertVBox.setSpacing(20);
        alertVBox.setAlignment(Pos.CENTER);

        Button btnClose = new Button("Close");
        btnClose.setOnAction(e -> alertStage.close());

        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.setTitle("Error");
        alertStage.setWidth(400);
        alertStage.setHeight(150);

        Label lblMessage = new Label();
        lblMessage.setText(message);

        alertVBox.getChildren().addAll(lblMessage, btnClose);
        alertScene = new Scene(alertVBox);
        alertStage.setScene(alertScene);
        alertStage.showAndWait();
    }
}
