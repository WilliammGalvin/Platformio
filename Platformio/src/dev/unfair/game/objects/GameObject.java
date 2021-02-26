package dev.unfair.game.objects;

public abstract class GameObject {

    private String objectName;
    private float x, y;

    public GameObject(String objectName, float x, float y) {
        this.objectName = objectName;
        this.x = x;
        this.y = y;
    }

    public abstract void drawObject();
    public abstract void keyPressed(int k);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getObjectName() {
        return objectName;
    }

}
