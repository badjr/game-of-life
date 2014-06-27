/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

/**
 * The GameWindowFrameController updates the model and the view when the user
 * interacts with the GameWindowFrame.
 * 
 */
public class GameWindowFrameController {
    
    private final GameOfLifeModel model;
    private final GameWindowFrame view;
    
    public GameWindowFrameController(GameOfLifeModel model, GameWindowFrame view) {
        
        this.model = model;
        this.view = view;
        
        //Add action listeners
        view.addTableMouseListener(new TableMouseListener());
        view.addStartButtonListener(new StartButtonListener());
        
    }
    
    /**
     * Mouse events for the table.
     */
    class TableMouseListener implements MouseListener {
        
        /**
         * When a cell in the table is clicked, it toggles the cell being occupied.
         * @param e 
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            
            //Get row/col user clicked on
            JTable target = (JTable) e.getSource();
            int row = target.getSelectedRow();
            int col = target.getSelectedColumn();
            
            //Update model
            model.updateGridAt(row, col);
            
            //Update view
            view.refreshBoard(row, col);
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }    
    
    /**
     * Perform these actions when start button is pressed.
     */
    class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("You pressed the start button.");
        }
    }
    
}
