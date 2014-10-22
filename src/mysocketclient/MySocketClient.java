package mysocketclient;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class MySocketClient {

    public static void main(String[] args) throws Exception {
        String input;
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Enter the URL: " );
        //input = scan.next();
        //System.out.println("You entered: " + input);

       
        Socket sock;
        PrintWriter out = null;
        BufferedReader buffReader = null;
        
        try {
            sock = new Socket("localhost", 80);
            
            out = new PrintWriter(sock.getOutputStream(), true);     
            out.print("GET /Website1/default.aspx HTTP/1.1\n");
            buffReader = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
            System.out.println(buffReader.read());
            
        }
        catch (UnknownHostException ex) {  
            System.out.println(ex.getMessage());
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }
        finally {
            out.close();
            if (buffReader != null) buffReader.close();
        }
        
    }
    
}
