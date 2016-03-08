/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import graphics.ImgAdm;
import java.awt.Image;
import utilites.GamePosition;

/**
 *
 * @author MauroSérgio
 *///
public abstract class ChessPiece extends BoardPiece
{          
    //Piece information
    protected PieceType type;
    protected PieceColor color;
        
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    
    public ChessPiece(Board board, GamePosition pos, PieceType type, PieceColor color){
        super(board,pos);
        this.type = type;
        this.color = color;
    }
    
    public ChessPiece(Board board, int i, int j, PieceType type, PieceColor color){
        super(board,i,j);
        this.type = type;
        this.color = color;
    }
    
    //--------------------------------------------------------------------------
    //ID
        
    public static boolean isPieceId(char id){
        
        boolean answ = false;
        
        if(Character.isLowerCase(id))
            id = Character.toUpperCase(id);
        
        answ = answ||id == 'K';
        answ = answ||id == 'Q';
        answ = answ||id == 'B';
        answ = answ||id == 'R';
        answ = answ||id == 'N';
        answ = answ||id == 'P';
        
        return answ;
    
    }
        
    public static PieceColor idColor(char id){
                
        if(Character.isUpperCase(id))
            return PieceColor.black;
        
        return PieceColor.white;
        
    }
    
    //Update and test
    public static PieceType idType(char id){
                
        if(Character.isLowerCase(id))
            id = Character.toUpperCase(id);
        
        switch(id){
            case 'K':
                return PieceType.king;                
            case 'Q':
                return PieceType.queen;
            case 'N':
                return PieceType.knight;
            case 'B':
                return PieceType.bishop;
            case 'R':
                return PieceType.rook;
            case 'P':
                return PieceType.pawn;
            default:
                return null;
        }        
    }        
    
    public static ChessPiece getPieceById(char id){
        PieceColor color;
        
        if(Character.isUpperCase(id))
            color = PieceColor.black;
        else
            color = PieceColor.white;
        
        if(Bishop.isBishopId(id))
            return new Bishop(null,1,1,color);
        
        if(King.isKingId(id))
            return new King(null,1,1,color);
        
        if(Knight.isKnightId(id))
            return new Knight(null,1,1,color);
        
        if(Pawn.isPawnId(id))
            return new Pawn(null,1,1,color);
        
        if(Queen.isQueenId(id))
            return new Queen(null,1,1,color);
        
        if(Rook.isRookId(id))
            return new Rook(null,1,1,color);
        
        return null;
    }
    
    public abstract char getId();        
    
    //--------------------------------------------------------------------------
    //PIECE INFORMATION
        
    public PieceType getType(){
        return type;
    }
        
    public PieceColor getColor(){
        return color;
    }
    
    //--------------------------------------------------------------------------
    //MOVE AND SELECT METHODS              
        
    protected void selectPieceAux(int posI, int posJ, int movI, int movJ)
    {
        
        posI += movI;
        posJ += movJ;
        
        for(; !board.isEdge(posI, posJ) &&
                !board.isOccupie(posI, posJ);
                    posI += movI , posJ += movJ){
            
            board.mark(posI, posJ);
        }
        
        if(board.isOccupie(posI, posJ) && board.getPieceColor(posI, posJ) != color){
            board.mark(posI, posJ);
        }
                        
    }
        
    public boolean canMoveTo(int i, int j){
        boolean answ;
        
        selectPiece();
        answ = board.isMarked(i, j);
        board.clean();
        
        return answ;
    }
    public abstract void selectPiece();
    
    @Override
    public char delet(){
        board.eraseFromDrawList(this);
        return getId();
    }
    
    @Override
    public Image getImage(){                        
        return ImgAdm.getImage(getId());
    }
    
}
