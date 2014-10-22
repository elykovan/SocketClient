package mysocketclient;

import java.util.Scanner;
import java.net.*;
import java.io.*;


public class MySocketClient {

    public static void main(String[] args) throws Exception {
        //String input;
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Enter the URL: " );
        //input = scan.next();
        //System.out.println("You entered: " + input);
       
        Socket sock = null;
        PrintStream out = null;
        BufferedReader in = null;
                       
        
        try {
            sock = new Socket("localhost", 80);
            out = new PrintStream(sock.getOutputStream(), true);     
            in = new BufferedReader(new InputStreamReader(sock.getInputStream())); 

            out.print("GET /Website1/ HTTP/1.1\n");
            out.print("Host: localhost\n\n");
            out.flush();
            
            // In the real client, I would have to use the Content-Length header to know the end of HTTP response stream is reached
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            System.exit(0); // this line is never reached 
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            if (out != null) out.close();
            if (in != null) in.close();
            if (sock != null) sock.close();
        }
        
    }
    
}
