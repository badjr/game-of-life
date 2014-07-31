/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.Dimension;

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
        GameOfLifeModel model = new GameOfLifeModel(16, 16);
        GameWindowFrame gameWindow = new GameWindowFrame(model);
        
        GameWindowFrameController controller = new GameWindowFrameController(model, gameWindow);
        
        //test Cells
        model.placeCell(2, 2);
        model.placeCell(1, 3);
//        model.placeCell(4, 3);
//        model.placeCell(3, 4);
//        model.placeCell(2, 1);
//        model.placeCell(1, 2);
//        model.placeCell(3, 2);
//        model.placeCell(2, 3);
        
//        model.placeCell(1, 1);
//        model.placeCell(2, 1);
//        model.placeCell(3, 1);
        
        //show the board
        gameWindow.setVisible(true);
        
//        System.out.println(gameWindow.getGameTablePanel().getTable().getSize().height);
//        System.out.println(gameWindow.getGameTablePanel().getTable().getSize().width);
        System.out.println(gameWindow.getGameTablePanel().getTable().getWidth());
        System.out.println(gameWindow.getGameTablePanel().getTable().getHeight());
        
//        gameWindow.getGameTablePanel().setPreferredSize(gameWindow.getGameTablePanel().getTable().getSize());
        gameWindow.getGameTablePanel().setPreferredSize(new Dimension(gameWindow.getGameTablePanel().getTable().getWidth(), gameWindow.getGameTablePanel().getTable().getHeight()));
//        gameWindow.getGameTablePanel().setSize(gameWindow.getGameTablePanel().getTable().getSize());
//        System.out.println(gameWindow.getGameTablePanel().getWidth());
//        System.out.println(gameWindow.getGameTablePanel().getHeight());
//        System.out.println(gameWindow.getGameTablePanel().getJScrollPane().getWidth());
//        System.out.println(gameWindow.getGameTablePanel().getJScrollPane().getHeight());
        System.out.println(gameWindow.getGameTablePanel().getTable().getWidth());
        System.out.println(gameWindow.getGameTablePanel().getTable().getHeight());
        
    }
    
}
