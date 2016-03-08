/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChezzPieceTest;

import pieces.ChessPiece;
import pieces.PieceType;
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
public class IdTypeTest {
    private final char input;
    private final PieceType expect;        
    
        
    public IdTypeTest(char input, PieceType expect){
        this.input = input;
        this.expect = expect;
    }
    
    @Parameterized.Parameters
    public static Collection myInputs(){
        return Arrays.asList(new Object[][]{
                {'K',PieceType.king},
                {'Q',PieceType.queen},
                {'N',PieceType.knight},
                {'B',PieceType.bishop},
                {'R',PieceType.rook},
                {'P',PieceType.pawn},
                {'k',PieceType.king},
                {'q',PieceType.queen},
                {'n',PieceType.knight},
                {'b',PieceType.bishop},
                {'r',PieceType.rook},
                {'p',PieceType.pawn},
            }
        );
    }
    
    @Test
    public void test(){
        assertEquals(expect,ChessPiece.idType(input));
    }
}
