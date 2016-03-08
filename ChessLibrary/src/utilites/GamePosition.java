/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilites;

/**
 *
 * @author Rodrigo
 */
public class GamePosition {
    private int i,j;       
    
    public GamePosition(){}
    
    public GamePosition(int i, int j){
        setI(i);
        setJ(j);
    }
    
    public int getI(){
        return i;
    }
    
    public int getJ(){
        return j;
    }
    
    public void setI(int i){
        if(i < 1 || i > 8)
            throw new IllegalArgumentException("Out of board parameter");
         this.i = i;
    }
    
    public void setJ(int j){
        if(j < 1 || j > 8)
            throw new IllegalArgumentException("Out of board parameter"); 
        this.j = j;
    }
    
    public GamePosition copy(){
        GamePosition answ = new GamePosition();
        answ.setI(getI());
        answ.setJ(getJ());
        return answ;
    }
    
}
