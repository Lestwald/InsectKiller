package game.buttons;

import javafx.scene.image.Image;

import static game.Constants.BUTTON_HEIGHT;
import static game.Constants.BUTTON_WIDTH;

public class ExitButton extends Button {
    public ExitButton(final double x, final double y) {
        super(new Image("/buttons/exit.png"),
                new Image("/buttons/exit1.png"),
                new Image("/buttons/exit2.png"), x, y);
        setFitWidth(BUTTON_WIDTH);
        setFitHeight(BUTTON_HEIGHT);
        setOnMouseClicked(event -> System.exit(0));
    }
}
