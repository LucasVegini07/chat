/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Thread.ClientThread;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author lucas
 */
public class Main extends JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        final JFrame gui = this;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                if (!tfUserName.getText().equals("")) {
                    sendMessage("left;" + tfUserName.getText());
                }
                System.exit(0);

            }
        });

        taMessages.setEditable(false);
        btSendToAll.setEnabled(false);
        btInvidualMessage.setEnabled(false);
        btCloseConnection.setEnabled(false);
        tfMessage.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfPort = new javax.swing.JTextField();
        btConnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMessages = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btInvidualMessage = new javax.swing.JButton();
        tfMessage = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbOnlineUsers = new javax.swing.JComboBox<>();
        btSendToAll = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfUserName = new javax.swing.JTextField();
        btCloseConnection = new javax.swing.JButton();
        tfHost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btConnect.setText("Conectar");
        btConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnectActionPerformed(evt);
            }
        });

        taMessages.setColumns(20);
        taMessages.setRows(5);
        jScrollPane1.setViewportView(taMessages);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Sistemas Distruibu??dos - Trabalho Final");

        btInvidualMessage.setText("Enviar Para");
        btInvidualMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInvidualMessageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Afonso U??slei e Lucas Vegini");

        jLabel3.setText("Nome de usu??rio");

        btSendToAll.setText("Enviar mensagem para todos");
        btSendToAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendToAllActionPerformed(evt);
            }
        });

        jLabel4.setText("Host");

        btCloseConnection.setText("Fechar conex??o");
        btCloseConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseConnectionActionPerformed(evt);
            }
        });

        jLabel5.setText("Port");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btSendToAll, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btInvidualMessage)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCloseConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btConnect)
                    .addComponent(jLabel3)
                    .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSendToAll)
                    .addComponent(tfMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInvidualMessage)
                    .addComponent(cbOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCloseConnection)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConnectActionPerformed
        connect();
    }//GEN-LAST:event_btConnectActionPerformed

    private void btInvidualMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInvidualMessageActionPerformed
        if (cbOnlineUsers.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "N??o tem nenhum usu??rio online para enviar mensagem");
            return;
        }

        if (tfMessage.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mensagem n??o pode ser vazia");
            return;
        }

        sendMessage("individual;" + tfUserName.getText() + ";" + cbOnlineUsers.getSelectedItem() + ";" + tfMessage.getText());
    }//GEN-LAST:event_btInvidualMessageActionPerformed

    private void btSendToAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendToAllActionPerformed

        if (tfMessage.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mensagem n??o pode ser vazia");
            return;
        }
        sendMessage("all;" + tfUserName.getText() + ";" + tfMessage.getText());
    }//GEN-LAST:event_btSendToAllActionPerformed

    private void btCloseConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseConnectionActionPerformed
        sendMessage("left;" + tfUserName.getText());
        JOptionPane.showMessageDialog(null, "Voc?? foi desconectado do chat!");
        btInvidualMessage.setEnabled(false);
        btSendToAll.setEnabled(false);
        btCloseConnection.setEnabled(false);
        tfMessage.setEditable(false);
        btConnect.setEnabled(false);

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        cbOnlineUsers.setModel(model);
    }//GEN-LAST:event_btCloseConnectionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public void connect() {
        try {
            Socket socket = new Socket(tfHost.getText(), Integer.parseInt(tfPort.getText()));
            ArrayList<String> activeUsers = new ArrayList();

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            String msg = "validateName;" + tfUserName.getText();
            out.write(msg.getBytes());

            //receive the message
            String receiveMessage;
            byte[] dadosBrutos = new byte[1024];
            int qtdBytesLidos;
            do {
                qtdBytesLidos = in.read(dadosBrutos);
                receiveMessage = new String(dadosBrutos, 0, qtdBytesLidos);
            } while (qtdBytesLidos == dadosBrutos.length);

            String[] parts = receiveMessage.split(";");

            if (parts.length < 1) {
                JOptionPane.showMessageDialog(null, "Retorno inesperado!");
                return;
            }

            if (parts[0].equals("success")) {
                btInvidualMessage.setEnabled(true);
                btSendToAll.setEnabled(true);
                btCloseConnection.setEnabled(true);
                tfMessage.setEditable(true);
                in.close();
                out.close();
                socket.close();
                activeUsers = getActiveUsers();
                ClientThread client = new ClientThread(taMessages, cbOnlineUsers, activeUsers);
                client.start();
            }
            JOptionPane.showMessageDialog(null, parts[1]);

        } catch (ConnectException con) {
            JOptionPane.showMessageDialog(null, "Conex??o recusada");
        } catch (SocketException ex) {
            JOptionPane.showMessageDialog(null, "Conex??o recusada");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getActiveUsers() {
        ArrayList<String> activeUsers = new ArrayList();
        try {

            Socket socket = new Socket(tfHost.getText(), Integer.parseInt(tfPort.getText()));

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            out.write("getOnlineUsers;".getBytes());

            //receive the message
            byte[] dadosBrutos = new byte[1024];
            int qtdBytesLidos = in.read(dadosBrutos);
            String command = new String(dadosBrutos, 0, qtdBytesLidos);

            String[] parts = command.split(";");

            if (command.equals("false")) {
                return activeUsers;
            }

            if (parts.length > 0) {
                for (int i = 0; i < parts.length; i++) {
                    activeUsers.add(parts[i]);
                    DefaultComboBoxModel model = new DefaultComboBoxModel(activeUsers.toArray());
                    cbOnlineUsers.setModel(model);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception");
        }

        return activeUsers;
    }

    public void sendMessage(String msg) {
        try {
            Socket conn = new Socket(tfHost.getText(), Integer.parseInt(tfPort.getText()));
            OutputStream out = conn.getOutputStream();
            out.write(msg.getBytes());
            out.close();
            conn.close();
        } catch (IOException ex) {
            System.out.print("Error");
        }
        tfMessage.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCloseConnection;
    private javax.swing.JButton btConnect;
    private javax.swing.JButton btInvidualMessage;
    private javax.swing.JButton btSendToAll;
    private javax.swing.JComboBox<String> cbOnlineUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taMessages;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfMessage;
    private javax.swing.JTextField tfPort;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables
}
