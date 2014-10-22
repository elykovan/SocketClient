package mysocketclient;

import java.util.Scanner;
import java.net.*;
import java.io.*;


public class MySocketClient {

    public static void main(String[] args) throws Exception {
        /*
        Socket socket = new Socket("cdn.wennermedia.net", 80);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //Send request
        out.println("GET /jquery/latest/jquery.min.js HTTP/1.0\r\n\r\n");
        out.flush();

        //Read one line of input
        System.out.println("Response " + in.readLine());        
        */
        String input;
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Enter the URL: " );
        //input = scan.next();
        //System.out.println("You entered: " + input);

       
        Socket sock = null;
        PrintStream out = null;
        BufferedReader buffReader = null;
        DataOutputStream outStream = null;
                       
        
        try {
            sock = new Socket("google.com", 80);
            
            //out = new PrintStream(sock.getOutputStream(), true);     
            outStream = new DataOutputStream(sock.getOutputStream());
            outStream.writeBytes("GET /index.html HTTP/1.0\r\n\r\n");
            outStream.flush();
            buffReader = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
            
            String result = null;
            
            while((result = buffReader.readLine()) != null) {
                System.out.println(result);
            }
        }
        catch (UnknownHostException ex) {  
            System.out.println(ex.getMessage());
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }
        finally {
            //out.close();
            if (outStream != null) outStream.close();
            if (buffReader != null) buffReader.close();
            if (sock != null) sock.close();
        }
        
    }
    
}
