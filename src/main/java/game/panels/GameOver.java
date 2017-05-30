package game.panels;

import game.buttons.ExitButton;
import game.buttons.RestartButton;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static game.Constants.WINDOW_HEIGHT;
import static game.Constants.WINDOW_WIDTH;

public class GameOver extends Pane {
    private Label score;

    public GameOver(final int s) {
        ImageView bg = new ImageView(new Image("/gameover.png"));
        bg.setFitWidth(WINDOW_WIDTH);
        bg.setFitHeight(WINDOW_HEIGHT);
        score(s);
        RestartButton restart = new RestartButton(50, 430);
        ExitButton exit = new ExitButton(420, 430);
        getChildren().addAll(bg, restart, exit, score);
    }

    private void score(final int s) {
        score = new Label("Score: " + s);
        score.setFont(new Font("Insektofobiya", 65));
        score.setTextFill(Color.valueOf("#ee5f41"));
        score.setTranslateX(220);
        score.setTranslateY(300);
    }
}