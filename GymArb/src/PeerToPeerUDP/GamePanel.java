package PeerToPeerUDP;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener {

    private Point mouse = new Point();

    private static boolean[] keys = new boolean[5];
    private static boolean spaceReleased=true;

    private static Game game;

    private static int[][] map =loadMap();

    private GamePanel() {
        setPreferredSize(new Dimension(1920, 1080));
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);
        setBackground(Color.BLACK);
        game = new Game(this);


    }
    public static int[][] getMap(){
        return map;
    }

    private static int[][] loadMap() {
        return new int[][]{
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//01
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//02
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0},//03
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0},//04
                {0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0},//05
                {0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},//06
                {0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//07
                {0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//08
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//09
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//10
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//11
                {0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//12
                {0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0},//13
                {0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0},//14
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//15
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//16
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//17
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//18
                {0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//19
                {0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0},//20
                {0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//21
                {0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//22
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//23
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//24
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//25
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//26
                {0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//27
                {0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//28
                {0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0},//29
                {0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//30
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//31
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//32
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//33
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},//34
                {0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0},//35
                {0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0},//36
                {0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//37
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//38
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//39
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//40
                {0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//41
                {0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//42
                {0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},//43
                {0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0},//44
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0},//45
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0},//46
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//47
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//48
                // 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7
        };
    }

    /*void run() {
        long nanos = System.nanoTime(), delay = (long) (1e9 / 90);
        while (true) {
            nextFrame();
            repaint();

            while (System.nanoTime() < nanos + delay) {
                Thread.yield();
            }
            nanos += delay;
        }
    }*/
    void startGame(){
        new Timer(16, this).start();
    }
    private void nextFrame() {
        game.nextFrame(mouse, keys);
    }

    @Override
    protected void paintComponent(Graphics g) {
        for(int x = 0; x < 48; x++) {
            for(int y = 0; y < 27; y++) {
                switch(map[x][y]) {
                    case 0:
                        g.setColor(Color.BLACK);
                        g.fillRect(x * 40 , y * 40 , 40, 40);
                        break;
                    case 1:
                        g.setColor(Color.WHITE);
                        g.fillRect(x * 40 , y * 40 , 40, 40);
                        break;
                    case 2:
                        g.setColor(Color.RED);
                        g.fillRect(x * 40 , y * 40 , 40, 40);
                        break;
                }
            }
        }
        game.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        game.mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouse = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse = e.getPoint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
        switch (e.getKeyChar()) {
            case ('w'):
            case ('W'):
                keys[0] = true;
                break;
            case ('s'):
            case ('S'):
                keys[1] = true;
                break;
            case ('a'):
            case ('A'):
                keys[2] = true;
                break;
            case ('d'):
            case ('D'):
                keys[3] = true;
                break;
            case (' '):
                keys[4] = spaceReleased;
                spaceReleased = false;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case ('w'):
            case ('W'):
                keys[0] = false;
                break;
            case ('s'):
            case ('S'):
                keys[1] = false;
                break;
            case ('a'):
            case ('A'):
                keys[2] = false;
                break;
            case ('d'):
            case ('D'):
                keys[3] = false;
                break;
            case (' '):
                keys[4] = false;
                spaceReleased = true;
                break;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GamePanel g = new GamePanel();
            JFrame f = new JFrame();
            f.setResizable(true);
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setUndecorated(true);
            f.add(g);
            f.pack();
            f.setLocationRelativeTo(null);
            try {
                f.setIconImage(ImageIO.read(new File("Assets/Images/Icon.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }

            f.setVisible(true);
        });
    }

//d
    @Override
    public void actionPerformed(ActionEvent e) {
        nextFrame();
        repaint();
    }
}