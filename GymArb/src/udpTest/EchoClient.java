package udpTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.SQLOutput;

public class EchoClient extends Thread {
    private DatagramSocket socket;
    private InetAddress address;
    private byte[] sendData;

    public EchoClient() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("79.136.70.112");
        new ClientRecever(address,socket).start();
    }

    public void run()   {

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            try {
                msg = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client sent: " +msg);
            sendData = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address, 6066);
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        socket.close();
    }
}
class ClientRecever extends Thread{
    private  InetAddress address;
    private DatagramSocket socket;
    private byte[] reData;

    ClientRecever(InetAddress address,DatagramSocket socket) throws SocketException {
        this.socket = socket;
        this.address = address;
    }
    public void run(){
        while (true){
            reData = new byte[256];
            DatagramPacket packet = new DatagramPacket(reData,reData.length);
            try {
                socket.receive(packet);
            } catch (IOException e){
                e.printStackTrace();
            }
            String received = new String(packet.getData(),0,packet.getLength());
            System.out.println("Client got: "+ received);
        }

    }

}