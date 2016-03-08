/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgameserver.normalGame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import web.WebControl;

/**
 *
 * @author MauroSérgio
 */
public class NormalGameControler extends Thread
{
    private int turn;
    private String msg;
    private boolean finish;
    private final WebControl client1;
    private final WebControl client2;
    
    public NormalGameControler(WebControl client1, WebControl client2){
        turn = 1;
        finish = false;
        this.client1 = client1;
        this.client2 = client2;
    }
    
    @Override
    public void run()
    {
        try{
           
            client1.sendMsg("white");//CHECK THIS ON CLIENT            
            client2.sendMsg("black");            
            
            while(!finish)
            {
                if(turn == 1){                    
                    msg = client1.readMsg();
                    if(!msg.equals("finish"))
                        client2.sendMsg(msg);
                    turn = 2;
                }
                else{
                    msg = client2.readMsg();
                    if(!msg.equals("finish"))
                        client1.sendMsg(msg);
                    turn = 1;
                }
                
                if(msg.equals("finish"))                
                    finish = true;
                
            }
            
        }catch(Exception e)
        {
            System.err.println("Error in the run method of GameControler");
            System.err.println(e.toString());
        }finally
        {
            try {
                client1.close();
                client2.close();
            } catch (IOException ex) {
                Logger.getLogger(NormalGameControler.class.getName()).log(Level.SEVERE, null, ex);//QUE PORRA EH ESSA?
            }            
        }
    }    
}
