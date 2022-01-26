package ver3;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

class Game implements Serializable {

    static Socket clientSocket;
    private ArrayList players;
    private Player player;
    private Player otherPlayer;
    static final long serialVersionUID = 42L;
    boolean mousePressed = false;
    private boolean[] keys;
    ArrayList<Shot> shots = new ArrayList<>();

    public Game(boolean[] keys) {
        ImageHandler.initImages();
        this.keys = keys;
        players = new ArrayList<Player>();
        player = new Player(100,100);
        otherPlayer = new Player(100,100);
    }

    void nextFrame(Point mouse, boolean[] keys) {

        if (keys[0]) player.setUp(true);
        if (keys[1]) player.setDown(true);
        if (keys[2]) player.setLeft(true);
        if (keys[3]) player.setRight(true);
        if (keys[4]) player.setSpace(true);
        if (!keys[0]) player.setUp(false);
        if (!keys[1]) player.setDown(false);
        if (!keys[2]) player.setLeft(false);
        if (!keys[3]) player.setRight(false);
        if (!keys[4]) player.setSpace(false);
        player.movePlayer();
        if (mousePressed) {
            player.shoot(shots);
        }
        for (Shot sht : shots) {
            sht.moveShot();
        }
        for (Shot sht : shots) {
            if(sht.bounces > 5) {
                shots.remove(sht);
                break;
            }
        }
    }

    void draw(Graphics g, Point mouse) {
        for (Shot sht : shots) {
            sht.drawShot((Graphics2D) g);
        }
        player.drawPlayer(g, mouse.x, mouse.y);
    }
}