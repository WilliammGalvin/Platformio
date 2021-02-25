package dev.unfair.game.scenes.elements;

import dev.unfair.game.Platformio;
import dev.unfair.game.game.Level;
import dev.unfair.game.scenes.SceneInGame;

public class LevelSelectButton {

    private Level level;
    private float x, y, width, height;
    private Platformio gr;

    public LevelSelectButton(Level level, float x, float y, float width, float height) {
        this.level = level;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        gr = Platformio.INSTANCE;
    }

    public void draw(int mouseX, int mouseY) {
        gr.fill(33, 37, 43);
        gr.rect(x, y, width, height);
        gr.textAlign(gr.CENTER);
        gr.fill(255, 255, 255, isHovered(mouseX, mouseY) ? 255 : 175);
        gr.text(level.getLevelName(), x + (width / 2f), y + (height / 2f));
    }

    private boolean isHovered(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isHovered(mouseX, mouseY) && mouseButton == 37) gr.setScene(new SceneInGame(level));
    }

}
