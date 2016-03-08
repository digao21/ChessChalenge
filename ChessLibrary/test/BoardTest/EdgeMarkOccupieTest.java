/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardTest;

import pieces.Board;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author MauroSérgio
 */
@RunWith(Parameterized.class)
public class EdgeMarkOccupieTest{
    
    static private Board board = new Board(new char[][]{
                {'/','/','/','/','/','/','/','/','/','/'},
                {'/','Q','S','k','S','O','O','S','p','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','K','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','/','/','/','/','/','/','/','/','/'},});
    
    private final int posic;
    private final boolean edgeB;
    private final boolean occupieB;    
    
    public EdgeMarkOccupieTest(int posic, boolean edgeB, boolean occupieB){        
        this.posic = posic;
        this.edgeB = edgeB;
        this.occupieB = occupieB;       
    }
    
    @Parameterized.Parameters
    public static Collection myInputs(){
        return Arrays.asList(new Object[][]{                
                {1,false,true},
                {2,false,false},
                {3,false,true},
                {4,false,false},
                {5,false,false},
                {6,false,false},
                {7,false,false},
                {8,false,true},                
            }
        );
    }
    
    @Test
    public void edgeMarkOccupieTest(){
        assertEquals(edgeB,board.isEdge(1, posic));
        assertEquals(occupieB,board.isOccupie(1, posic));        
    }
    
}
