/*Network Programming: chat_client*/
package newpackage;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class chat_client {
    public static void main(String[] args)
    {
        try
        {
            Socket server=new Socket("localhost",1794);
            Scanner sc=new Scanner(System.in);
            Scanner in=new Scanner(server.getInputStream());
            PrintWriter out=new PrintWriter(server.getOutputStream(),true);
            String s=" ";
            System.out.println("Connected with server"+"\n");
            do
            {
              System.out.println("Client: ");
              s=sc.nextLine();
              out.println(s);
              s=in.nextLine();
              System.out.println("Server: "+s);
            }while(!s.equalsIgnoreCase("Bye"));
             server.close();
        }
        catch(Exception e)
        {
             System.out.println("Error :"+e);
        }
    }
    
}
