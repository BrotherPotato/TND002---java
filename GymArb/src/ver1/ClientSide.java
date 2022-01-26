package ver1;

import java.net.*;
import java.io.*;

public class ClientSide   {
    private static DataOutputStream out;
    public static void main(String [] args) {
        String serverName = "localhost";
        int port = 6066;
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);

            out.writeUTF("Xpos: 30, Ypos: 40, Width: 20, Height: 20" );
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server2 says " + in.readUTF());
            client.close();
            System.out.println("exit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}