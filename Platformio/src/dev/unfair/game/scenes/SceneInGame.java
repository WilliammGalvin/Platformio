package dev.unfair.game.scenes;

import dev.unfair.game.Platformio;
import dev.unfair.game.game.Block;
import dev.unfair.game.game.Level;
import dev.unfair.game.objects.GameObject;
import dev.unfair.game.objects.Player;
import processing.core.PImage;

import java.util.List;

public class SceneInGame implements Scene {

    private Level level;
    private Platformio gr = Platformio.INSTANCE;

    public SceneInGame(Level level) {
        this.level = level;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        gr.background(84, 160, 255);

        float yInt = 0;
        for (List<Block> y : level.getBlocks()) {
            float xInt = 0;
            for (Block x : y) {
                if (x.getBlockName().equals("air")) {
                    xInt += gr.TILE_SIZE;
                    continue;
                }

                if (x.getBlockName().equals("spawn")) {
                    level.getObjects().add(new Player(level, xInt, yInt));
                    xInt += gr.TILE_SIZE;
                    continue;
                }

                PImage img = gr.loadImage(String.format("assets/maps/%s/assets/%s.png",
                        level.getLevelName(), x.getBlockName()));

                gr.image(img, xInt, yInt);
                xInt += gr.TILE_SIZE;
            }
            yInt += gr.TILE_SIZE;
        }

        for (GameObject obj : level.getObjects()) {
            obj.drawObject();
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
    }

    @Override
    public void keyPressed(int k) {
        for (GameObject obj : level.getObjects()) {
            obj.keyPressed(k);
        }
    }

}
