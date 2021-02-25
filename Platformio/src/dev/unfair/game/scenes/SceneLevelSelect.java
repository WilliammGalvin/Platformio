package dev.unfair.game.scenes;

import dev.unfair.game.Platformio;
import dev.unfair.game.game.Level;
import dev.unfair.game.scenes.elements.LevelSelectButton;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class SceneLevelSelect implements Scene {

    private final PImage logo;
    private List<LevelSelectButton> buttons = new ArrayList<>();
    private final Platformio gr = Platformio.INSTANCE;

    public SceneLevelSelect() {
        float yInt = 0;
        for (Level level : gr.getLevels()) {
            buttons.add(new LevelSelectButton(level, 0, yInt, 350, 50));
            yInt += 50f;
        }

        logo = gr.loadImage("assets/data/logo.png");
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        gr.background(40, 44, 52);

        gr.noStroke();
        gr.fill(33, 37, 43);
        gr.rect(0, 0, 350, gr.displayHeight);
        for (LevelSelectButton b : buttons)
            b.draw(mouseX, mouseY);
        gr.stroke(0);

        gr.image(logo, 350 + 225, 25);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (LevelSelectButton b : buttons) {
            b.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

}
