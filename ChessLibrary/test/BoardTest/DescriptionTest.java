/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardTest;

import pieces.Board;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author MauroSérgio
 */
@RunWith(Parameterized.class)
public class DescriptionTest {
    
    private final Board input;    
    private final char[][] expect;        
            
    public DescriptionTest(char[][] input, char[][] expect){
        this.input = new Board(input);        
        this.expect = expect;
    }
    
    static private char[][] inputTest1(int i){
        
        if(i == 1){
            return new char[][]{
                {'/','/','/','/','/','/','/','/','/','/'},
                {'/','R','N','B','Q','K','B','N','R','/'},
                {'/','P','P','P','P','P','P','P','P','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','p','p','p','p','p','p','p','p','/'},
                {'/','r','n','b','k','q','b','n','r','/'},
                {'/','/','/','/','/','/','/','/','/','/'},
            };
        }
        
        if(i == 2){
            return new char[][]{
                {'/','/','/','/','/','/','/','/','/','/'},
                {'/','R','N','B','Q','K','B','N','R','/'},
                {'/','P','P','P','P','P','P','P','P','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','p','p','p','p','p','p','p','p','/'},
                {'/','r','n','b','k','q','b','n','r','/'},
                {'/','/','/','/','/','/','/','/','/','/'},
            };
        }
        
        return null;
    }
    
    static private char[][] inputTest2(int i){
        
        if(i == 1){
            return new char[][]{
                {'/','/','/','/','/','/','/','/','/','/'},
                {'/','R','N','B','Q','K','B','N','R','/'},
                {'/','P','P','P','P','P','P','P','P','/'},
                {'/','P','P','P','P','P','P','P','P','/'},
                {'/','r','n','b','k','q','b','n','r','/'},
                {'/','p','p','p','p','p','p','p','p','/'},
                {'/','R','N','B','Q','K','B','N','R','/'},
                {'/','p','p','p','p','p','p','p','p','/'},
                {'/','r','n','b','k','q','b','n','r','/'},
                {'/','/','/','/','/','/','/','/','/','/'},
            };
        }
        
        if(i == 2){
            return new char[][]{
                {'/','/','/','/','/','/','/','/','/','/'},
                {'/','R','N','B','Q','K','B','N','R','/'},
                {'/','P','P','P','P','P','P','P','P','/'},
                {'/','P','P','P','P','P','P','P','P','/'},
                {'/','r','n','b','k','q','b','n','r','/'},
                {'/','p','p','p','p','p','p','p','p','/'},
                {'/','R','N','B','Q','K','B','N','R','/'},
                {'/','p','p','p','p','p','p','p','p','/'},
                {'/','r','n','b','k','q','b','n','r','/'},
                {'/','/','/','/','/','/','/','/','/','/'},
            };
        }
        
        return null;
    }
    
    @Parameterized.Parameters
    public static Collection myInputs(){
        return Arrays.asList(new Object[][]{
                {inputTest1(1),inputTest1(2)},
                {inputTest2(1),inputTest2(2)},                
            }
        );
    }
    
    @Test
    public void  descriptionTest(){
        boolean aux = BoardAux.compareDescription(input.getDescription(), expect);
        assertTrue(aux);
    }
    
}
