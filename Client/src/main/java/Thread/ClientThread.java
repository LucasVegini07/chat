/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author lucas
 */
public class ClientThread extends Thread {

    private Socket conn;
    private ServerSocket serverSocket;
    private String messages = "Bem vindo ao chat";
    private JTextArea textArea;
    private JComboBox comboBox;
    private ArrayList<String> activeUsers;

    public ClientThread(JTextArea textArea, JComboBox comboBox, ArrayList<String> activeUsers) {
        this.textArea = textArea;
        this.comboBox = comboBox;
        this.activeUsers = activeUsers;
    }

    @Override
    public void run() {
        textArea.setText(this.messages);
        try {
            serverSocket = new ServerSocket(5000);
            while (true) {

                conn = serverSocket.accept();

                InputStream in = conn.getInputStream();

                //receive the message
                byte[] dadosBrutos = new byte[1024];
                int qtdBytesLidos = in.read(dadosBrutos);
                String command = new String(dadosBrutos, 0, qtdBytesLidos);

                String[] parts = command.split(";");

                if (parts.length < 1) {
                    return;
                }

                switch (parts[0]) {
                    case "joined":
                        joined(parts[1]);
                        break;
                    case "left":
                        left(parts[1]);
                        break;
                    default:
                        receivedMessage(parts[1]);
                }
                in.close();
                conn.close();
            }
        } catch (IOException ex) {
            System.out.println("Entrou");

            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void joined(String userName) {
        activeUsers.add(userName);
        setComboBox();
        this.receivedMessage(userName + " entrou para o chat!");
    }

    public void left(String userName) {
        activeUsers.remove(userName);
        this.receivedMessage(userName + " deixou o chat!");
        setComboBox();
    }

    public void setComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(activeUsers.toArray());
        comboBox.setModel(model);
    }

    public void receivedMessage(String message) {
        this.messages = this.messages + "\n\r" + message;
        textArea.setText(this.messages);
    }

}
