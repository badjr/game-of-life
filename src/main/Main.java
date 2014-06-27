/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author Brett
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameOfLifeModel model = new GameOfLifeModel(16, 16);
        GameWindowFrame gameWindow = new GameWindowFrame(model);
        
        GameWindowFrameController controller = new GameWindowFrameController(model, gameWindow);
        
        gameWindow.setVisible(true);
        
        model.placeCell(2, 2);
        
//        model.printBoard();
    }
    
}
