package game;

import game.buttons.PauseButton;
import game.gameobjects.Coin;
import game.gameobjects.Enemy;
import game.gameobjects.Pizza;
import game.panels.GameOver;
import game.panels.InformationPanel;
import game.panels.PauseMenu;
import game.panels.WeaponPanel;
import javafx.animation.AnimationTimer;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

import static game.AddGameObject.addEnemy;
import static game.Constants.*;

public class GameField extends Pane {
    public static AnimationTimer timer;
    private final Pizza pizza = new Pizza(GAMEFIELD_CENTER_X, GAMEFIELD_CENTER_Y - PIZZA_HEIGHT);
    private final InformationPanel informationPanel;
    private final WeaponPanel weaponPanel;
    private final PauseButton pauseButton;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Coin> coins = new ArrayList<>();
    private int score = 0;
    private ImageView cursor;
    private double count = ENEMY_INITIAL_COUNT;
    private double speed = ENEMY_INITIAL_SPEED;

    public GameField() {
        setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ImageView bg = new ImageView(new Image("/bg.png"));
        bg.setFitWidth(WINDOW_WIDTH);
        bg.setFitHeight(WINDOW_HEIGHT);
        pauseButton = new PauseButton(PAUSE_BUTTON_WIDTH, PAUSE_BUTTON_HEIGHT);
        informationPanel = new InformationPanel(pizza.getHealth(), score);
        weaponPanel = new WeaponPanel();
        cursor();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        getChildren().addAll(bg, informationPanel, weaponPanel, pauseButton, cursor);
        for (int i = 0; i <= 7; i++) getChildren().add(pizza.getPiece(i));
    }

    private void update() {
        if (Math.random() < count) addEnemy(speed, this, enemies);
        for (Enemy enemy : enemies) {
            collision(enemy);
            enemy.toFront();
        }
        coins.removeIf(Coin::isDead);
        coins.forEach(Coin::update);
        enemies.removeIf(Enemy::isDead);
        enemies.forEach(Enemy::update);
        cursor.setImage(weaponPanel.getActiveWeapon().getImage());
        cursor.toFront();
        informationPanel.update(pizza.getHealth(), score);
        informationPanel.toFront();
        weaponPanel.update();
        weaponPanel.toFront();
        pauseButton.toFront();
        count += ENEMY_COUNT_INCREMENT;
        speed += ENEMY_SPEED_INCREMENT;
        if (pizza.getHealth() <= 0) {
            timer.stop();
            Main.stage.setScene(new Scene(new GameOver(score), WINDOW_WIDTH, WINDOW_HEIGHT));
        }
        if (isPressed(KeyCode.ESCAPE)) {
            timer.stop();
            getChildren().add(new PauseMenu());
        }
    }

    private void collision(Enemy enemy) {
        for (int i = 0; i <= 7; i++) {
            if (getChildren().contains(pizza.getPiece(i)) &&
                    pizza.getPiece(i).getBoundsInParent().intersects(enemy.getBoundsInParent()) &&
                    Math.sqrt(Math.pow(enemy.getTranslateX() - pizza.getPiece(i).getTranslateX(), 2) +
                            Math.pow(enemy.getTranslateY() - pizza.getPiece(i).getTranslateY(), 2)) < 90) {
                enemy.setVelocity(enemy.getVelocity().multiply(-1));
                pizza.setHealth(pizza.getHealth() + PIZZA_DAMAGE);
                getChildren().remove(pizza.getPiece(i));
            }
        }
    }

    private void cursor() {
        cursor = new ImageView(weaponPanel.getActiveWeapon().getImage());
        cursor.setFitHeight(100);
        cursor.setFitWidth(67);
        setCursor(Cursor.NONE);
        setOnMouseMoved(e -> {
            cursor.setX(e.getX());
            cursor.setY(e.getY());
        });
    }

    private boolean isPressed(KeyCode key) {
        return Main.keys.getOrDefault(key, false);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public WeaponPanel getWeaponPanel() {
        return weaponPanel;
    }
}
