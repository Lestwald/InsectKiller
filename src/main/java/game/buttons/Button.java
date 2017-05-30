package game.buttons;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Button extends ImageView {
    private final Image regular;
    private final Image entered;
    private final Image pressed;

    Button(final Image r, final Image e, final Image p, final double x, final double y) {
        regular = r;
        entered = e;
        pressed = p;
        setTranslateX(x);
        setTranslateY(y);
        setImage(regular);
        setCursor(Cursor.HAND);
        setOnMouseEntered(event -> setImage(entered));
        setOnMouseExited(event -> setImage(regular));
        setOnMousePressed(event -> setImage(pressed));
    }
}
