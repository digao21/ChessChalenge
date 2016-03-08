/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilitesTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import utilites.GamePosition;

/**
 *
 * @author Rodrigo
 */
public class GamePositionTest {       
    
    @Test
    public void getTest(){
        GamePosition pos = new GamePosition(1,2);
        assertEquals(1,pos.getI());
        assertEquals(2,pos.getJ());
    }
    
    @Test
    public void setTest1(){
        GamePosition pos = new GamePosition(1,2);
        pos.setI(3);
        pos.setJ(4);
        assertEquals(3,pos.getI());
        assertEquals(4,pos.getJ());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setTest2(){
        GamePosition pos = new GamePosition(1,2);
        pos.setI(0);
        pos.setJ(9);
        assertEquals(3,pos.getI());
        assertEquals(4,pos.getJ());
    }
    
}
