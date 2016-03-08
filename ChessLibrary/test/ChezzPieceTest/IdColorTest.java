/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChezzPieceTest;

import pieces.ChessPiece;
import pieces.PieceColor;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Rodrigo
 */
@RunWith(Parameterized.class)
public class IdColorTest {
    private final char input;
    private final PieceColor expect;        
            
    public IdColorTest(char input, PieceColor expect){
        this.input = input;
        this.expect = expect;
    }
    
    @Parameterized.Parameters
    public static Collection myInputs(){
        return Arrays.asList(new Object[][]{
                {'K',PieceColor.black},
                {'Q',PieceColor.black},
                {'N',PieceColor.black},
                {'B',PieceColor.black},
                {'R',PieceColor.black},
                {'P',PieceColor.black},
                {'k',PieceColor.white},
                {'q',PieceColor.white},
                {'n',PieceColor.white},
                {'b',PieceColor.white},
                {'r',PieceColor.white},
                {'p',PieceColor.white},
            }
        );
    }
    
    @Test
    public void test(){        
        assertEquals(expect,ChessPiece.idColor(input));
    }
}
