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
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //FIXME: Anything higher than (23, 23), the JPanel containing the JTable will not grow with the table.
        GameOfLifeModel model = new GameOfLifeModel(16, 16);
        GameWindowFrame gameWindow = new GameWindowFrame(model);      
        
        //show the board
        gameWindow.setVisible(true);        
        
        GameWindowFrameController controller = new GameWindowFrameController(model, gameWindow);
        
        //test Cells
        model.placeCell(2, 2);
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
        
        //FIXME: Tried calling pack() here also but sometimes window is too small
        gameWindow.pack();
        
    }
    
}
