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
public class ImgPosition {
    private int i,j;            
    
    public ImgPosition(){}
    
    public ImgPosition(int i, int j){
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
         this.i = i;
    }
    
    public void setJ(int j){
         this.j = j;
    }
    
}
