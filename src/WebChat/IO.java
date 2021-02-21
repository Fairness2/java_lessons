package WebChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public abstract class IO {
    private DataInputStream inStream;
    private DataOutputStream outStream;


    protected DataInputStream getInStream() {
        return inStream;
    }

    protected void setInStream(DataInputStream inStream) {
        this.inStream = inStream;
    }

    protected DataOutputStream getOutStream() {
        return outStream;
    }

    protected void setOutStream(DataOutputStream outStream) {
        this.outStream = outStream;
    }

    protected void waitMessage(){
        while (true){
            try {
                System.out.printf("Входящее сообщение: %s%n", inStream.readUTF());
            }
            catch (IOException e){
                System.out.println("Соединение закрыто");
                return;
            }
        }
    }

    protected void sendMessage(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите сообщение...");
            try {
                String message = scanner.nextLine().trim();
                if (!message.isEmpty()){
                    outStream.writeUTF(message);
                }
            }
            catch (IOException e){
                System.out.println("Соединение закрыто");
                scanner.close();
                return;
            }
        }
    }
}
