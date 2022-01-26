package udpTest;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPTest {
    EchoClient client;


    public void setup(){
        try {
            new EchoServer().start();;
            //new EchoClient().start();
        } catch (SocketException  e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        System.out.println("startar");
        new UDPTest().setup();
    }
}