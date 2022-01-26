package ServerUDP.Client;

import ServerUDP.Server.Player;

import java.awt.*;

public class Shot {

    private int x, y, xs, ys; //xs = x-speed, r = rotation
    public int bounces, team;
    private double r;

    public Shot(int x, int y, int xs, int ys, int team) {
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
        this.r = 0;
        this.team = team;
        this.bounces = 0;
    }

    public void moveShot() {
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
        return GamePanel.getMap()[(x + xs) / 40][(y + ys) / 40] == 0;
    }

    public boolean checkHit(Player p, int pTeam) {
        if(team==pTeam) {
            return false;
        } else {
            if (p.getState()==0) {
                return (Math.abs(p.getX() - x) <= Math.abs(p.getWidth()/2 + 3) && Math.abs(p.getY() - y) <= Math.abs(p.getHeight()/2 + 6));
            } else {
                return (Math.abs(p.getX() - x) <= Math.abs(p.getHeight()/2 + 3) && Math.abs(p.getY() - y) <= Math.abs(p.getWidth()/2 + 6));
            }
        }
    }

    void drawShot(Graphics2D g) {
        r = Math.atan2(ys, xs);
        g.translate(x, y);
        g.rotate(r);
        g.setColor(new Color(255 * team, 0, 255 * (1 - team)));
        g.fillRect(-12, -2, 12, 5);
        g.rotate(-r);
        g.translate(-x, -y);
    }

}
