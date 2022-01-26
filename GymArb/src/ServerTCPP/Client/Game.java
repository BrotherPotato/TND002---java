package ServerTCPP.Client;

import ServerTCPP.Server.Player;
import java.awt.*;
import java.util.ArrayList;

class Game {

    static int PORT = 6066;
    static String IPADRESS = "78.66.86.139";
    private static long time;
    private static Point points = new Point(0, 0);
    private int drawPoints = 0;

    private ArrayList<ServerTCPP.Server.Player> players;
    boolean mousePressed = false;
    private boolean timed = false, checkedTime = false;
    static int team;
    static String sendInfo = "0,0,0,0,0,0";
    private ArrayList<Shot> shots = new ArrayList<>();

    public Game( GamePanel g) {
        players = new ArrayList<>();
        players.add(new ServerTCPP.Server.Player(100, 1000));
        players.add(new ServerTCPP.Server.Player(1820, 1000));
        new Connector(players);
        g.startGame();
    }

    void nextFrame(Point mouse, boolean[] keys) {
        String toSend = "";
        if (keys[2]) {
            toSend += "1,";
            players.get(team).setLeft(true);
        } else {
            toSend += "0,";
        }
        if (keys[3]) {
            toSend += "1,";
            players.get(team).setRight(true);
        } else {
            toSend += "0,";
        }
        if (keys[0]) {
            toSend += "1,";
            players.get(team).setUp(true);
        } else {
            toSend += "0,";
        }
        if (keys[1]) {
            toSend += "1,";
            players.get(team).setDown(true);
        } else {
            toSend += "0,";
        }
        if (keys[4]) {
            toSend += "1,";
            players.get(team).setSpace(true);
            if (!checkedTime) {
                time = java.lang.System.currentTimeMillis();
                timed = false;
                checkedTime = true;
            }
        } else {
            toSend += "0,";
        }
        if (players.get(team).getySpeed() < 0 && !timed) {
            System.out.println((java.lang.System.currentTimeMillis() - time));
            timed = true;
            checkedTime = false;
        }
        if (mousePressed) {
            double r = (Math.atan2(players.get(team).getY() - mouse.y, players.get(team).getX() - mouse.x));
            toSend += Double.toString(r);
        } else {
            toSend += "0";
        }
        keys[4] = false;
        sendInfo = toSend;
        if (!keys[0]) {
            players.get(team).setUp(false);
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
        for (Player p : players) {
            p.movePlayer();
        }

        if (players.get(0).getPoints() != points.x) {
           drawPoints = 300;
           points.x = players.get(0).getPoints();
        }
        if (players.get(1).getPoints() != points.y) {
            drawPoints = 300;
            points.y = players.get(1).getPoints();
        }

        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            if (p.shoot) {
                p.shoot(shots, i);
            }
        }
        shooty: {
            for (Shot sht : shots) {
                sht.moveShot();
                for (int i = 0; i < players.size(); i++) {
                    Player p = players.get(i);
                    if (sht.checkHit(p, i)) {
                        p.setHp(p.getHp() - 1);
                        if (p.getHp() <= 0) {
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
    }

    void draw(Graphics g) {
        for (Shot sht : shots) {
            sht.drawShot((Graphics2D) g);
        }
        for (Player p : players) {
            p.drawPlayer(g);
        }
        if(drawPoints>0) {
            g.setFont(new Font("jef", Font.ITALIC, 32));
            g.drawString(Integer.toString(points.x), 100, 100);
            g.drawString(Integer.toString(points.y), 1820, 100);
            drawPoints--;
        }
    }
}