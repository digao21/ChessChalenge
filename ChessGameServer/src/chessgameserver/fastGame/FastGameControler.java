/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgameserver.fastGame;

import pieces.Board;
import web.WebControl;

/**
 *
 * @author MauroSérgio
 */
public class FastGameControler extends Thread
{
    private boolean running;
    private String msg;
    private Board board;
    private WebControl client1;
    private WebControl client2;
    
    public FastGameControler(WebControl client1, WebControl client2)
    {
        running = true;
        board = new Board(new char[][]{
            {'/','/','/','/','/','/','/','/','/','/'},
            {'/','R','N','B','K','Q','B','N','R','/'},
            {'/','P','P','P','P','P','P','P','P','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','p','p','p','p','p','p','p','p','/'},
            {'/','r','n','b','k','q','b','n','r','/'},
            {'/','/','/','/','/','/','/','/','/','/'},
        });
        
        this.client1 = client1;
        this.client2 = client2;
        
        
    }    
    
    @Override
    public void run()
    {
        try{            
            client1.sendMsg("white");
            client2.sendMsg("black");
            
            while(running)
            {
                if(client1.isReadyStr()){
                    msg = client1.readMsg();                    
                    if(msgAct(msg)){                        
                        client1.sendMsg(msg);
                        client2.sendMsg(msg);                        
                    }
                }
                
                if(running && client2.isReadyStr()){
                    msg = client2.readMsg();                    
                    if(msgAct(msg)){                        
                        client1.sendMsg(msg);
                        client2.sendMsg(msg);                        
                    }
                }
                
                Thread.sleep(25);
            }
            
        }catch(Exception e)
        {
            
        }
        finally
        {
            
        }
    }
    
    private boolean msgAct(String msg)
    {
        boolean answ = false;                        
                
        int I1,J1,I2,J2;
        I1 = msg.charAt(0) - '0';
        J1 = msg.charAt(1) - '0';
        I2 = msg.charAt(2) - '0';
        J2 = msg.charAt(3) - '0';
        
        if(board.isOccupie(I1,J1)){
            if(board.canMoveTo(I1,J1,I2, J2)){                                
               running = !board.isKing(I2, J2);
               board.moveTo(I1,J1,I2, J2); 
               answ = true;
            }
            else{
                System.out.println(msg.concat(" cant move"));
            }
        }
        else{
            System.out.println(msg.concat(" is not occupied"));
        }
        
        return answ;
    }
    
}
