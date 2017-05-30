package game.panels;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static game.Constants.*;

public class InformationPanel extends Pane {
    private Label health;
    private Label score;
    private final Font font = new Font("Insektofobiya", 36);
    private final Color color = Color.valueOf("#ee5f41");

    public InformationPanel(final int h, final int s) {
        setPrefSize(INFORMATION_PANEL_WIDTH, INFORMATION_PANEL_HEIGHT);
        setTranslateX(0);
        setTranslateY(WINDOW_HEIGHT - INFORMATION_PANEL_HEIGHT);
        setStyle("-fx-background-color: #2d2d2d");
        health(h);
        score(s);
        getChildren().addAll(health, score);
    }

    private void health(final int h) {
        health = new Label("Health: " + h);
        health.setFont(font);
        health.setTextFill(color);
        health.setTranslateX(50);
        health.setTranslateY(30);
    }

    private void score(final int s) {
        score = new Label("Score: " + s);
        score.setFont(font);
        score.setTextFill(color);
        score.setTranslateX(300);
        score.setTranslateY(30);
    }

    public void update(final int h, final int s) {
        health.setText("Health: " + h);
        score.setText("Score: " + s);
    }
}
