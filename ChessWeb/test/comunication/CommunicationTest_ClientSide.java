/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunication;

import java.io.IOException;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import web.MsgId;
import web.WebControl;
import web.WebMsg;

/**
 *
 * @author Rodrigo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommunicationTest_ClientSide {
    
    /*
    *BRIEF: IT TEST THE COMMUNICATION CRETED WITH THE WEBCONTROL
    *SO IT HAS TO RUN WITH THE CommunicationTest_ServerSide FILE
    *NOTE: START THE SERVER SIDE FIRST
    */
    
    private static WebControl wc = null;
    
    @BeforeClass
    public static void setup(){
        try{
            wc = new WebControl();
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @AfterClass
    public static void tearDown() {        
        try{            
            if(wc != null)
                wc.close();
        }catch(IOException e){
           fail(e.toString()); 
        }        
    }
    
    @Test
    public void T1_sendMsg(){
        try{
            wc.sendMsg("Hi, im the client");
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T2_readMsg(){
        try{            
            assertEquals("Hi, im the server",wc.readMsg());
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T3_comunication(){
        try{            
            wc.sendMsg("Client: Hi, Im the client");
            assertEquals("Server: Hi client, Im the server, nice to meet you",wc.readMsg());
            wc.sendMsg("Client: Nice to meet you too");
            assertEquals("Server: Lets work together and don't have more bugs",wc.readMsg());
            wc.sendMsg("Client: I agree, no more BUGSSS");
            assertEquals("Server: NO MORE BUGSSS",wc.readMsg());            
        }catch(IOException e){
            fail(e.toString());
        }
    }
    
    @Test
    public void T4_sendSimpleObj(){
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
    public void T5_readSimpleObj(){
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
    public void T6_sendComplexObj(){
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
    public void T7_readComplexObj(){ // CHECK THIS LATER
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
