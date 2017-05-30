package game.panels;

import game.Constants;
import game.gameobjects.Weapon;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import static game.Constants.*;
import static game.Main.keys;

public class WeaponPanel extends Pane {
    private Weapon weapon1;
    private Weapon weapon2;
    private Weapon weapon3;
    private Weapon activeWeapon = new Weapon(Constants.Type.FLY);

    public WeaponPanel() {
        setCursor(Cursor.DEFAULT);
        setPrefSize(WEAPON_PANEL_WIDTH, WEAPON_PANEL_HEIGHT);
        setTranslateX(WINDOW_WIDTH - WEAPON_PANEL_WIDTH);
        setTranslateY(WINDOW_HEIGHT - WEAPON_PANEL_HEIGHT);
        setStyle("-fx-background-color: #2d2d2d");
        setWeapon1();
        setWeapon2();
        setWeapon3();
        getChildren().addAll(weapon1, weapon2, weapon3);
    }

    private boolean isPressed(final KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    private void setWeapon1() {
        weapon1 = new Weapon(Constants.Type.FLY);
        weapon1.setTranslateX(30);
        weapon1.setTranslateY(7);
        weapon1.setActive();
        weapon1.setOnMouseClicked(event -> {
            weapon1.setActive();
            weapon2.setInactive();
            weapon3.setInactive();
            activeWeapon = weapon1;
        });
    }

    private void setWeapon2() {
        weapon2 = new Weapon(Constants.Type.BUG);
        weapon2.setTranslateX(95);
        weapon2.setTranslateY(7);
        weapon2.setOnMouseClicked(event -> {
            weapon2.setActive();
            weapon1.setInactive();
            weapon3.setInactive();
            activeWeapon = weapon2;
        });
    }

    private void setWeapon3() {
        weapon3 = new Weapon(Constants.Type.BEE);
        weapon3.setTranslateX(160);
        weapon3.setTranslateY(7);
        weapon3.setOnMouseClicked(event -> {
            weapon3.setActive();
            weapon1.setInactive();
            weapon2.setInactive();
            activeWeapon = weapon3;
        });
    }

    public void update() {
        if (isPressed(KeyCode.DIGIT1)) {
            weapon1.setActive();
            weapon2.setInactive();
            weapon3.setInactive();
            activeWeapon = weapon1;
        }
        if (isPressed(KeyCode.DIGIT2)) {
            weapon2.setActive();
            weapon1.setInactive();
            weapon3.setInactive();
            activeWeapon = weapon2;
        }
        if (isPressed(KeyCode.DIGIT3)) {
            weapon3.setActive();
            weapon1.setInactive();
            weapon2.setInactive();
            activeWeapon = weapon3;
        }
    }

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }
}
