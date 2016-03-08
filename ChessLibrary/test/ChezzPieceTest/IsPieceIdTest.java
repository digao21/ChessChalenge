/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChezzPieceTest;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pieces.ChessPiece;


/**
 *
 * @author Rodrigo
 */
@RunWith(Parameterized.class)
public class IsPieceIdTest {
    
    private char input;
    private boolean expect;
    
    public IsPieceIdTest(char input, boolean expect){
        this.input = input;
        this.expect = expect;
    }
    
    @Parameterized.Parameters
    public static Collection myInputs(){
        return Arrays.asList(new Object[][]{
                {'K',true},
                {'k',true},
                {'Q',true},
                {'q',true},
                {'B',true},
                {'b',true},
                {'N',true},
                {'n',true},
                {'R',true},
                {'r',true},
                {'P',true},
                {'p',true},
                {'a',false},
                {'L',false},
                {'c',false},
                {'d',false},
            }
        );
    }
    
    @Test
    public void idTest(){
        if(expect)
            assertTrue(ChessPiece.isPieceId(input));
        else
            assertTrue(!ChessPiece.isPieceId(input));
    }
        
}
