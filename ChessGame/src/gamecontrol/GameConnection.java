/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontrol;

import gamemodes.GameControlI;

/**
 *
 * @author Usuario
 */
public class GameConnection implements GameControlI {

    @Override
    public void gameIsOver() {
        Controler.gameIsFinished();
    }
    
}
