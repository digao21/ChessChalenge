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
 */
public class SquareMark extends BoardPiece
{    
    public SquareMark(Board myBoard,int posI, int posJ)
    {
        super(myBoard,new GamePosition(posI,posJ));        
    }                    
    
    public static char getId(){
        return 'S';
    }

    @Override
    public char delet() {
        if(board != null)
            board.eraseFromDrawList(this);
        return getId();
    }

    @Override
    public Image getImage() {
        return ImgAdm.getImage(getId());
    }
    
}
