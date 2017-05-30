package game.buttons;

import game.GameField;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import static game.Constants.BUTTON_HEIGHT;
import static game.Constants.BUTTON_WIDTH;
import static game.GameField.timer;
import static game.Main.*;

public class RestartButton extends Button {
    public RestartButton(final double x, final double y) {
        super(new Image("/buttons/restart.png"),
                new Image("/buttons/restart1.png"),
                new Image("/buttons/restart2.png"), x, y);
        setFitWidth(BUTTON_WIDTH);
        setFitHeight(BUTTON_HEIGHT);
        setOnMouseClicked(event -> {
            gameField = new GameField();
            Scene scene = new Scene(gameField);
            scene.setOnKeyPressed(e -> keys.put(e.getCode(), true));
            scene.setOnKeyReleased(e -> keys.put(e.getCode(), false));
            stage.setScene(scene);
            timer.start();
        });
    }
}
