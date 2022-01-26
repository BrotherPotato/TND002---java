package ver2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.net.Socket;

//hej
public class ClientPanel extends JPanel implements KeyListener, ActionListener {
    private JTextField textField,ipTextField,textTextField;
    private int x=200,y=200,w=20,h=20;
    private float dx,dy;
    private static int PORT;
    private static String IP;
    private static DataOutputStream out;
    private Socket client;
    private Thread clientThread;

    private ClientPanel(){
        this.setFocusable(true);
        new Timer(100,this).start();
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(400,400));
        addComponents();
        clientThread = new Thread(()-> {
            while (true) {
                try {
                    InputStream inFromServer = client.getInputStream();
                    DataInputStream in = new DataInputStream(inFromServer);
                    System.out.println("Server2 says: " + in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                    out = null;
                    break;
                }
            }
        });
    }

    private void addComponents() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,60));
        JButton j = new JButton("Start");
        JButton j2 = new JButton("Stop");
        JButton j3 = new JButton("Send");
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initClient();
            }
        });
        j2.addActionListener((e)->{
            if(client!=null) {
                try {
                    client.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        j3.addActionListener((e)->{
            if(textTextField.getText()!=null){
                try {
                    out.writeUTF(textTextField.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        textField = new JTextField("6066",20);
        ipTextField = new JTextField("localhost",20);
        textTextField = new JTextField("Text",20);
        this.add(j);
        //this.add(j2);
        //this.add(j3);
        //this.add(textField);
        //this.add(ipTextField);
        //this.add(textTextField);
    }

    private void initClient() {
        //String s = textField.getText();
        //String ip = ipTextField.getText();
        //int port;
        //try {
        //    port = Integer.valueOf(s);
        //} catch (NumberFormatException e){
        //    return;
        //}
        try {
            System.out.println("Connecting to " + IP + " on port " + PORT);
            client = new Socket(IP, PORT);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);

            clientThread.start();
        } catch (IOException e) {
            System.out.println("Can't connect");
            return;
        }
        this.remove(this.getComponent(0));
        repaint();
    }

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            IP = args[0];
            PORT = Integer.parseInt(args[1]);
            initFrame(new ClientPanel()).setVisible(true);
        });

    }
    private static Frame initFrame(Component c){
        JFrame frame = new JFrame();
        frame.add(c);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Client");
        frame.setResizable(false);
        return frame;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect((x-w/2)*2,(y-h/2)*2,w,h);
        g.drawString(""+x+" : "+ y,10,10);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
        x+=dx;
        y+=dy;
        if(out==null)return;
        try {
            out.write(new byte[]{127,(byte)( x-127),127,(byte)(y-127)});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        if(key==KeyEvent.VK_A){
            dx-=6;
        } else if(key==KeyEvent.VK_W){
            dy-=6;
        } else if(key==KeyEvent.VK_S){
            dy+=6;
        } else if(key==KeyEvent.VK_D){
            dx+=6;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
