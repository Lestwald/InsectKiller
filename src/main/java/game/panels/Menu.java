package game.panels;

import game.buttons.ExitButton;
import game.buttons.StartButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import static game.Constants.*;

public class Menu extends Pane{
    public Menu () {
        ImageView bg = new ImageView(new Image("/main.png"));
        bg.setFitWidth(WINDOW_WIDTH);
        bg.setFitHeight(WINDOW_HEIGHT);
        StartButton start = new StartButton(50, 430);
        ExitButton exit = new ExitButton(420, 430);
        getChildren().addAll(bg, start, exit);
    }
}
