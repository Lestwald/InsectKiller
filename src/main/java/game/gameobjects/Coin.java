package game.gameobjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static game.Constants.COIN_LIFETIME;
import static game.Constants.COIN_SIZE;
import static game.Main.gameField;

public class Coin extends ImageView {
    private final int denomination;
    private boolean alive = true;
    private double lifetime = COIN_LIFETIME;

    public Coin(final int d) {
        setImage(new Image("file:img/coin10.png"));
        denomination = d;
        if (denomination == 10) setImage(new Image("/coins/coin10.png"));
        if (denomination == 20) setImage(new Image("/coins/coin20.png"));
        if (denomination == 50) setImage(new Image("/coins/coin50.png"));
        setFitWidth(COIN_SIZE);
        setFitHeight(COIN_SIZE);
        setOnMouseClicked(event -> {
            setDead();
            gameField.setScore(gameField.getScore() + denomination);
            gameField.getChildren().remove(this);
        });
    }

    public void update() {
        lifetime -= 1;
        if (lifetime <= 0) {
            setDead();
            gameField.getChildren().remove(this);
        }
    }

    public boolean isDead() {
        return !alive;
    }

    private void setDead() {
        alive = false;
    }
}
