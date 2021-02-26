package dev.unfair.game.objects;

import dev.unfair.game.Platformio;
import dev.unfair.game.game.Level;
import processing.core.PImage;

public class Player extends GameObject {

    private Level level;

    private PImage img;
    private Platformio gr = Platformio.INSTANCE;

    public Player(Level level, float x, float y) {
        super("player", x, y);
        this.level = level;

        img = gr.loadImage("assets/maps/%s/assets/player.png"
                + level.getLevelName());
    }

    @Override
    public void drawObject() {
        gr.image(img, getX(), getY());
    }

    @Override
    public void keyPressed(int k) {
        switch (k) {
            case 87:
                // W
                break;
            case 65:
                // A
                break;
            case 83:
                // S
                break;
            case 68:
                // D
                break;
            case 32:
                // Space
                break;
        }
    }

}
