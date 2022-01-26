package ServerUDP.Server;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

class PlayerHandler {

    InetAddress address;
    int port;

    Player player;
    int team;

    PlayerHandler(InetAddress address, int port, int team) {

        this.address = address;
        this.port = port;
        this.team = team;
        player = new Player(100 + 1720 * team, 1000);



        //SenderThread sender = new SenderThread(oos, player, team);
        //new Thread(sender::run).start();
    }
}

class ReceiverThread extends Thread {
    private ArrayList<PlayerHandler> players;
    private DatagramSocket socket;


    ReceiverThread(ArrayList<PlayerHandler> players, DatagramSocket socket) {
        this.players = players;
        this.socket = socket;
    }

    public void run() {
        while (true) {
            try {
                byte[] recData = new byte[256];
                DatagramPacket packet = new DatagramPacket(recData, recData.length);
                socket.receive(packet);
                String actionFromClient = new String(packet.getData(), 0, packet.getLength());
                for (PlayerHandler player : players){
                    if(player.address.toString().equals(packet.getAddress().toString())){
                        String[] keys = actionFromClient.split(",");
                        player.player.left = keys[0].equals("1");
                        player.player.right = keys[1].equals("1");
                        player.player.up = keys[2].equals("1");
                        player.player.down = keys[3].equals("1");
                        player.player.setSpace(keys[4].equals("1"));
                        if (!keys[5].equals("0")) {
                            player.player.mousepressed = true;
                            player.player.r = Double.valueOf(keys[5]);
                        } else {
                            player.player.mousepressed = false;
                        }
                    }
                }


            } catch (Exception ex) {
                ex.printStackTrace();
                break;
            }
        }
    }

}

class SenderThread extends Thread {
    private ArrayList<PlayerHandler> players;
    private ArrayList<Player> playerData;
    private DatagramSocket socket;

    SenderThread(ArrayList<PlayerHandler> players, ArrayList<Player> playerData, DatagramSocket socket) {
        this.players = players;
        this.playerData = playerData;
        this.socket = socket;

    }

    /** @noinspection InfiniteLoopStatement*/
    public void run() {
        while (true) {
            try {
                for (PlayerHandler player : players) {
                    ByteArrayOutputStream bStream = new ByteArrayOutputStream();
                    ObjectOutput oo = new ObjectOutputStream(bStream);
                    oo.writeObject(playerData);
                    oo.close();
                    byte[] serializedMessage = bStream.toByteArray();
                    DatagramPacket packet = new DatagramPacket(serializedMessage, serializedMessage.length, player.address, player.port);
                    socket.send(packet);
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