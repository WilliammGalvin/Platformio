package dev.unfair.game.scenes;

import dev.unfair.game.Platformio;
import dev.unfair.game.game.Block;
import dev.unfair.game.game.Level;
import processing.core.PImage;

import java.util.List;

public class SceneInGame implements Scene {

    private Level level;
    private Platformio gr = Platformio.INSTANCE;

    private PImage bg;

    public SceneInGame(Level level) {
        this.level = level;
        bg = gr.loadImage("assets/data/background.jpg");
    }

    @Override
    public void draw(int mouseX, int mouseY) {
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
    }

}
