package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {
    int x, y;
    int speed;
    private int jumpHeight;
    private final int maxHeightOfJump = 200;
    private boolean jump;
    private Texture[] framesArray;
    private int width;
    private int height;


    public Bird(int x, int y, int speed, int width, int height){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;

        framesArray = new Texture[]{
                new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
        };
    }

    public void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }
        if (jump) {
            y += speed;
        } else {
            y -= speed;
        }
    }

    public void draw(Batch batch) {

        batch.draw(texture, x, y);
    }
    public void dispose() {
    }
    void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }
}
