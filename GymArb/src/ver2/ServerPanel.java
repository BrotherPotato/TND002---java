package ver2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerPanel extends JPanel implements ActionListener {
    private JTextField textField, textFieldText;
    private int x = 200, y = 200, w = 20, h = 20;
    private ServerSocket serverSocket;
    private Socket server;
    private Thread serverThread;
    private DataOutputStream out;

    private ServerPanel() {
        new Timer(100, this).start();
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(400, 400));
        addComponents();
        serverThread = new Thread(() -> {
            while (true) {
                try {
                    DataInputStream in = new DataInputStream(server.getInputStream());
                    x = in.readByte() + in.readByte();
                    y = in.readByte() + in.readByte();
                } catch (SocketTimeoutException s) {
                    System.out.println("Socket timed out!");
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
    }

    private void addComponents() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 60));
        JButton j = new JButton("Start");
        JButton j2 = new JButton("Stop");
        JButton j3 = new JButton("Send");
        j.addActionListener((e) -> initServer());
        j2.addActionListener((e) -> {
            try {
                if (server != null) server.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        j3.addActionListener((e) -> {
            if (textFieldText.getText() != null) {
                try {
                    out.writeUTF(textFieldText.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        textField = new JTextField("6066", 20);
        textFieldText = new JTextField("Text", 20);
        this.add(j);
        this.add(j2);
        this.add(j3);
        this.add(textField);
        this.add(textFieldText);
    }

    private void initServer() {
        String s = textField.getText();
        int port;
        try {
            port = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return;
        }
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            server = serverSocket.accept();
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress());
            serverThread.start();
        } catch (SocketTimeoutException e) {
            System.out.println("Socket timed out!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int hej() {
        int test = 0;
        return test;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect((x - w / 2) * 2, (y - h / 2) * 2, w, h);
        g.drawString("" + x + " : " + y, 10, 10);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            initFrame(new ServerPanel()).setVisible(true);
        });

    }

    private static Frame initFrame(Component c) {
        JFrame frame = new JFrame();
        frame.add(c);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Server2");
        frame.setResizable(false);
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
