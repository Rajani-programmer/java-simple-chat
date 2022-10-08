
package newpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;


    
   public class Addition_server extends Thread
  {
   private ServerSocket serverSocket;

    public Addition_server(int port) throws IOException
   {
    serverSocket = new ServerSocket(port);
     serverSocket.setSoTimeout(100000);
    }

   @Override
    public void run()
    {
    while(true)
      {
     try
     {
        System.out.println("Waiting for client on port " +
        serverSocket.getLocalPort() + "...");
        Socket server = serverSocket.accept();
        System.out.println("Just connected to "+ server.getRemoteSocketAddress());
     DataInputStream in =new DataInputStream(server.getInputStream());

   Integer x=in.readInt();
   System.out.println("Hellox");
   Integer y=in.readInt();
    System.out.println("Helloy");

        Integer sum = ( x + y );
        DataOutputStream out =
             new DataOutputStream(server.getOutputStream());
      out.writeInt(sum);

        server.close();
     }catch(SocketTimeoutException s)
     {
        System.out.println("Socket timed out!");
        break;
     }catch(IOException e)
     {
        e.printStackTrace();
        break;
     }
    }
   }
     public static void main(String [] args)
       {

  Scanner sc= new Scanner(System.in);
  System.out.println("Please specify a port number (1~65535): ");
  String port;
  port = sc.next(); 

  try
  {
     Thread t = new Addition_server(Integer.parseInt(port));
     t.start();
  }catch(IOException e)
  {
     e.printStackTrace();
     }
    }
      }
    

