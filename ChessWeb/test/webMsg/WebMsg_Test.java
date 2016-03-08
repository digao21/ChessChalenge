/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webMsg;

import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import web.MsgId;
import web.WebMsg;

/**
 *
 * @author Rodrigo
 */
public class WebMsg_Test {
    
    @Test
    public void idTest(){
        WebMsg wb = new WebMsg(MsgId.login);
        assertEquals(MsgId.login,wb.getId());
        
        wb = new WebMsg(MsgId.logout);
        assertEquals(MsgId.logout,wb.getId());
        
        wb = new WebMsg(MsgId.help);
        assertEquals(MsgId.help,wb.getId());
    }
    
    @Test
    public void singleMsgTest(){
        WebMsg wb = new WebMsg(MsgId.login);
        wb.addMsg("Test 1");
        assertEquals("Test 1",wb.getMsg());
    }    
    
    @Test
    public void multipleMsgTest(){
        WebMsg wb = new WebMsg(MsgId.login);
        wb.addMsg("Test 0");
        wb.addMsg("Test 1");
        wb.addMsg("Test 2");
        wb.addMsg("Test 3");
        wb.addMsg("Test 4");
        wb.addMsg("Test 5");
        wb.addMsg("Test 6");
        wb.addMsg("Test 7");
        wb.addMsg("Test 8");
        wb.addMsg("Test 9");        
        assertEquals("Test 0",wb.getMsg());
        assertEquals("Test 1",wb.getMsg());
        assertEquals("Test 2",wb.getMsg());
        assertEquals("Test 3",wb.getMsg());
        assertEquals("Test 4",wb.getMsg());
        assertEquals("Test 5",wb.getMsg());
        assertEquals("Test 6",wb.getMsg());
        assertEquals("Test 7",wb.getMsg());
        assertEquals("Test 8",wb.getMsg());
        assertEquals("Test 9",wb.getMsg());        
    }
    
    @Test(expected = NoSuchElementException.class)
    public void emptyMsgTest(){
        WebMsg wb = new WebMsg(MsgId.login);
        String aux = wb.getMsg();
    }
    
    @Test
    public void totalMsgTest(){
        WebMsg wb = new WebMsg(MsgId.login);
        wb.addMsg("Test 0");
        wb.addMsg("Test 1");
        wb.addMsg("Test 2");
        wb.addMsg("Test 3");
        wb.addMsg("Test 4");
        wb.addMsg("Test 5");
        wb.addMsg("Test 6");
        wb.addMsg("Test 7");
        wb.addMsg("Test 8");
        wb.addMsg("Test 9");
        assertEquals(10,wb.getTotalMsg());
    }
    
    @Test
    public void objSetGetTest(){
        WebMsg wb = new WebMsg(MsgId.login);
        
        Object ob = new Object();
        wb.setObj(ob);
        assertEquals(ob,wb.getObj());
        
        ob = new Object();
        wb.setObj(ob);
        assertEquals(ob,wb.getObj());
    }
    
    @Test
    public void equalsTest(){
        WebMsg wbA = new WebMsg(MsgId.login);
        WebMsg wbB = new WebMsg(MsgId.login);
        
        wbA.addMsg("Msg 1");
        wbB.addMsg("Msg 1");
        
        wbA.addMsg("Msg 2");
        wbB.addMsg("Msg 2");
        
        wbA.addMsg("Msg 3");
        wbB.addMsg("Msg 3");
                
        wbA.setObj(new Integer(1));
        wbB.setObj(new Integer(1));
                       
        assertEquals(wbA,wbB);
    }
    
    @Test(expected=AssertionError.class)    
    public void equalsFailTest1(){
        WebMsg wbA = new WebMsg(MsgId.login);
        WebMsg wbB = new WebMsg(MsgId.logout);
        
        wbA.addMsg("Msg 1");
        wbB.addMsg("Msg 1");
        
        wbA.addMsg("Msg 2");
        wbB.addMsg("Msg 2");
        
        wbA.addMsg("Msg 3");
        wbB.addMsg("Msg 3");
                
        wbA.setObj(new Integer(1));
        wbB.setObj(new Integer(1));
                       
        assertEquals(wbA,wbB);
    }
    
    @Test(expected=AssertionError.class)    
    public void equalsFailTest2(){
        WebMsg wbA = new WebMsg(MsgId.login);
        WebMsg wbB = new WebMsg(MsgId.login);
        
        wbA.addMsg("Msg 1");
        wbB.addMsg("Msg 1");
        
        wbA.addMsg("Msg 2");
        wbB.addMsg("Msg 3");
        
        wbA.addMsg("Msg 3");
        wbB.addMsg("Msg 2");
                
        wbA.setObj(new Integer(1));
        wbB.setObj(new Integer(1));
                       
        assertEquals(wbA,wbB);
    }
    
    @Test(expected=AssertionError.class)    
    public void equalsFailTest3(){
        WebMsg wbA = new WebMsg(MsgId.login);
        WebMsg wbB = new WebMsg(MsgId.login);
        
        wbA.addMsg("Msg 1");
        wbB.addMsg("Msg 1");
        
        wbA.addMsg("Msg 2");
        wbB.addMsg("Msg 2");
        
        wbA.addMsg("Msg 3");
        wbB.addMsg("Msg 3");
                
        wbA.setObj(new Integer(1));
        wbB.setObj(new Integer(2));
                       
        assertEquals(wbA,wbB);
    }
    
    @Test(expected=AssertionError.class)    
    public void equalsFailTest4(){
        WebMsg wbA = new WebMsg(MsgId.login);
        WebMsg wbB = new WebMsg(MsgId.login);
        
        wbA.addMsg("Msg 1");
        wbB.addMsg("Msg 1");
        
        wbA.addMsg("Msg 2");
        wbB.addMsg("Msg 2");
        
        wbA.addMsg("Msg 3");
        wbB.addMsg("Msg 3");
                
        wbA.setObj(new Object());
        wbB.setObj(new Object());
                       
        assertEquals(wbA,wbB);
    }
    
}
