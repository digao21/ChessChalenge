/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChezzPieceTest;

import java.awt.Image;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pieces.Board;
import pieces.ChessPiece;
import pieces.PieceColor;
import pieces.PieceType;
import utilites.GamePosition;

/**
 *
 * @author Rodrigo
 */
class DummyPiece extends ChessPiece{

    public DummyPiece(Board board, GamePosition pos, PieceType type, PieceColor color) {
        super(board, pos, type, color);
    }
    
    public DummyPiece(Board board, int i, int j, PieceType type, PieceColor color){
        super(board,i,j,type,color);        
    }

    @Override
    public char getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selectPiece() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char delet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

@RunWith(Parameterized.class)
public class SG_ColorAndTypeTest {
    private PieceColor inputColor;
    private PieceType inputType;
    private PieceColor outputColor;
    private PieceType outputType;
    
    public SG_ColorAndTypeTest(PieceColor inColor, PieceType inType, PieceColor outColor, PieceType outType){
        inputColor = inColor;
        inputType = inType;
        outputColor = outColor;
        outputType = outType;
    }
    
    @Parameterized.Parameters
    public static Collection myInputs(){
        return Arrays.asList(new Object[][]{
            {PieceColor.white,PieceType.bishop,PieceColor.white,PieceType.bishop},
            {PieceColor.white,PieceType.king,PieceColor.white,PieceType.king},
            {PieceColor.white,PieceType.knight,PieceColor.white,PieceType.knight},
            {PieceColor.white,PieceType.pawn,PieceColor.white,PieceType.pawn},
            {PieceColor.white,PieceType.queen,PieceColor.white,PieceType.queen},
            {PieceColor.white,PieceType.rook,PieceColor.white,PieceType.rook},
            {PieceColor.black,PieceType.bishop,PieceColor.black,PieceType.bishop},
            {PieceColor.black,PieceType.king,PieceColor.black,PieceType.king},
            {PieceColor.black,PieceType.knight,PieceColor.black,PieceType.knight},
            {PieceColor.black,PieceType.pawn,PieceColor.black,PieceType.pawn},
            {PieceColor.black,PieceType.queen,PieceColor.black,PieceType.queen},
            {PieceColor.black,PieceType.rook,PieceColor.black,PieceType.rook},
        });    
    }
    
    @Test
    public void test(){
        DummyPiece d = new DummyPiece(null,1,1,inputType,inputColor);
        assertEquals(outputType,d.getType());
        assertEquals(outputColor,d.getColor());
    }
    
}
