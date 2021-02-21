package Server;

import WebChat.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends IO {
    private ServerSocket socket;
    private int portNumber = 8000;

    public Server(){
        try {
            socket = new ServerSocket(portNumber);
            System.out.println("Сервер запущен");
            Socket clientSocket = socket.accept();
            System.out.printf("Сервер соединён с клиентом: %s%n", clientSocket.toString());
            setInStream(new DataInputStream(clientSocket.getInputStream()));
            setOutStream(new DataOutputStream(clientSocket.getOutputStream()));
            Thread inThread = new Thread(this::waitMessage);
            inThread.start();
            Thread outThread = new Thread(this::sendMessage);
            outThread.start();

            inThread.join();
            outThread.join();
        }
        catch (IOException | InterruptedException e){
            System.out.printf("Can't initialize server! Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }
    }


}
