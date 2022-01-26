package udpTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoServer extends Thread {

    private DatagramSocket socket;
    private boolean running;
    private byte[] reData = new byte[256];

    private ServerListener listener;

    public EchoServer() throws SocketException {
        socket = new DatagramSocket(6066);
        listener = new ServerListener(socket);
        listener.start();
    }

    public void run() {
        running = true;
        while (running) {
            reData = new byte[256];
            DatagramPacket packet
                    = new DatagramPacket(reData, reData.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Server2 got: " + received);
            listener.setAddress(packet.getAddress());
            listener.setPort(packet.getPort());

            if (received.equals("end")) {
                running = false;
                continue;
            }

        }
        socket.close();
    }
}

class ServerListener extends Thread {
    private byte[] sendData = new byte[256];
    private DatagramSocket socket;
    private InetAddress address;
    private int port;

    ServerListener(DatagramSocket socket) {
        this.socket = socket;
    }

    public void run() {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            try {
                msg = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Server2 sent: " + msg);
            sendData = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address, port);
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public void setPort(int port) {
        this.port = port;
    }
}