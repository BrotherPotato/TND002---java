package ver3;

import java.awt.*;

public class Shot {

    private int x, y, xs, ys; //xs = x-speed, r = rotation
    int bounces;
    double r;

    public Shot(int x, int y, int xs, int ys) {
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
        this.r = 0;
        this.bounces = 0;
    }

    void moveShot() {
        x += xs;
        if(checkBounce()) {
            xs = -xs;
            bounces++;
        }
        y += ys;
        if(checkBounce()) {
            ys = -ys;
            bounces++;
        }
    }

    private boolean checkBounce() {
        return GamePanel.getMap()[(x + xs) / 40][(y + ys) / 40] == 0;  //Collision Ground
    }

    void drawShot(Graphics2D g) {
        r = Math.atan2(ys, xs);
        g.translate(x, y);
        g.rotate(r);
        g.setColor(Color.BLUE);
        g.fillRect(-12, -2, 12, 5);
        g.setColor(Color.RED);
        g.fillRect(0,0,1,1);
        g.rotate(-r);
        g.translate(-x, -y);
    }

}
