package dev.unfair.game;

import dev.unfair.game.game.Level;
import dev.unfair.game.scenes.Scene;
import dev.unfair.game.scenes.SceneLevelSelect;
import processing.core.PApplet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Platformio extends PApplet {

    public static final Platformio INSTANCE = new Platformio();

    private final int WIDTH = 1250, HEIGHT = 750;
    public final int TILE_SIZE = 50;

    private Scene scene;

    private List<Level> levels = new ArrayList<>();

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        File levelsFolder = new File(System.getProperty("user.dir") + "\\assets\\maps");
        for (File file : Objects.requireNonNull(levelsFolder.listFiles())) {
            levels.add(new Level(file.getName()));
        }

        scene = new SceneLevelSelect();
    }

    @Override
    public void draw() {
        scene.draw(mouseX, mouseY);
    }

    @Override
    public void mouseClicked() {
        scene.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void keyPressed() {
        System.out.println(keyCode);
        scene.keyPressed(keyCode);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"ProcessingTest"}, INSTANCE);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public List<Level> getLevels() {
        return levels;
    }

}
