package game.buttons;

import game.panels.PauseMenu;
import javafx.scene.image.Image;

import static game.Constants.PAUSE_BUTTON_HEIGHT;
import static game.Constants.PAUSE_BUTTON_WIDTH;
import static game.GameField.timer;
import static game.Main.gameField;

public class PauseButton extends Button {
    public PauseButton(final double x, final double y) {
        super(new Image("/buttons/pause.png"),
                new Image("/buttons/pause1.png"),
                new Image("/buttons/pause2.png"), x, y);
        setFitWidth(PAUSE_BUTTON_WIDTH);
        setFitHeight(PAUSE_BUTTON_HEIGHT);
        setOnMouseClicked(event -> {
            timer.stop();
            gameField.getChildren().add(new PauseMenu());
        });
    }
}
