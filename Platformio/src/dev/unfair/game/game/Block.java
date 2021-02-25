package dev.unfair.game.game;

public class Block {

    private String blockName;
    private int id;

    public Block(String blockName, int id) {
        this.blockName = blockName;
        this.id = id;
    }

    public String getBlockName() {
        return blockName;
    }

    public int getId() {
        return id;
    }

}
