package dev.unfair.game.game;

import dev.unfair.game.objects.GameObject;
import dev.unfair.game.utils.IoUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private String levelName;
    private List<Block> ids = new ArrayList<>();
    private List<List<Block>> blocks = new ArrayList<>();
    private List<GameObject> objects = new ArrayList<>();

    public Level(String levelName) {
        this.levelName = levelName;
        initIds();
        loadLevel();
    }

    private void initIds() {
        List<String> ids = IoUtil.INSTANCE.fileToList(getMapLoc("ids.txt"));

        for (String s : ids) {
            String[] args = s.split(":");
            this.ids.add(new Block(args[0], Integer.parseInt(args[1])));
        }
    }

    private void loadLevel() {
        List<String> level = IoUtil.INSTANCE.fileToList(getMapLoc("layout.txt"));

        for (String s : level) {
            String[] ids = s.split(";");
            List<Block> y = new ArrayList<>();

            for (String id : ids) {
                y.add(getBlockById(Integer.parseInt(id)));
            }

            blocks.add(y);
        }
    }

    private Block getBlockById(int id) {
        for (Block b : ids) {
            if (b.getId() == id) return b;
        }

        return null;
    }

    private File getMapLoc(String extension) {
        return new File(System.getProperty("user.dir") + "\\assets\\maps\\" +
                levelName + (extension == null ? "" : "\\" + extension));
    }

    public String getLevelName() {
        return levelName;
    }

    public List<List<Block>> getBlocks() {
        return blocks;
    }

    public List<GameObject> getObjects() {
        return objects;
    }
}
