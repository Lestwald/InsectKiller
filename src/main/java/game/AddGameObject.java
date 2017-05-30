package game;

import game.gameobjects.Coin;
import game.gameobjects.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

import static game.Constants.*;

public class AddGameObject {
    static public void addEnemy(final double speed, final Pane root, final List<Enemy> enemies) {
        final Enemy enemy = randomEnemy();
        final double radius = Math.sqrt(Math.pow(WINDOW_WIDTH / 2, 2) + Math.pow(WINDOW_HEIGHT / 2, 2));
        final double x = WINDOW_WIDTH / 2 - radius + Math.random() * 2 * radius;
        final double y = Math.pow(-1, new Random().nextInt(2) + 1) *
                Math.sqrt(Math.pow(radius, 2) - Math.pow((x - WINDOW_WIDTH / 2), 2)) + WINDOW_HEIGHT / 2;
        enemies.add(enemy);
        enemy.setTranslateX(x);
        enemy.setTranslateY(y);
        enemy.setSpeed(speed);
        enemy.setVelocity(new Point2D(GAMEFIELD_CENTER_X - x - 50, GAMEFIELD_CENTER_Y - y).normalize());
        root.getChildren().add(enemy);
    }

    static public void addCoin(final double x, final double y, final Pane root, final List<Coin> coins) {
        Coin coin = randomCoin();
        coins.add(coin);
        coin.setTranslateX(x);
        coin.setTranslateY(y);
        root.getChildren().add(coin);
    }

    static private Enemy randomEnemy() {
        if (Math.random() < 0.333) return new Enemy(Type.BEE);
        else if (Math.random() < 0.666) return new Enemy(Type.BUG);
        else return new Enemy(Type.FLY);
    }

    static private Coin randomCoin() {
        if (Math.random() < 0.333) return new Coin(10);
        else if (Math.random() < 0.666) return new Coin(20);
        else return new Coin(50);
    }
}
