package game.gameobjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static game.Constants.PIZZA_HEIGHT;
import static game.Constants.PIZZA_WIDTH;

public class PieceOfPizza extends ImageView {
    public PieceOfPizza(final double x, final double y, final double rotate) {
        setImage(new Image("/pizza.png"));
        setFitWidth(PIZZA_WIDTH);
        setFitHeight(PIZZA_HEIGHT);
        setTranslateX(x);
        setTranslateY(y);
        setRotate(rotate);
    }
}
