package Client;

import WebChat.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends IO {
    private Socket socket;
    private int portNumber = 8000;
    private String serverAddress = "localhost";

    public Client() {
        try {
            socket = new Socket(serverAddress, portNumber);
            System.out.println("Клиент запущен");
            setInStream(new DataInputStream(socket.getInputStream()));
            setOutStream(new DataOutputStream(socket.getOutputStream()));
            Thread inThread = new Thread(this::waitMessage);
            inThread.start();
            Thread outThread = new Thread(this::sendMessage);
            outThread.start();

            inThread.join();
            outThread.join();
        }
        catch (IOException | InterruptedException e){
            System.out.printf("Can't initialize client! Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }
    }
}
