/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.IOException;
import web.WebControl;

/**
 *
 * @author Usuario
 */
public class DataBaseControl extends Thread{
    private WebControl web;
    
    public DataBaseControl(WebControl web){
        this.web = web;
    }
    
    @Override
    public void run(){
        try{
            String msg = web.readMsgWithFlag();            
            
            if(msg.equals("login"))
                login();
            
            if(msg.equals("register"))
                register();
            
        }catch(IOException e){
            
        }
    }
    
    private void login(){                
        PlayerDao pd = new PlayerDao();
        
        try{            
            String user = web.readMsgWithFlag();
            String password = web.readMsgWithFlag();
            
            if(pd.existPlayer(user)){
                Player p = pd.findPlayer(user);
                if(password.equals(p.getPassword())){
                    web.sendMsgWithFlag("ok");
                }else{
                    web.sendMsgWithFlag("fail");
                    web.sendMsgWithFlag("wrong password");
                }
            }else{
                web.sendMsgWithFlag("fail");
                web.sendMsgWithFlag("user not exist");
            }
        }catch(IOException e){
            //NOT IMPLEMENTED
            System.err.println("Error in the dbControl");
        }
    }
    
    private void register(){
        Player p = new Player();
        try{
            p.setName(web.readMsgWithFlag());
            p.setPassword(web.readMsgWithFlag());
            p.setUser(web.readMsgWithFlag());
            
            PlayerDao pd = new PlayerDao();
            
            if(pd.existPlayer(p.getUser())){
                web.sendMsgWithFlag("fail");
                web.sendMsgWithFlag("user already exist");
            }else{
                pd.savePlayer(p);
                web.sendMsgWithFlag("ok");
            }
            
        }catch(IOException e){
            //NOT IMPLEMENTED
            System.err.println("Error in the dbControl");
        }
    }
    
}
