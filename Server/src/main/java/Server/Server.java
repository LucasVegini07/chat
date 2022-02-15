package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static Map<String, String> clients = new HashMap<String, String>();
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o numero da porta que deseja se conectar");
        try {
            serverSocket = new ServerSocket(Integer.parseInt(scanner.nextLine()));
            System.out.println("waiting for connection...");
            while (true) {
                Socket conn = serverSocket.accept();

                System.out.println("connected with: " + conn.getInetAddress().getHostAddress());

                InputStream in = conn.getInputStream();
                OutputStream out = conn.getOutputStream();

                //receive the message
                byte[] dadosBrutos = new byte[1024];
                int qtdBytesLidos = in.read(dadosBrutos);
                String command = new String(dadosBrutos, 0, qtdBytesLidos);

                String[] parts = command.split(";");

                if (parts.length < 1) {
                    out.write("error;Command must be divided by a semicolon!".getBytes());
                    return;
                }

                switch (parts[0]) {
                    case "validateName":
                        out.write(validateName(conn.getInetAddress().getHostAddress(), parts[1]).getBytes());
                        break;
                    case "getOnlineUsers":
                        out.write(getOnlineUsers(conn.getInetAddress().getHostAddress()).getBytes());
                        break;
                    case "joined":
                        joined(parts[1]);
                        break;
                    case "left":
                        left(parts[1]);
                        break;
                    case "individual":
                        IndividualMessage(command);
                        break;
                    case "all":
                        newMessageForEveryone(command);
                        break;
                }
                in.close();
                out.close();
                conn.close();
            }

        } catch (NumberFormatException ex) {
            System.out.println("Enter a valid port number");
        } catch (BindException ex) {
            System.out.println("Port is already in use");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String validateName(String ip, String userName) {

        if (clients.containsValue(userName)) {
            return "error;Name is already in use ";
        }

        clients.put(ip, userName);
        joined(userName);
        return "success;You are connected";
    }

    public static void joined(String userName) {

        String msg = "joined;" + userName;
        for (Map.Entry<String, String> client : clients.entrySet()) {
            if (!client.getValue().equals(userName)) {
                sendMessage(client.getKey(), msg);
            }
        }
    }

    public static void left(String userName) {

        String msg = "left;" + userName;
        for (Map.Entry<String, String> client : clients.entrySet()) {
            if (!client.getValue().equals(userName)) {
                sendMessage(client.getKey(), msg);
            }
        }

        clients.entrySet()
                .removeIf(
                        entry -> (userName
                                .equals(entry.getValue())));
    }

    public static void IndividualMessage(String mensagem) {
        String[] parts = mensagem.split(";");

        String issuer = "message;Você enviou para " + parts[2] + ": " + parts[3];
        String receiver = "message;" + parts[1] + " enviou para você: " + parts[3];

        for (Map.Entry<String, String> client : clients.entrySet()) {
            if (client.getValue().equals(parts[1])) {
                sendMessage(client.getKey(), issuer);
            }
            if (client.getValue().equals(parts[2])) {
                sendMessage(client.getKey(), receiver);
            }
        }
    }

    public static void newMessageForEveryone(String mensagem) throws IOException {

        String[] parts = mensagem.split(";");
        String issuer = "message;Você enviou para todos: " + parts[2];
        String receiver = "message;" + parts[1] + " enviou para todos: " + parts[2];

        for (Map.Entry<String, String> client : clients.entrySet()) {
            if (client.getValue().equals(parts[1])) {
                sendMessage(client.getKey(), issuer);
            } else {
                sendMessage(client.getKey(), receiver);
            }
        }

    }

    public static void sendMessage(String ip, String msg) {
        Socket conn;

        try {
            conn = new Socket(ip, 5000);
            OutputStream out = conn.getOutputStream();
            out.write(msg.getBytes());
        } catch (IOException ex) {
            System.out.println("Error" + ip);
        }
    }

    public static String getOnlineUsers(String ip) {
        String msg = "";

        if (clients.size() == 1) {
            return "false";
        }
        for (Map.Entry<String, String> client : clients.entrySet()) {
            if (!client.getKey().equals(ip)) {
                msg = msg + client.getValue() + ";";
            }
        }

        return msg;
    }

}
