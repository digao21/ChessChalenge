/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

/**
 *
 * @author MauroSérgio
 */
public enum PieceType 
{
    pawn,
    knight,
    bishop,
    rook,
    king,
    queen;
    
    @Override
    public String toString()
    {
        switch(this)
        {
            case pawn:
                return "Pawn";                
            case knight:
                return "knight";
            case bishop:
                return "Bishop";
            case rook:
                return "Rook";
            case king:
                return "King";
            case queen:
                return "Queen";
            default:
                return "";
        }
    }
    
}
