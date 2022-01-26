package ver3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    private static final short STILL = 0, MOVING = 1, WALKING = 0, CLIMBING = 1;
    private static final int width = 42, height = 30;
    private BufferedImage[][][] images;
    private boolean up, down, left, right, space, spaceReleased, onGround;
    private int jumpsLeft;
    private int x, y, xSpeed, ySpeed, ms, hp, cd; //cd = cooldown (fire rate på vapnet inte the 2x)
    private double r;
    private short dir, state, side;
    private double animationFrame = 0;

    public Player(int x, int y) {
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
        this.space = false;
        this.onGround = false;
        this.jumpsLeft = 0;
        this.x = x;
        this.y = y;
        this.xSpeed = 0;
        this.ySpeed = 0;
        this.ms = 10;
        this.hp = 12;
        this.cd = 0;
        this.r = 0;
        this.side = 1;
        this.dir = 1;
        this.images = ImageHandler.getPlayerImages();
    }

    void movePlayer() {
        if (!(left && right)) {
            if (left && -xSpeed < ms) xSpeed -= 2;
            if (right && xSpeed < ms) xSpeed += 2;
        }
        if ((!right || left) && xSpeed > 0 && ySpeed == 0) xSpeed -= 1;
        if ((!left || right) && xSpeed < 0 && ySpeed == 0) xSpeed += 1;
        if (cd > 0) cd--;

        if (state == WALKING) {
            if (space && jumpsLeft>0) {
                ySpeed = -20;   //Up and away
                onGround = false;
                jumpsLeft --;
            }
            if (!onGround&&ySpeed<30) ySpeed += 1; //Var +=2 förut;
            x += xSpeed;
            y += ySpeed;
            if (GamePanel.getMap()[x / 40][(y + height) / 40] == 0 || GamePanel.getMap()[(x + width / 3) / 40][(y + height) / 40] == 0 || GamePanel.getMap()[(x - width / 3) / 40][(y + height) / 40] == 0) { //Collision Ground
                y = (y / 40) * 40 + height - 5;
                ySpeed = 0;
                onGround = true;
                jumpsLeft = 2;
            } else {
                onGround = false;
            }
            if(GamePanel.getMap()[(x+width/3)/40][(y-10)/40]==0||GamePanel.getMap()[(x-width/3)/40][(y-10)/40]==0){
                y = ((y+6)/40)*40+20;
                ySpeed=0;
            }
            if (GamePanel.getMap()[(x - width / 2) / 40][y / 40] == 0) { //Collision Left
                x = (x / 40) * 40 + 40 - width / 2 + 1;
                //xs = -xs; //Bounce
                y -= 10;
                xSpeed = 2;
                ySpeed = 0;
                state = CLIMBING;
                side = 1;
                jumpsLeft = 2;
            } else if (GamePanel.getMap()[(x + width / 2) / 40][y / 40] == 0) { //Collision Right
                x = (x / 40) * 40 + width / 2 - 1;
                //xs = -xs; //Bounce
                y -= 10;
                xSpeed = 2;
                ySpeed = 0;
                state = CLIMBING;
                side = -1;
                jumpsLeft = 2;
            }
        } else if (state == CLIMBING) {
            y += xSpeed * side;
            if (space) {
                state = WALKING;
                if (xSpeed * side < 0){
                    ySpeed = xSpeed * side * 2;
                } else if(state*side==1){
                    ySpeed=5;
                }
                xSpeed = 16 * side;
                onGround = false;
                jumpsLeft --;
            }
            if(down&&!(left||right)){
                state =WALKING;
                x+=2*side;
            }

            if(GamePanel.getMap()[(x-height*side)/40][y/40]==1){    //gå över kant
                state = WALKING;
                if(dir*side!=1) {
                    x -= 16 * side;
                    y -= 4;
                } else {
                    xSpeed=0;
                }
            }
            if (GamePanel.getMap()[x / 40][(y + width / 2) / 40] == 0) {    //krock golv
                y = y / 40 * 40 + height - 5;
                xSpeed = 0;
                state = WALKING;
            }
            if (GamePanel.getMap()[x / 40][(y -height/2-6) / 40] == 0) {    //krock tak
                y = y / 40 * 40 +height/2+6;
                xSpeed = 0;
            }

        }
    }

    void drawPlayer(Graphics g, int mX, int mY) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);

        AffineTransform transform = new AffineTransform();
        AffineTransform oldTransform = g2d.getTransform();
        int imageInt = STILL;
        r = Math.atan2(y - mY, x - mX);
        if (left ^ right) {
            imageInt = MOVING;
            animationFrame += 0.5;
            if (animationFrame == 7) {
                animationFrame = 0;
            }
            if (left) dir = -1;
            if (right) dir = 1;
        } else {
            animationFrame = 0;
        }
        if (state == CLIMBING) {
            transform.translate(x + 10 * side, y - 20 * dir * side);
            transform.rotate(Math.PI / 2 * side);
        } else {
            transform.translate(x - width * 0.5 * dir, y - height * 0.5);
        }
        g2d.transform(transform);
        try {
            g2d.drawImage(ImageHandler.getPlayerImages()[hp - 1][imageInt][(int) (animationFrame)], 0, 0, width * dir, height, null);
        } catch (ArrayIndexOutOfBoundsException e){
            g2d.drawImage(ImageHandler.getPlayerImages()[0][imageInt][(int)animationFrame],0,0,width*dir,height,null);
        }
        g2d.transform(oldTransform);
    }


    void shoot(ArrayList<Shot> shots) {
        if (cd == 0) {
            int sxs = (int) -(Math.cos(r) * 16); //här beräknas x-hastighet
            int sys = (int) -(Math.sin(r) * 16); //här beräknas y-hastighet
            shots.add(new Shot(x, y, sxs, sys));
            cd += 10;
        }
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setSpace(Boolean space) {
        if (!space) {
            spaceReleased = true;
            this.space = false;
        }
        if (space) {
            this.space = spaceReleased;
            spaceReleased = false;
        }
    }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getxSpeed() {
        return xSpeed;
    }
    public int getySpeed() {
        return ySpeed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}