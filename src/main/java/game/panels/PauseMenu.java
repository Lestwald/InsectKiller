package game.panels;

import game.buttons.ExitButton;
import game.buttons.RestartButton;
import game.buttons.ResumeButton;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PauseMenu extends Pane {
    public PauseMenu() {
        setCursor(Cursor.DEFAULT);
        Label text = new Label("Pause");
        text.setFont(new Font("Insektofobiya", 94));
        text.setTextFill(Color.valueOf("#ee5f41"));
        text.setTranslateX(250);
        text.setTranslateY(40);
        ResumeButton resume = new ResumeButton(235, 170);
        RestartButton restart = new RestartButton(235, 300);
        ExitButton exit = new ExitButton(235, 430);
        setPrefSize(800, 600);
        setStyle("-fx-background-color: #2d2d2d");
        getChildren().addAll(text, resume, restart, exit);
    }
}
