/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgameserver;

import chessgameserver.fastGame.FastGameMatching;
import chessgameserver.hpgame.HpGameMatching;
import chessgameserver.normalGame.NormalGameMatching;
import db.DataBaseControl;
import web.WebControl;

/**
 *
 * @author MauroSérgio
 */
public class ClientAdm extends Thread
{
    private WebControl client;    
    
    public ClientAdm(WebControl client){
        this.client = client;
    }
    
    @Override
    public void run()
    {
        try
        {
            String typeMsg;
            typeMsg = client.readMsgWithFlag();            
            
            
            if(typeMsg.equals("normalGame"))
                NormalGameMatching.newClient(client);
                        
            if(typeMsg.equals("fastGame"))            
                FastGameMatching.newClient(client);            
            
            if(typeMsg.equals("hpGame"))            
                HpGameMatching.newClient(client);
            
            if(typeMsg.equals("database"))
                (new DataBaseControl(client)).start();
            
        }catch(Exception e)
        {
            System.err.println("Error in the run method from ClientAdm");
            System.err.println(e.toString());
        }
        
    }
    
}
