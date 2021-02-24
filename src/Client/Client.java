package Client;

import WebChat.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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
            Thread inThread = new Thread(() -> {
                try {
                    waitMessage();
                }
                catch (IOException e){
                    System.out.println("Соединение закрыто");
                }
            });
            inThread.start();
            Thread outThread = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Введите сообщение...");
                    try {
                        String message = scanner.nextLine().trim();
                        if (!message.isEmpty()) {
                            sendMessage(message);
                        }
                    } catch (IOException e) {
                        System.out.println("Соединение закрыто");
                        scanner.close();
                        return;
                    }
                }
            });
            outThread.start();

            inThread.join();
            outThread.join();
        }
        catch (IOException | InterruptedException e){
            System.out.printf("Can't initialize client! Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    protected void processIncomingMessage(String message) {
        System.out.println(message);
    }
}
