package game;

import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {
    private final ImageView imageView;
    private final int count;
    private final int width;
    private final int height;

    public SpriteAnimation(final Duration duration, final ImageView iv, final int c, final int w, final int h) {
        imageView = iv;
        count = c;
        width = w;
        height = h;
        setCycleDuration(duration);
    }

    protected void interpolate(final double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        final int x = index * width;
        imageView.setViewport(new Rectangle2D(x, 0, width, height));
    }
}
