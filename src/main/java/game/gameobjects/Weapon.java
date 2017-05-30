package game.gameobjects;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import static game.Constants.Type;

public class Weapon extends ImageView {
    private Type type;
    private Boolean active = false;

    public Weapon(final Type t) {
        type = t;
        Image image;
        if (type == Type.FLY) image = new Image("/weapon/weapon_fly.png");
        else if (type == Type.BUG) image = new Image("/weapon/weapon_bug.png");
        else image = new Image("/weapon/weapon_bee.png");
        setImage(image);
        setFitWidth(56);
        setFitHeight(85);
    }

    public void setInactive() {
        active = false;
        setEffect(null);
    }

    public void setActive() {
        active = true;
        DropShadow ds = new DropShadow();
        ds.setColor(Color.WHITE);
        setEffect(ds);
    }

    public Type getType() {
        return type;
    }
}
