/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontrol;

import gamemodes.FastGameMode;
import gamemodes.HPGame;
import gamemodes.NormalGameMode;
import web.WebControl;
import gui.ErrorMsg;
import gui.LoginPage;
import gui.RegisterPage;
import gui.SelectGamePage;
import java.io.IOException;
import java.util.Stack;
import javax.swing.JFrame;


/**
 *
 * @author MauroSérgio
 */
public abstract class Controler 
{
    private static WebControl webCtrl;
    
    private static Stack<JFrame> stackP;
    private static JFrame currentP;
    private static LoginPage loginP;
    private static SelectGamePage selectP;
    private static RegisterPage registerP;
    
    private static void init(){
        lookAndFeel();
        
        stackP = new Stack<>();
        loginP = new LoginPage();
        selectP = new SelectGamePage();   
        registerP = new RegisterPage();
        currentP = null;
    }
    
    public static void start(){
        init();
        
        setCurrentPage(loginP);        
                
    }          
    
    public static void errorMsg(String msg){        
        setCurrentPage(new ErrorMsg(msg));        
    }
    
    public static void pageBck(){
        currentP.setVisible(false);
        stackP.pop();
        if(!stackP.isEmpty()){
            currentP = stackP.peek();
            currentP.setVisible(true);
        }
        else{
            //NOT IMPLEMENTED - ERROR
            throw new RuntimeException("JFrame stack is empty");
        }
    }
    
    public static void setSelectGamePag(){
        setCurrentPage(selectP);
    }
    
    public static void setRegisterPage(){    
        registerP.clean();
        setCurrentPage(registerP);
    }
    
    public static void setCurrentPage(JFrame newPage){        
        if(currentP != null)
            currentP.setVisible(false);
        
        currentP = newPage;
        stackP.push(currentP);
        currentP.setVisible(true);
    }
    
    private static void lookAndFeel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ErrorMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErrorMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErrorMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }        
    
    public static void startNormalGame(){
        currentP.setVisible(false);
        GameConnection gc = new GameConnection();
        try{
            NormalGameMode ng = new NormalGameMode(gc);
            ng.play();
        }catch(IOException e){
            //SOLUTION NOT IMPLEMENTED
            throw new RuntimeException("Normal game IOException");
        }
        
    }
    
    public static void startFastGame(){
        currentP.setVisible(false);
        GameConnection gc = new GameConnection();
        try{
            FastGameMode fg = new FastGameMode(gc);
            fg.play();
        }catch(IOException e){
            //SOLUTION NOT IMPLEMENTED
            throw new RuntimeException("Normal game IOException");
        }
        
    }
    
    public static void startHpGame(){
        currentP.setVisible(false);
        GameConnection gc = new GameConnection();
        try{
            HPGame hg = new HPGame(gc);
            hg.play();
        }catch(IOException e){
            //SOLUTION NOT IMPLEMENTED
            throw new RuntimeException("Normal game IOException");
        }
        
    }
    
    public static void gameIsFinished(){
        currentP.setVisible(true);
    }
    
}
