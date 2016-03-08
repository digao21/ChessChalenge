/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globalsuite;

import BoardCellTest.BoardCellSuite;
import BoardPieceTest.BoardPieceSuite;
import BoardTest.BoardSuite;
import ChezzPieceTest.ChezzPieceSuite;
import PiecesTest.PiecesSuite;
import UtilitesTest.UtilitesSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author MauroSérgio
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
    BoardCellSuite.class,
    BoardPieceSuite.class,
    BoardSuite.class,
    ChezzPieceSuite.class,
    PiecesSuite.class,
    UtilitesSuite.class
})
public class GlobalSuite {
    
}
