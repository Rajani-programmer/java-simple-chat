/*Network Programming: chat_server*/
package newpackage;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class chat_server {
    public static void main(String[] args)
    
    {
        try
        {
            ServerSocket server=new ServerSocket(1794);
            Socket client=server.accept();
            Scanner sc=new Scanner(System.in);
            Scanner in=new Scanner(client.getInputStream());
            PrintWriter out=new PrintWriter(client.getOutputStream(),true);
            String s=" ";
            System.out.println("Client Connected"+"\n");
            do
            {
                s=in.nextLine();
                System.out.println("Client: "+s);
                System.out.println("Server: ");
                s=sc.nextLine();
                out.println(s);
              
            } while(!s.equalsIgnoreCase("Bye"));
              server.close();       
        }
        catch(Exception e)
        {
            System.out.println("Error :"+e);
        }
        
    }
    
}
