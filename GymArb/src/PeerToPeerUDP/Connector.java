package PeerToPeerUDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Connector {

    Connector (ArrayList<Player> players) {
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();
            byte[] bytes = new byte[256];
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length,InetAddress.getByName(Game.IPADRESS),Game.PORT);
            socket.send(packet);
            byte[] recBytes = new byte[256];
            DatagramPacket recPacket = new DatagramPacket(recBytes,recBytes.length);
            socket.receive(recPacket);
            Game.team = recPacket.getData()[100];
            System.out.println("team: "+Game.team);
            byte[] addressBytes = new byte[4];
            System.arraycopy(recPacket.getData(),0,addressBytes,0,addressBytes.length);
            byte[] portBytes = new byte[recPacket.getData()[4]];
            System.arraycopy(recPacket.getData(),5,portBytes,0,portBytes.length);
            InetAddress address = InetAddress.getByAddress(addressBytes);
            int port = 6066;
            System.out.println(1);
            Thread.sleep(1000);
            System.out.println(2);
            socket = new DatagramSocket(6066);
            System.out.println(port);
            System.out.println(address.toString());


            Sender.initSender(socket,address,port);

            ReceiverThread receiver = new ReceiverThread(socket, players);
            new Thread(receiver).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ReceiverThread extends Thread {

    private DatagramSocket socket;
    private ArrayList<Player> players;

    ReceiverThread(DatagramSocket socket, ArrayList<Player> players) {
        this.socket = socket;
        this.players = players;

    }

    /** @noinspection InfiniteLoopStatement*/
    public void run() {
        try {
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[512],512);
                socket.receive(packet);
                byte[] recBytes = packet.getData();
                ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(recBytes));
                Player player = (Player) iStream.readObject();
                iStream.close();
                if(Game.team==0){
                    players.set(1,player);
                } else{
                    players.set(0,player);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Sender  {

    private static DatagramSocket socket;
    private static InetAddress address;
    private static int port;

    static void initSender(DatagramSocket socket, InetAddress address, int port) {
        Sender.socket = socket;
        Sender.address = address;
        Sender.port = port;
     }


     static void send(ArrayList<Player> players) {
        try {
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            ObjectOutput oo = new ObjectOutputStream(bStream);
            oo.writeObject(players.get(Game.team));
            oo.close();
            byte[] serializedMessage = bStream.toByteArray();
            DatagramPacket packet = new DatagramPacket(serializedMessage, serializedMessage.length, Sender.address, Sender.port);
            Sender.socket.send(packet);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}