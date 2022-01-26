package PeerToPeerUDP;

import java.awt.*;
import java.util.ArrayList;

class Game {

    static int PORT = 6066;
    static final String IPADRESS = "78.66.86.139";
    private static Point points = new Point(0, 0);
    private int drawPoints = 0;

    private ArrayList<Player> players;
    boolean mousePressed = false;
    static int team;
    private ArrayList<Shot> shots = new ArrayList<>();

    public Game(GamePanel g) {
        players = new ArrayList<>();
        players.add(new Player(100, 1000));
        players.add(new Player(1820, 1000));
        System.out.println(players.get(0).x +" : "+players.get(1).x);
        ImageHandler.initImages();
        new Connector(players);
        System.out.println(players.get(0).x +" : "+players.get(1).x);
        g.startGame();
    }

    void nextFrame(Point mouse, boolean[] keys) {
        if (keys[2]) {
            players.get(team).setLeft(true);
        }
        if (keys[3]) {
            players.get(team).setRight(true);
        }
        if (keys[1]) {
            players.get(team).setDown(true);
        }
        if (keys[4]) {
            players.get(team).setSpace(true);
        }
        if (mousePressed) {
            players.get(team).r = (Math.atan2(players.get(team).getY() - mouse.y, players.get(team).getX() - mouse.x));
            players.get(team).mousepressed = true;
        } else {
            players.get(team).mousepressed = false;
        }
        if (!keys[1]) {
            players.get(team).setDown(false);
        }
        if (!keys[2]) {
            players.get(team).setLeft(false);
        }
        if (!keys[3]) {
            players.get(team).setRight(false);
        }
        if (!keys[4]) {
            players.get(team).setSpace(false);
        }
        if (players.get(team).getPoints() != points.x) {
           drawPoints = 300;
           points.x = players.get(team).getPoints();
        }
        for (Player p : players) {
            p.movePlayer();
        }
        keys[4] = false;
        shooty: {
            for (Shot sht : shots) {
                sht.moveShot();
                for (int i = 0; i < players.size(); i++) {
                    Player p = players.get(i);
                    if (sht.checkHit(p, i)) {
                        p.setHp(p.getHp() - 1);
                        if (p.getHp() <= 0) {
                            resetPlayer();
                            if (p.equals(players.get(1))) {
                                players.get(0).setPoints(players.get(0).getPoints() + 1);
                            } else {
                                players.get(1).setPoints(players.get(1).getPoints() + 1);
                            }
                            shots.clear();
                            break shooty;
                        }
                        sht.bounces = 6;
                    }
                }
            }
        }
        for (Shot sht : shots) {
            if (sht.bounces > 5) {
                shots.remove(sht);
                break;
            }
        }
        Sender.send(players);
        for (Player p: players) {
            if (p.mousepressed && p.cd == 0) {
                p.shoot(shots, players.indexOf(p));
            }
        }
    }

    private void resetPlayer() {
        Player p = players.get(team);
        p.setX(100 + 1720 * team);
        p.setY(1000);
        p.setxSpeed();
        p.setySpeed();
        p.setHp(5);
    }

    void draw(Graphics g) {
        for (Shot sht : shots) {
            sht.drawShot((Graphics2D) g);
        }
        for (Player p : players) {
            p.drawPlayer(g);
        }
        if(drawPoints>0) {
            g.setFont(new Font("jef",  Font.BOLD, 32));
            g.drawString(Integer.toString(points.x), 100, 100);
            g.drawString(Integer.toString(points.y), 1820, 100);
            drawPoints--;
        }
    }
}