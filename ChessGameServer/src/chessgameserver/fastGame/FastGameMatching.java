/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgameserver.fastGame;

import java.net.Socket;
import web.WebControl;

/**
 *
 * @author MauroSérgio
 */
public class FastGameMatching 
{
    private static WebControl client1 = null;
    
    public static void newClient(WebControl newClient)
    {
        if(client1 == null)
        {
            client1 = newClient;
        }
        else
        {
            (new FastGameControler(client1,newClient)).start();
            client1 = null;
        }
    }
    
}
