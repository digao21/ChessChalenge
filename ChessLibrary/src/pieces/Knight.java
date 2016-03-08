/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import static pieces.Bishop.getBlackId;
import utilites.GamePosition;

/**
 *
 * @author MauroSérgio
 */
public class Knight extends ChessPiece
{   
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    
    public Knight(Board board, GamePosition pos, PieceColor color){
        super(board,pos,PieceType.knight,color);
    }
        
    public Knight(Board board, int i, int j, PieceColor color){
        super(board,i,j,PieceType.knight,color);
    }
        
    
    //--------------------------------------------------------------------------
    //PIECE INFORMATION
    
    public static char getBlackId(){
        return 'N';
    }
    
    public static char getWhiteId(){
        return 'n';
    }
    
    public static boolean isKnightId(char id){
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
    protected void selectPieceAux(int posI, int posJ, int movI, int movJ){
        
        int i = posI + movI;
        int j = posJ + movJ;
        
        if(i < 1 || i > 8 || j < 1 || j > 8)        
            return;
        
        if(!board.isEdge(i, j)){
            if(!board.isOccupie(i, j))
                board.mark(i, j);
            else
                if(board.getPieceColor(i, j) != color)
                    board.mark(i,j);
        }
        
    }
        
    @Override
    public void selectPiece(){
        
        int posI = pos.getI();
        int posJ = pos.getJ();
        
        selectPieceAux(posI,posJ,-2,-1);
        selectPieceAux(posI,posJ,-2, 1);
        selectPieceAux(posI,posJ, 2,-1);
        selectPieceAux(posI,posJ, 2, 1);        
        selectPieceAux(posI,posJ,-1,-2);
        selectPieceAux(posI,posJ, 1,-2);
        selectPieceAux(posI,posJ,-1, 2);
        selectPieceAux(posI,posJ, 1, 2);
         
    }
}
