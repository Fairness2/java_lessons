package Server.Auth;

import Server.Server;
import WebChat.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends IO {
    private final Server server;
    private final Socket clientSocket;
    private User user;

    public ClientHandler(Server server, Socket clientSocket) throws IOException {
        try {
            this.server = server;
            this.clientSocket = clientSocket;
            setInStream(new DataInputStream(clientSocket.getInputStream()));
            setOutStream(new DataOutputStream(clientSocket.getOutputStream()));
            new Thread(() -> {
                try {
                    run();
                }
                catch (IOException e){
                    server.unsubscribe(this);
                    throw new RuntimeException(e.getMessage(), e);
                }
            }).start();

        }
        catch (IOException | RuntimeException e){
            throw new IOException(e.getMessage(), e);
        }
    }

    protected void run() throws IOException{
        auth();
        waitMessage();
    }

    protected void auth() throws IOException{
        sendMessage("Авторизуйтесь...");
        while (true) {
            String input = getInStream().readUTF();
            if (input.startsWith("-auth")){
                String[] credentials = input.split("\\s");
                if (credentials.length >= 3) {
                    User user = server.getAuthService().findByCredentials(credentials[1], credentials[2]);
                    if (user != null){
                        if (server.isLoginAvailable(user.getLogin())) {
                            this.user = user;
                            server.broadcast(String.format("Пользователь %s вошёл в чат%n", user.getName()));
                            server.subscribe(this);
                            sendMessage("Вы авторизованы");
                            return;
                        }
                        else {
                            sendMessage("Вы уже авторизованы");
                        }
                    }
                    else {
                        sendMessage("Пользователь не найден");
                    }
                }
                else {
                    sendMessage("Авторизационное сообщение должно содержать логин и пароль");
                }
            }
            else {
                sendMessage("Авторизационное сообщение должно начинаться с ключегого слова \"-auth\" и содержать логин и пароль");
            }
        }
    }

    public User getUser() {
        return user;
    }

    @Override
    protected void processIncomingMessage(String message) throws IOException {
        if (message.startsWith("/w")){
            String[] messagePieces = message.split("\\s");
            if (messagePieces.length >= 2) {
                String[] newMessagePieces = new String[messagePieces.length - 2];
                System.arraycopy(messagePieces, 2, newMessagePieces, 0, messagePieces.length - 2);
                String newMessage = String.join(" ", newMessagePieces);
                sendMessage(String.format("%s: %s", user.getName(), message));
                server.sendDirectMessage(messagePieces[1], String.format("%s (только вам): %s", user.getName(), newMessage));
            }
            else {
                sendMessage("Сообщение должно содержать имя пользователя");
            }
        }
        else if (message.startsWith("-close")) {
            server.unsubscribe(this);
            sendMessage("Вы деавторизованы");
            auth();
        }
        else {
            server.broadcast(String.format("%s: %s", user.getName(), message));
        }
    }

}
