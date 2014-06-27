/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * The GameWindowFrame contains all the GUI components of the game in one
 * JFrame (window).
 * 
 */
public class GameWindowFrame extends javax.swing.JFrame {

    private static GameOfLifeModel gameOfLifeModel;
    
    /**
     * Creates new form GameWindowFrame
     * @param gameOfLifeModel
     */
    public GameWindowFrame(GameOfLifeModel gameOfLifeModel) {
        
        //Game window frame needs the GameOfLifeModel
        GameWindowFrame.gameOfLifeModel = gameOfLifeModel;
        
        initComponents();
        
        //Set table model for the game table.
        gameTablePanel.getTable().setModel(new GameOfLifeTableModel(gameOfLifeModel));
        
        //TODO: Make the game grid generate all cells as square no matter what size.
        //Currently, columns stretch to width.
        //TODO: Instead of displaying 1 or 0, change the background or something
        //to indicate that a cell in the table is occupied.
    }
    
    public void refreshBoard(int row, int col) {
        //So a cell in the table will update on click instead of after losing focus.
        gameTablePanel.getTable().repaint();
        
        //So it doesn't stay selected after clicking.
        gameTablePanel.getTable().clearSelection();
    }
    
//    public GameTablePanel getGameTablePanel() {
//        return gameTablePanel;
//    }
    
    /**
     * Adds mouse listener for the table.
     * @param ml 
     */
    void addTableMouseListener(MouseListener ml) {
        gameTablePanel.getTable().addMouseListener(ml);
    }
    
    /**
     * Adds action listener for the start button.
     * @param al 
     */
    void addStartButtonListener(ActionListener al) {
        startButton.addActionListener(al);
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        gameTablePanel = new main.GameTablePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startButton.setText("Start");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gameTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(startButton)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GameWindowFrame(gameOfLifeModel).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private main.GameTablePanel gameTablePanel;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
