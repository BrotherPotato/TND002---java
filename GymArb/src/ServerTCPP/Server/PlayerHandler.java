package ServerTCPP.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

class PlayerHandler {

    ObjectOutputStream oos;
    Player player;
    int team;

    PlayerHandler(Socket socket, int team, ObjectInputStream ois, ObjectOutputStream oos) {
        this.oos = oos;
        this.team = team;
        player = new Player(100 + 1720 * team, 1000);

        ReceiverThread receiver = new ReceiverThread(ois, player, socket);
        new Thread(receiver).start();

        //SenderThread sender = new SenderThread(oos, player, team);
        //new Thread(sender::run).start();
    }
}

class ReceiverThread extends Thread {

    private ObjectInputStream ois;
    private Player player;
    private Socket socket;

    ReceiverThread(ObjectInputStream ois, Player player, Socket socket) {
        this.ois = ois;
        this.player = player;
        this.socket = socket;
    }

    public void run() {
        while (true) {
            try {
                String actionFromClient = ois.readObject().toString();
                if (actionFromClient.equalsIgnoreCase("exit")) socket.close();
                String[] keys = actionFromClient.split(",");
                player.left = keys[0].equals("1");
                player.right = keys[1].equals("1");
                player.up = keys[2].equals("1");
                player.down = keys[3].equals("1");
                player.setSpace(keys[4].equals("1"));
                if(!keys[5].equals("0")) {
                    player.mousepressed = true;
                    player.r = Double.valueOf(keys[5]);
                } else {
                    player.mousepressed = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}

class SenderThread extends Thread {

    private ArrayList<PlayerHandler> players;

    SenderThread(ArrayList<PlayerHandler> players) {
        this.players = players;
    }

    /** @noinspection InfiniteLoopStatement*/
    public void run() {
        while (true) {
            try {
                for (PlayerHandler player : players) {
                    player.oos.reset();
                    player.oos.writeObject(players.get(0).player);
                    player.oos.reset();
                    player.oos.writeObject(players.get(1).player);
                }
                for (PlayerHandler p: players){
                    p.player.shoot = false;
                }
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}