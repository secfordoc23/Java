//Program: chatclient
//This: Credential.java
//Date: 4/29/2016
//Author: Jason Welch
//Purpose:

package chatclient;

import com.sun.glass.events.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.net.Socket;

public class ChatClientGUI extends javax.swing.JFrame
{
    Socket serverConnection;
    String username="";
    String password="";
    int portNumber=0;
    ChatReader clientListener;
    
    public ChatClientGUI()
    {
        initComponents();
        displayTextArea.setEditable(false);
        chatTextField.setEditable(false);
        sendButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        serverIPTextField.setText("192.168.1.10");//TODO set back to 127.0.0.1
        portTextField.setText("80");
        
        
        //These are set for easy testing...make sure to remove...
        usernameTextField.setText("Justin");
        clientPasswordField.setText("Test");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverIPTextField = new javax.swing.JTextField();
        usernameTextField = new javax.swing.JTextField();
        portTextField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        clientPasswordField = new javax.swing.JPasswordField();
        sendButton = new javax.swing.JButton();
        chatTextField = new javax.swing.JTextField();
        chatServerIPLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        displayScrollPane = new javax.swing.JScrollPane();
        displayTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Client");
        setName("ChatClientForm"); // NOI18N

        serverIPTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        usernameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        portTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        connectButton.setLabel("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setLabel("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        clientPasswordField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        chatTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chatTextFieldKeyPressed(evt);
            }
        });

        chatServerIPLabel.setText("Chat Server IP:");

        usernameLabel.setText("Username:");

        portLabel.setText("Port Number:");

        passwordLabel.setText("Password:");

        displayTextArea.setColumns(20);
        displayTextArea.setRows(5);
        displayScrollPane.setViewportView(displayTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chatServerIPLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(serverIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel)
                            .addComponent(portLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clientPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(disconnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectButton)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatServerIPLabel)
                    .addComponent(portLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clientPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel)
                            .addComponent(passwordLabel))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(displayScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendButton)
                    .addComponent(chatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        PrintWriter toServerMessage;
        //Connect to chat server and send credentials.
        try {
            //Make sure to close last server connection if one is still open
            if(null != serverConnection) {
                serverConnection.close();
            }
            
            //Get server connection information from GUI
            String ipAddress = serverIPTextField.getText();
            int socketNum = 0;
            try{
                socketNum = Integer.parseInt(portTextField.getText());
            }
            catch (Exception ex) {
                displayTextArea.append("ERROR: Port Number is not valid.\n");
            }
            serverConnection = new Socket(ipAddress, socketNum);
            
            //Clear the text area on connection
            displayTextArea.setText("");
            
            //Spawn thread for listener
            clientListener = new ChatReader(serverConnection);
            Thread readerThread = new Thread(clientListener);
            readerThread.start();
            
            //Output stream to server
            PrintWriter toServer = new PrintWriter(serverConnection.getOutputStream());
            
            //Get credentials from GUI
            username = usernameTextField.getText();
            password = String.valueOf(clientPasswordField.getPassword());
            
            //Send credentials to the server
            toServer.println(username+" "+password);
            toServer.flush();
            
            //Wait for response from server on connection...
            sleep(1000);
            
            //If listener thread was not closed by a server response... 
            if(readerThread.isAlive()) {
                toServerMessage = new PrintWriter(serverConnection.getOutputStream());
                toServerMessage.println("SERVER: "+username+" is connected.");
                toServerMessage.flush();

                //Modify client UI for connected state
                connectedToServer();
            }
        }
        catch (Exception ex){
            //Print exception to text area
            displayTextArea.append("ERROR: Failed to connect to server...\n");
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        PrintWriter toServerMessage;
        try {
            if(null != serverConnection) {
                toServerMessage = new PrintWriter(serverConnection.getOutputStream());
                toServerMessage.println("SERVER: "+username+" has disconnected.");
                toServerMessage.flush();
                serverConnection.close();
            }
        } catch (Exception ex) {
            System.err.println("Failed to post disconnection message...");
        }
        username="";
        password="";
        portNumber=0;
        //Reset text area and display disconnect message.
        displayTextArea.setText("");
        displayTextArea.append("You have disconnected from the server.\n");
        
        //Modify client UI for disconnected state
        disconnectedFromServer();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendEvent();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void chatTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chatTextFieldKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            sendEvent();
        }
    }//GEN-LAST:event_chatTextFieldKeyPressed

    private void sendEvent() {
        if(sendButton.isEnabled()) {
            String message = chatTextField.getText();
            PrintWriter toServerMessage;
            try {
                toServerMessage = new PrintWriter(serverConnection.getOutputStream());
                toServerMessage.println(username+": "+message);
                toServerMessage.flush();
                chatTextField.setText("");
            } catch (IOException ex) {
                displayTextArea.append("ERROR: Failed to send message...\n");
            }
        }
    }
    
    //====================== appendTextArea ==========================
    public void appendTextArea(String message)
    {
        displayTextArea.append(message + "\n");  
    }
    
    //====================== disconnectedFromServer ==========================
    public void disconnectedFromServer() {
        chatTextField.setEditable(false);
        sendButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        connectButton.setEnabled(true);
    }
    
    //====================== connectedToServer ==========================
    public void connectedToServer() {
        chatTextField.setEditable(true);
        sendButton.setEnabled(true);
        disconnectButton.setEnabled(true);
        connectButton.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chatServerIPLabel;
    private javax.swing.JTextField chatTextField;
    private javax.swing.JPasswordField clientPasswordField;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JScrollPane displayScrollPane;
    private javax.swing.JTextArea displayTextArea;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField serverIPTextField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
