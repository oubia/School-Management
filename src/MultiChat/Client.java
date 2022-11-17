package MultiChat;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
//created by anass nassiri isil

public class Client extends JFrame implements ActionListener {
    private Socket socket;
    private BufferedReader bufferedReader;
    public BufferedWriter bufferedWriter;
    private String username;
    private String datetimesend;

    ////////////////////////////////

    JButton sendbutton;
    JTextField messagefield;
    JTextArea chatarea;	
    JPanel JPcontentPanae = new JPanel();
	JPanel JHeader = new JPanel();

    public Client(Socket socket, String username , String datetimesend,JPanel JPcontentPanae,JPanel JHeader){
		this.JPcontentPanae = JPcontentPanae;
		this.JHeader = JHeader;

		this.JPcontentPanae.removeAll();
		this.JPcontentPanae.revalidate();
		this.JPcontentPanae.repaint();
		this.JPcontentPanae.setLayout(null);
		
		this.JHeader.removeAll();
		this.JHeader.revalidate();
		this.JHeader.repaint();
		this.JHeader.setLayout(null);
		
    	sendbutton=new JButton("Envoyer");
        messagefield=new JTextField();
        chatarea=new JTextArea();
        

        messagefield.setBounds(50, 400, 300, 30);
        sendbutton.setBounds(380,400,100,30);
        sendbutton.setBackground(getBackgroundPurpol());
        sendbutton.setForeground(getBackgroundWhite());
		
        chatarea.setBounds(50, 20, 430, 360);
        chatarea.setBorder(BorderFactory.createLineBorder(getBackgroundPurpol()));
        chatarea.setForeground(getBackgroundPurpol());
        sendbutton.addActionListener(this);
        
        JScrollPane scrolll= new JScrollPane(chatarea);
        scrolll.setBounds(50, 20, 430, 360);                  

        this.JPcontentPanae.add(scrolll);
        this.JPcontentPanae.add(messagefield);
        this.JPcontentPanae.add(sendbutton);
       
        
        try {
            this.socket=socket;
            this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username=username;
            this.datetimesend=datetimesend;

        }
        catch (IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }
    public void  sendMessage(String mesg){
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write(""+mesg+""+datetimesend);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        }
        catch (IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }

    }
    public  void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;

                while (socket.isConnected()){
                    try {
                        msgFromGroupChat=bufferedReader.readLine();
                        setAreaMessage(msgFromGroupChat);
                        System.out.println(msgFromGroupChat);
                    }
                    catch (IOException e){
                        closeEverything(socket,bufferedReader,bufferedWriter);
                    }

                }
            }
        }).start();
    }
    public void closeEverything(Socket socket ,BufferedReader bufferedReader,BufferedWriter bufferedWriter){
        try {
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public String getAreaMessage(){
        String text=this.chatarea.getText().trim() + "\n";
        return text;
    };
    public void setAreaMessage(String message){
        message+="\n";
        this.chatarea.setText(getAreaMessage()+"\n"+message);

    };

    public String getFieldMessage(){
        String text=this.messagefield.getText().trim() + "\n";
        return text;
    };
    private Color getBackgroundWhite() {
		return Color.white;
	}
	public Color getBackgroundPurpol() {
    	return new java.awt.Color(63, 42, 100);
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendbutton) {
            setAreaMessage(getFieldMessage());
            this.sendMessage(getFieldMessage());
            messagefield.setText("");
        }
    }
}
