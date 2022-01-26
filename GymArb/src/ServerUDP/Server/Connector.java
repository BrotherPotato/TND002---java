package ServerUDP.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

import static ServerUDP.Server.Server.PORT;

class Connector {

    private DatagramSocket dataSocket;

    Connector(ArrayList<PlayerHandler> players, ArrayList<Player> playerData) {

        try {
            dataSocket = new DatagramSocket(PORT);
            while (players.size() < 2) {
                byte[] data = new byte[256];
                DatagramPacket packet = new DatagramPacket(data, data.length);
                dataSocket.receive(packet);
                PlayerHandler p = new PlayerHandler(packet.getAddress(), packet.getPort(), players.size());
                boolean isConnected = false;
                for (PlayerHandler pl : players) {
                    if (pl.address == packet.getAddress()) isConnected = true;
                }
                System.out.println(players.size());
                if (!isConnected) {
                    players.add(p);
                    System.out.println("Connector: " + packet.getAddress() + " has arrived to the battle!");
                }

            }
            byte b=0;
            for (PlayerHandler p : players) {
                byte[] data = new byte[256];
                data[0] = b;
                b++;
                DatagramPacket packet = new DatagramPacket(data, data.length, p.address, p.port);
                System.out.println(packet.getData()[0]);
                dataSocket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        new ReceiverThread(players, dataSocket).start();
        new SenderThread(players, playerData, dataSocket).start();
    }
}