package game.buttons;

import javafx.scene.image.Image;

import static game.Constants.BUTTON_HEIGHT;
import static game.Constants.BUTTON_WIDTH;
import static game.GameField.timer;
import static game.Main.gameField;

public class ResumeButton extends Button {
    public ResumeButton(final double x, final double y) {
        super(new Image("/buttons/resume.png"),
                new Image("/buttons/resume1.png"),
                new Image("/buttons/resume2.png"), x, y);
        setFitWidth(BUTTON_WIDTH);
        setFitHeight(BUTTON_HEIGHT);
        setOnMouseClicked(event -> {
            timer.start();
            gameField.getChildren().remove(gameField.getChildren().size() - 1);
        });
    }
}
