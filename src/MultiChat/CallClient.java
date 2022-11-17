package MultiChat;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JPanel;

public class CallClient {
    public void RunChat(JPanel JPcontentPanae,JPanel JHeader,String name) throws IOException {
    	LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String datetimesend = myDateObj.format(myFormatObj);
        
        String username=name;
        Socket socket =new Socket("localhost",1234);
        
        Client client=new Client(socket,username,datetimesend,JPcontentPanae,JHeader);
        client.listenForMessage();
    }
}
