package game.buttons;

import javafx.scene.Scene;
import javafx.scene.image.Image;

import static game.Constants.BUTTON_HEIGHT;
import static game.Constants.BUTTON_WIDTH;
import static game.GameField.timer;
import static game.Main.*;

public class StartButton extends Button {
    public StartButton(final double x, final double y) {
        super(new Image("/buttons/start.png"),
                new Image("/buttons/start1.png"),
                new Image("/buttons/start2.png"), x, y);
        setFitWidth(BUTTON_WIDTH);
        setFitHeight(BUTTON_HEIGHT);
        setOnMouseClicked(event -> {
            Scene scene = new Scene(gameField);
            scene.setOnKeyPressed(e -> keys.put(e.getCode(), true));
            scene.setOnKeyReleased(e -> keys.put(e.getCode(), false));
            stage.setScene(scene);
            timer.start();
        });
    }
}
