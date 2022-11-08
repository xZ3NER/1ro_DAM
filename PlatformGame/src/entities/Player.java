package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.Directions.*;
import static utils.Constants.Directions.DOWN;
import static utils.Constants.PlayerConstants.*;

public class Player extends Entity{

    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 20;
    private int playerAction = IDLE;
    private boolean left, up, right, down;
    private boolean moving = false, attacking = false;
    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);

        loadAnimations();
    }

    public void update() {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage((Image) animations[playerAction][animationIndex], (int) x, (int) y,128,80,null);
    }

    private void updateAnimationTick() {

        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= GetSpriteAmount(playerAction)) {
                animationIndex = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {

        int startAni = playerAction;

        if (moving) {
            playerAction = RUNNING;
        }else{
            playerAction = IDLE;
        }

        if (attacking) {
            playerAction = ATTACK_1;
        }

        if(startAni != playerAction) {
            resetAniTick();
        }
    }

    private void resetAniTick() {
        animationTick = 0;
        animationIndex = 0;
    }

    private void updatePos() {

        moving = false;

        if (left && !right) {
            x-=playerSpeed;
            moving = true;
        }else if(right && !left){
            x+= playerSpeed;
            moving = true;
        }

        if (up && !down) {
            y-=playerSpeed;
            moving = true;
        }else if(down && !up){
            y+= playerSpeed;
            moving = true;
        }
    }

    private void loadAnimations() { //load all animations of the player sprites png

        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            BufferedImage image = ImageIO.read(is);

            animations = new BufferedImage[9][6];

            for (int j=0;j<animations.length;j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = image.getSubimage(i * 64, j*40, 64, 40); //Because the tile image is 64x40
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void resetDirBooleans() {
        up = false;
        left = false;
        down = false;
        right = false;
    }
}
