package PeerToPeerUDP;


import java.io.IOException;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Server  {
    private static final String myIp ="79.136.70.112";
    private Server() throws IOException {
            DatagramSocket socket = new DatagramSocket(6066);
            System.out.println(1);
            ArrayList<DatagramPacket> players = new ArrayList<>();
            while (players.size() < 2) {
                System.out.println(2);
                byte[] bytes = new byte[256];
                DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
                socket.receive(packet);
                System.out.println(3);
                players.add(packet);
            }
            for (byte i = 0;i<players.size();i++){
                int otherPlayer;
                if(i==1){otherPlayer = 0;
                } else{
                    otherPlayer = 1;
                }
                System.out.println(players.get(otherPlayer).getAddress().toString());
                if(players.get(otherPlayer).getAddress().toString().equals("/127.0.0.1")){
                    players.get(otherPlayer).setAddress(InetAddress.getByName(myIp));
                }
                byte[] ipBytes = players.get(otherPlayer).getAddress().getAddress();
                byte[] port = BigInteger.valueOf(players.get(otherPlayer).getPort()).toByteArray();
                byte[] bytes = new byte[256];
                bytes[4] = (byte) port.length;
                System.arraycopy(ipBytes, 0, bytes, 0, ipBytes.length);
                System.arraycopy(port, 0, bytes, 5, port.length);
                bytes[100] = i;
                DatagramPacket packet = new DatagramPacket(bytes,bytes.length,players.get(i).getAddress(),players.get(i).getPort());
                socket.send(packet);
            }
    }




    public static void main(String[] args) throws IOException {
        new Server();
    }


}
