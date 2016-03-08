package Web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.ServerSocket;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import web.MsgId;
import web.WebControl;
import web.WebMsg;

/**
 *
 * @author Rodrigo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Transmission {
    
    /*
    *BRIEF: IT TEST THE COMMUNICATION CRETED WITH THE WEBCONTROL
    *SO IT HAS TO RUN WITH THE TRANSMISSION FILE IN THE CLIENT
    *NOTE: RUN START THE SERVER SIDE FIRST
    */
    
    private static ServerSocket servSock = null;
    private static WebControl wc = null;
    
    public Transmission() {
    }
    
    @BeforeClass
    public static void setup() {
        try{
            servSock = new ServerSocket(444);
            wc = new WebControl(servSock.accept());
        }catch(IOException e){            
            fail(e.toString());
        }
    }
    
    @AfterClass
    public static void tearDown() {        
        try{
            if(servSock != null)
                servSock.close();
            if(wc != null)
                wc.close();
        }catch(IOException e){
           fail(e.toString()); 
        }        
    }        

    @Test
    public void T1_readMsg(){
        try{            
            assertEquals("Hi, im the client", wc.readMsg());
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T2_sendMsg(){
        try{            
            wc.sendMsg("Hi, im the server");            
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T3_comunication(){
        try{                        
            assertEquals("Client: Hi, Im the client",wc.readMsg());
            wc.sendMsg("Server: Hi client, Im the server, nice to meet you");
            assertEquals("Client: Nice to meet you too",wc.readMsg());
            wc.sendMsg("Server: Lets work together and don't have more bugs");
            assertEquals("Client: I agree, no more BUGSSS",wc.readMsg());            
            wc.sendMsg("Server: NO MORE BUGSSS");                        
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T4_readSimpleObj(){
        try{
            WebMsg wm = new WebMsg(MsgId.help);
            wm.addMsg("Hi");
            wm.addMsg("How are you");
            assertEquals(wm, wc.readObj());
        }catch(ClassNotFoundException|IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T5_sendSimpleObj(){
        try{
            WebMsg wm = new WebMsg(MsgId.help);
            wm.addMsg("Hi");
            wm.addMsg("How are you");
            wc.sendObj(wm);
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T6_readComplexObj(){ // CHECK THIS LATER
        try{
            WebMsg wm = new WebMsg(MsgId.help);
            wm.addMsg("Hi");
            wm.addMsg("How are you");
            wm.setObj(new Integer(1));
            assertEquals(wm, wc.readObj());
        }catch(ClassNotFoundException|IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T7_sendComplexObj(){
        try{
            WebMsg wm = new WebMsg(MsgId.help);
            wm.addMsg("Hi");
            wm.addMsg("How are you");
            wm.setObj(new Integer(1));
            wc.sendObj(wm);
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T8_simpleObjConversation(){
        try{
            WebMsg wm = new WebMsg(MsgId.help);
            wm.addMsg("Msg 1.1");                        
            wc.sendObj(wm);
            assertEquals(wm, wc.readObj());
            
            wm = new WebMsg(MsgId.login);
            wm.addMsg("Msg 2.1");
            wm.addMsg("Msg 2.2");            
            wc.sendObj(wm);
            assertEquals(wm, wc.readObj());
            
            wm = new WebMsg(MsgId.logout);
            wm.addMsg("Msg 3.1");
            wm.addMsg("Msg 3.2");
            wm.addMsg("Msg 3.3");
            wc.sendObj(wm);
            assertEquals(wm, wc.readObj());
            
        }catch(ClassNotFoundException|IOException e){
            fail(e.toString());
        }
    }
    
    public void T8_complexObjConversation(){
        try{
            WebMsg wm = new WebMsg(MsgId.help);
            wm.addMsg("Msg 1.1");                        
            wm.setObj(new Integer(1));
            wc.sendObj(wm);
            assertEquals(wm, wc.readObj());
            
            wm = new WebMsg(MsgId.login);
            wm.addMsg("Msg 2.1");
            wm.addMsg("Msg 2.2");            
            wm.setObj(new Integer(1));
            wc.sendObj(wm);
            assertEquals(wm, wc.readObj());
            
            wm = new WebMsg(MsgId.logout);
            wm.addMsg("Msg 3.1");
            wm.addMsg("Msg 3.2");
            wm.addMsg("Msg 3.3");
            wm.setObj(new Integer(1));
            wc.sendObj(wm);
            assertEquals(wm, wc.readObj());
            
        }catch(ClassNotFoundException|IOException e){
            fail(e.toString());
        }
    }
    
}
