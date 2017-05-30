package game.gameobjects;

import game.AddGameObject;
import game.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import static game.Constants.*;
import static game.Main.gameField;

public class Enemy extends ImageView {
    private final Type type;
    private Point2D velocity = new Point2D(0, 0);
    private boolean alive = true;
    private double speed = ENEMY_INITIAL_SPEED;
    private double lifetime = ENEMY_LIFETIME;

    public Enemy(final Type t) {
        type = t;
        Animation animation;
        if (type == Type.BEE) {
            setImage(new Image("/insects/bee.png"));
            setViewport(new Rectangle2D(0, 0, 83, 100));
            animation = new SpriteAnimation(Duration.millis(500), this, 4, 83, 100);
        } else if (type == Type.BUG) {
            setImage(new Image("/insects/bug.png"));
            setViewport(new Rectangle2D(0, 0, 101, 100));
            animation = new SpriteAnimation(Duration.millis(500), this, 4, 101, 100);
        } else {
            setImage(new Image("/insects/fly.png"));
            setViewport(new Rectangle2D(0, 0, 108, 100));
            animation = new SpriteAnimation(Duration.millis(500), this, 4, 108, 100);
        }
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        setFitWidth(ENEMY_SIZE);
        setFitHeight(ENEMY_SIZE);
        setOnMouseClicked(event -> {
            if (gameField.getWeaponPanel().getActiveWeapon().getType().equals(type)) {
                setDead();
                if (Math.random() < 0.2)
                    AddGameObject.addCoin(getTranslateX(), getTranslateY(), gameField, gameField.getCoins());
                gameField.setScore(gameField.getScore() + 10);
                gameField.getChildren().remove(this);
            } else gameField.setScore(gameField.getScore() - 10);
        });
    }

    public void update() {
        setTranslateX(getTranslateX() + velocity.multiply(speed).getX());
        setTranslateY(getTranslateY() + velocity.multiply(speed).getY());
        setRotate(180 - Math.atan2(velocity.getX(), velocity.getY()) * 180 / Math.PI);
        lifetime -= 1;
        if (lifetime <= 0) setDead();
    }

    public Point2D getVelocity() {
        return velocity;
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isDead() {
        return !alive;
    }

    private void setDead() {
        alive = false;
    }
}
