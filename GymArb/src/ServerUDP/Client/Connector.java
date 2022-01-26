package ServerUDP.Client;

import ServerUDP.Server.Player;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import static ServerUDP.Client.Game.sendInfo;
import static ServerUDP.Client.Game.team;

class Connector {

    Connector (ArrayList<Player> players) {
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();

            ReceiverThread receiver = new ReceiverThread(socket, players);
            new Thread(receiver).start();


            SenderThread sender = new SenderThread(socket);
            new Thread(sender).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ReceiverThread extends Thread {

    private DatagramSocket socket;
    private boolean ready = false;
    private ArrayList<Player> players;

    ReceiverThread(DatagramSocket socket, ArrayList<Player> players) {
        this.socket = socket;
        this.players = players;
        try {
            byte[] sendData = new byte[256];
            DatagramPacket pack = new DatagramPacket(sendData,sendData.length,InetAddress.getByName(Game.IPADRESS), Game.PORT);
            System.out.println("team");
            socket.send(pack);
            System.out.println(1);
            DatagramPacket packet = new DatagramPacket(new byte[256],256);
            socket.receive(packet);
            team = packet.getData()[0];
            System.out.println("TEAM: " + team);
            ready = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void run() {
        try {
            while (ready) {
                DatagramPacket packet = new DatagramPacket(new byte[512],512);
                socket.receive(packet);
                byte[] recBytes = packet.getData();
                ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(recBytes));
                ArrayList<Player> plays = (ArrayList<Player>) iStream.readObject();
                iStream.close();
                players.set(0,plays.get(0));
                players.set(1,plays.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SenderThread extends Thread {

    private DatagramSocket socket;

     SenderThread(DatagramSocket socket) {
        this.socket = socket;
    }

    /** @noinspection InfiniteLoopStatement*/
    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(sendInfo.getBytes(),sendInfo.getBytes().length,InetAddress.getByName(Game.IPADRESS), Game.PORT);
                socket.send(packet);
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}