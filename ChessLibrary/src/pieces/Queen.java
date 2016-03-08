/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import utilites.GamePosition;

/**
 *
 * @author MauroSérgio
 */
public class Queen extends ChessPiece
{       
    //--------------------------------------------------------------------------
    //CONSTRUCTOR    
    public Queen(Board board, GamePosition pos, PieceColor color){
        super(board,pos,PieceType.queen,color);
    }
        
    public Queen(Board board, int i, int j, PieceColor color){
        super(board,i,j,PieceType.queen,color);
    }      
    
    //--------------------------------------------------------------------------
    //PIECE INFORMATION
    
    public static char getBlackId(){
        return 'Q';
    }
    
    public static char getWhiteId(){
        return 'q';
    }
    
    public static boolean isQueenId(char id){
        return id == getBlackId() || id == getWhiteId();
    }
    
    @Override
    public char getId(){
        if(color == PieceColor.black)
            return getBlackId();
        return getWhiteId();
    }
    
    //--------------------------------------------------------------------------
    //SELECT AND MOVE METHODS
        
    @Override
    public void selectPiece()
    {
        int posI = pos.getI();
        int posJ = pos.getJ();
                
        selectPieceAux(posI,posJ,1,1);                
        selectPieceAux(posI,posJ,1,-1);                
        selectPieceAux(posI,posJ,-1,1);                
        selectPieceAux(posI,posJ,-1,-1);
        
        selectPieceAux(posI,posJ, 1, 0);
        selectPieceAux(posI,posJ,-1, 0);
        selectPieceAux(posI,posJ, 0,-1);
        selectPieceAux(posI,posJ, 0, 1);
                
    }
}
