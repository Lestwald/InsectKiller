package game;

public class Constants {
    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 600;

    public static final double INFORMATION_PANEL_HEIGHT = 100;
    public static final double INFORMATION_PANEL_WIDTH = 550;

    public static final double WEAPON_PANEL_HEIGHT = 100;
    public static final double WEAPON_PANEL_WIDTH = WINDOW_WIDTH - INFORMATION_PANEL_WIDTH;

    public static final double GAMEFIELD_CENTER_X = WINDOW_WIDTH / 2;
    public static final double GAMEFIELD_CENTER_Y = (WINDOW_HEIGHT - INFORMATION_PANEL_HEIGHT) / 2;

    public static final double BUTTON_WIDTH = 330;
    public static final double BUTTON_HEIGHT = 110;
    public static final double PAUSE_BUTTON_WIDTH = 33;
    public static final double PAUSE_BUTTON_HEIGHT = 33;

    public static final double PIZZA_WIDTH = 113.4;
    public static final double PIZZA_HEIGHT = 80;
    public static final int PIZZA_FULL_HEALTH = 80;
    public static final int PIZZA_DAMAGE = -10;

    public static final double COIN_SIZE = 50;
    public static final double COIN_LIFETIME = 200;

    public static final double ENEMY_LIFETIME = 2000;
    public static final double ENEMY_SIZE = 70;
    public static final double ENEMY_INITIAL_SPEED = 1;
    public static final double ENEMY_SPEED_INCREMENT = 0.0001;
    public static final double ENEMY_INITIAL_COUNT = 0.01;
    public static final double ENEMY_COUNT_INCREMENT = 0.000001;

    public enum Type {
        BEE,
        BUG,
        FLY
    }
}
