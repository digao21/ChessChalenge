/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgameserver.hpgame;

import chessgameserver.normalGame.NormalGameControler;
import web.WebControl;

/**
 *
 * @author Usuario
 */
public abstract class HpGameMatching {
    private static WebControl client1 = null;
    
    public static void newClient(WebControl newClient)
    {
        if(client1 == null){        
            client1 = newClient;
        }
        else{
            (new HpGameControler(client1,newClient)).start();
            client1 = null;
        }
    }
}
