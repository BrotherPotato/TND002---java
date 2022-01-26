package ServerUDP.Server;

import ServerUDP.Client.GamePanel;
import ServerUDP.Client.ImageHandler;
import ServerUDP.Client.Shot;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private static final short STILL = 0, MOVING = 1, WALKING = 0, CLIMBING = 1;
    private static final int width = 42, height = 30;
    private boolean onGround;
    double r;
    boolean up, down, left, right;
    private boolean space;
    public boolean mousepressed, shoot;
    public int x;
    public int y;
    private int xSpeed, ySpeed, ms, hp, jumpsLeft, jumpCooldown, points;
    int cd; //cd = cooldown (fire rate på vapnet inte the 2x)
    private short dir, state, side;
    private double animationFrame;

    public Player(int x, int y) {
        this.onGround = false;
        this.jumpsLeft = 0;
        this.mousepressed = false;
        this.x = x;
        this.y = y;
        this.xSpeed = 0;
        this.ySpeed = 0;
        this.ms = 10;
        this.hp = 5;
        this.cd = 0;
        this.animationFrame = 0;
        this.jumpCooldown = 0;
    }

    public void drawPlayer(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);

        AffineTransform oldTransform = g2d.getTransform();
        int imageInt = STILL;
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
            g2d.translate((x + 10 * side), (y - 20 * dir * side));
            g2d.rotate(Math.PI / 2 * side);
        } else {
            g2d.translate((x - width * 0.5 * dir), (y - height * 0.5));
        }
        try {
            g2d.drawImage(ImageHandler.getPlayerImages()[hp - 1][imageInt][(int) (animationFrame)], 0, 0, width * dir, height, null);
        } catch (ArrayIndexOutOfBoundsException e){
            g2d.drawImage(ImageHandler.getPlayerImages()[0][imageInt][(int)animationFrame],0,0,width*dir,height,null);
        }
        g2d.setTransform(oldTransform);
    }

    public void movePlayer() {
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
            if(GamePanel.getMap()[(x+width/3)/40][(y-10)/40]==0|| GamePanel.getMap()[(x-width/3)/40][(y-10)/40]==0){
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
            if(left^right){
                if (left) dir = -1;
                if (right) dir = 1;
            }
        }
        while (GamePanel.getMap()[x/40][y/40]==0){
            y++;
        }

        //shoot = false;
    }
    public void shoot(ArrayList<Shot> shots, int team) {
            int sxs = (int) -(Math.cos(r) * 24); //här beräknas x-hastighet
            int sys = (int) -(Math.sin(r) * 24); //här beräknas y-hastighet
            shots.add(new Shot(x, y, sxs, sys, team));
            cd += 24;
    }


    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setSpace(boolean s) {
        if(s&&jumpCooldown==0){
            jumpCooldown = 6;
            space = true;
        }
        if(!s) space=false;
        if(jumpCooldown>0)jumpCooldown--;
        if(jumpCooldown>0&&jumpsLeft==2){
            space = true;
        }
    }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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

    void setxSpeed() {
        this.xSpeed = 0;
    }
    void setySpeed() {
        this.ySpeed = 0;
    }

    public short getState() {
        return state;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPoints() {
        return points;
    }
    void setPoints(int points) {
        this.points = points;
    }
}
