package ServerTCPP.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static ServerTCPP.Server.Server.PORT;

class Connector {

    Connector(ArrayList<PlayerHandler> players) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

        while (players.size() < 2) {
                Socket socket = serverSocket.accept();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                System.out.println("Connector: " + socket.getInetAddress() + " has arrived to the battle!");
                oos.writeObject(players.size());
                PlayerHandler player = new PlayerHandler(socket, players.size(), ois, oos);
                players.add(player);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        new SenderThread(players).start();
    }
}