/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import static java.lang.Thread.sleep;

/**
 *
 * @author Brett
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        GameOfLifeModel model = new GameOfLifeModel(16, 16);
//        GameOfLifeModel temp;
        GameWindowFrame gameWindow = new GameWindowFrame(model);
        
        GameWindowFrameController controller = new GameWindowFrameController(model, gameWindow);
        
        //test Cells
        model.placeCell(2, 2);
        model.placeCell(1, 3);
        model.placeCell(1, 3);
        model.placeCell(4, 3);
        model.placeCell(3, 4);
        model.placeCell(2, 1);
        model.placeCell(1, 2);
        model.placeCell(3, 2);
        model.placeCell(2, 3);
        
//        model.placeCell(1, 1);
//        model.placeCell(2, 1);
//        model.placeCell(3, 1);
        
        //show the board
        gameWindow.setVisible(true);
        
        controller.run();
        
        /*
        //looping through the Game Logic for each cell
        while (true) {
//            temp = model;
            Thread.sleep(200);
            for (int i = 0; i < model.getRows(); i++) {
                for (int j = 0; j < model.getCols(); j++) {
//                    System.out.println(i + "," + j);
//                    Thread.sleep(1000);
                    if (model.cellSurvivesAt(i, j)) {
                        model.placeCell(i, j);
                        gameWindow.refreshBoard(i, j);
                    }
                    else {
                        model.removeCell(i, j);
                        gameWindow.refreshBoard(i, j);
   
                    }
//                    model.printBoard();
                }

            }
//            model.printBoard();
//            System.out.println("");
//            model.printBoard();
            
        }*/
    }
    
}
