package game.gameobjects;

import java.util.ArrayList;

import static game.Constants.PIZZA_FULL_HEALTH;

public class Pizza {
    private int health = PIZZA_FULL_HEALTH;
    private ArrayList<PieceOfPizza> view = new ArrayList<>();

    public Pizza(final double x, final double y) {
        view.add(0, new PieceOfPizza(x, y, 0));
        view.add(1, new PieceOfPizza(x + 11, y + 51.5, 45));
        view.add(2, new PieceOfPizza(x - 17, y + 96, 90));
        view.add(3, new PieceOfPizza(x - 68.5, y + 107.5, 135));
        view.add(4, new PieceOfPizza(x - 113, y + 79, 180));
        view.add(5, new PieceOfPizza(x - 124, y + 27.5, 225));
        view.add(6, new PieceOfPizza(x - 96, y - 17, 270));
        view.add(7, new PieceOfPizza(x - 44.5, y - 28.5, 315));
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public PieceOfPizza getPiece(int i) {
        return view.get(i);
    }
}
