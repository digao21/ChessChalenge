/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Rodrigo
 */
public class WebMsg implements Serializable {
    private final MsgId id;
    private final Queue<String> msgs  = new LinkedList<>();
    private Object obj; //Don't know if it gonna work
    
    public WebMsg(MsgId cod){
        id = cod;        
    }
    
    public MsgId getId(){
        return id;
    }
    
    public void addMsg(String msg){
        msgs.add(msg);
    }
    
    public String getMsg(){
        return msgs.remove();        
    }
    
    public int getTotalMsg(){
        return msgs.size();
    }    
    
    public void setObj(Object ob){        
        obj = ob;
    }
    
    public Object getObj(){
        return obj;
    }
    
    @Override
    public boolean equals(Object obj){
        
        if(!(obj instanceof WebMsg))
            return false;
        
        WebMsg wm = (WebMsg) obj;
        
        if(wm.getId() != getId())
            return false;
        
        if(!wm.msgs.equals(msgs))
            return false;
        
        if(wm.getObj() != null)
            if(!wm.getObj().equals(getObj()))
                return false;
            
        return true;        
    }
    
    @Override
    public int hashCode(){        // NOT SURE IF ITS CORRECT - HASH FUNC ARE HARD
        return msgs.hashCode();   // UNTESTED             
    }
    
}
