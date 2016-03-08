/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;


/**
 *
 * @author MauroSérgio
 */
public class WebControl implements Closeable //extends Thread
//extends Thread
{   
    //Server inf
    private final int servPort = 444;
    private final String servURL = "localhost";
        
    //Connections
    private Socket servCon = null;
    
    //Buffers
    private BufferedReader inputStr = null;
    private PrintWriter outputStr = null;
    private ObjectInputStream inputObj = null;
    private ObjectOutputStream outputObj = null;    
    
    ///-------------------------------------------------------------------------
    //Contructors
    
    public WebControl() throws IOException{            
            servCon = new Socket(servURL,servPort);
            
            inputStr = new BufferedReader(new InputStreamReader(servCon.getInputStream()));
            outputStr = new PrintWriter(servCon.getOutputStream(),true);
            
            outputObj = new ObjectOutputStream( new BufferedOutputStream(servCon.getOutputStream()));
            outputObj.flush();
            inputObj = new ObjectInputStream( new BufferedInputStream(servCon.getInputStream()) );                        
    }
    
    public WebControl(String url, int port) throws IOException{                    
            servCon = new Socket(url,port);
                       
            inputStr = new BufferedReader(new InputStreamReader(servCon.getInputStream()));
            outputStr = new PrintWriter(servCon.getOutputStream(),true);
            
            outputObj = new ObjectOutputStream( new BufferedOutputStream(servCon.getOutputStream()));
            outputObj.flush();
            inputObj = new ObjectInputStream( new BufferedInputStream(servCon.getInputStream()) );
    }                
        
    public WebControl(Socket sock) throws IOException{                    
            servCon = sock;
                       
            inputStr = new BufferedReader(new InputStreamReader(servCon.getInputStream()));
            outputStr = new PrintWriter(servCon.getOutputStream(),true);
            
            outputObj = new ObjectOutputStream( new BufferedOutputStream(servCon.getOutputStream()));
            outputObj.flush();
            inputObj = new ObjectInputStream( new BufferedInputStream(servCon.getInputStream()) );
    }
    
    //--------------------------------------------------------------------------
    //Comunication
    
    public void sendMsg(String msg) throws IOException{
        outputStr.println(msg);        
    }
    
    public void sendMsgWithFlag(String msg) throws IOException{
        outputStr.println(msg);
        inputStr.readLine();
    }
    
    public String readMsg() throws IOException{        
        return inputStr.readLine();
    }
    
    public String readMsgWithFlag() throws IOException{
        String s = inputStr.readLine();
        outputStr.println("OK");
        return s;        
    }
    
    public void sendObj(Object obj) throws IOException{
        outputObj.writeObject(obj);
        outputObj.flush();//CORRECT?????????
    }
    
    public Object readObj() throws IOException, ClassNotFoundException{
        return inputObj.readObject();
    }
    
    //--------------------------------------------------------------------------
    //Close
    @Override
    public void close() throws IOException{                
        
        if(inputStr != null)
            inputStr.close();
        if(outputStr != null)
            outputStr.close();        
        
        if(inputObj != null)
            inputObj.close();
        if(outputObj != null)
            outputObj.close();
        
        if(servCon != null)
            servCon.close();
    
    }
    
    //--------------------------------------------------------------------------
    //BUFFER
    public boolean isReadyStr() throws IOException{
        return inputStr.ready();
    }
    
}
