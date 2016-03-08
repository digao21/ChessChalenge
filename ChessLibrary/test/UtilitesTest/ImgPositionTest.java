/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilitesTest;

import static org.junit.Assert.assertEquals;
import utilites.ImgPosition;
import org.junit.Test;

/**
 *
 * @author Rodrigo
 */
public class ImgPositionTest {
    
    @Test
    public void getTest(){
        ImgPosition pos = new ImgPosition(1,2);
        assertEquals(1,pos.getI());
        assertEquals(2,pos.getJ());
    }
    
    @Test
    public void setTest(){
        ImgPosition pos = new ImgPosition(1,2);
        pos.setI(3);
        pos.setJ(4);
        assertEquals(3,pos.getI());
        assertEquals(4,pos.getJ());
    }
    
}
