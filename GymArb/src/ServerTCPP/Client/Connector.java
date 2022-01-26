package ServerTCPP.Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import static ServerTCPP.Client.Game.IPADRESS;
import static ServerTCPP.Client.Game.PORT;
import static ServerTCPP.Client.Game.sendInfo;
import static ServerTCPP.Client.Game.team;

class Connector {

    Connector (ArrayList<ServerTCPP.Server.Player> players) {
        Socket socket;
        try {
            socket = new Socket(IPADRESS, PORT);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            ReceiverThread receiver = new ReceiverThread(ois, players);
            new Thread(receiver).start();

            SenderThread sender = new SenderThread(oos);
            new Thread(sender).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReceiverThread extends Thread {

    private ObjectInputStream inputStream;
    private boolean ready = false;
    private ArrayList<ServerTCPP.Server.Player> players;

    ReceiverThread(ObjectInputStream inputStream, ArrayList<ServerTCPP.Server.Player> players) {
        this.inputStream = inputStream;
        this.players = players;
        try {
            team = (int) inputStream.readObject();
            System.out.println("TEAM: " + team);
            System.out.println(players.size());
            ready = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (ready) {
                for (int i = 0; i < players.size(); i++){
                    Object o = inputStream.readObject();
                    ServerTCPP.Server.Player p = (ServerTCPP.Server.Player)o;
                    players.set(i,p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/** @noinspection InfiniteLoopStatement*/
class SenderThread extends Thread {

    private ObjectOutputStream outputStream;

    SenderThread(ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void run() {
        while (true) {
            try {
                outputStream.writeObject(sendInfo);
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}