/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgameserver;


import db.ConnectionFactory;
import java.io.IOException;
import java.net.ServerSocket;
import web.WebControl;

/**
 *
 * @author MauroSérgio
 */
public abstract class Controler
{   
    private static boolean running;
    private static ServerSocket serverSocket;    
    
    private static void init() throws IOException{
        ConnectionFactory.initialize();
        running = true;
        serverSocket = new ServerSocket(444);        
    }
    
    public static void start() throws IOException
    {
        try
        {
            init();
            while(running)
            {                
                (new ClientAdm(new WebControl(serverSocket.accept()))).start();
            }
        }catch(Exception e)
        {
            System.err.println("Error in the start method of Controler");
            System.err.println(e.toString());
        }
        finally
        {
            serverSocket.close();
        }
    }
}
