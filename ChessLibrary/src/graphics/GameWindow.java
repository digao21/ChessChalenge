/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;
import javax.swing.JFrame;
import java.util.List;
import java.util.LinkedList;
import java.awt.Graphics;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import pieces.Board;
import utilites.ImgPosition;

/**
 *
 * @author MauroSérgio
 */
public class GameWindow extends JFrame
{    
    private ConcurrentLinkedQueue<DrawableObjectInterface> myList;    
    
    public GameWindow() throws IOException
    {
        ImgAdm.start();
        myList = new ConcurrentLinkedQueue<DrawableObjectInterface>();
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);                      
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        ImgPosition pos;
        for(DrawableObjectInterface aux : myList){
            pos = aux.getImgPos();
            g.drawImage(aux.getImage(), pos.getJ(), pos.getI(), null);
        }
    }
        
    public void update(){
        this.repaint();
    }        

    //TAKE OFF
    public void erase(DrawableObjectInterface obj) {
        myList.remove(obj);
    }

    //TAKE OFF
    public void draw(DrawableObjectInterface obj) {
        myList.add(obj);
    }
    
    public void setBoard(Board board){
        myList = board.getDrawList();
    }
    
}
