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
import javax.swing.event.ChangeListener;

/**
 * The GameWindowFrameController updates the model and the view when the user
 * interacts with the GameWindowFrame.
 *
 */
public class GameWindowFrameController {

    private final GameOfLifeModel model;
    private final GameWindowFrame gameWindow;

    private boolean gameRunning = false;

    private Thread gameThread;

    public GameWindowFrameController(GameOfLifeModel model, GameWindowFrame view) {

        this.model = model;
        this.gameWindow = view;

        //Add action listeners
        view.addTableMouseListener(new TableMouseListener());
        view.addStartButtonListener(new StartButtonListener());

    }

    /**
     * Mouse events for the table.
     */
    class TableMouseListener implements MouseListener {

        /**
         * When a cell in the table is clicked, it toggles the cell being
         * occupied.
         *
         * @param e
         */
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            //Using mousePressed instead of mouseClicked makes it easier to toggle
            //cells. They will toggle without release and dragging doesn't make them not toggle.
            
            //Get row/col user clicked on
            JTable target = (JTable) e.getSource();
            int row = target.getSelectedRow();
            int col = target.getSelectedColumn();

            //Update model
            model.updateGridAt(row, col);

            //Update view
            gameWindow.refreshBoard();
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

    public void addSliderListener(ChangeListener al) {
        gameWindow.getSlider().addChangeListener(al);
    }

    /**
     * When the start (or stop) button is pressed, starts or stops the game
     * depending on if it's running.
     */
    private class StartButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameRunning) {
                startGame();
            }
            else {
                stopGame();
            }
        }
    }

    private int getSleepTime() {
        return gameWindow.getSlider().getValue();
    }

    /**
     * Starts the thread that ticks the GameOfLifeModel, and also makes the
     * "Start" button say "Stop".
     */
    private void startGame() {
        gameRunning = true;
        gameWindow.getStartButton().setText("Stop");
        gameThread = new Thread(new GameLoopThread());
        gameThread.start();
    }

    /**
     * Interrupts the thread that ticks the GameOfLifeModel, and also makes the
     * "Stop" button say "Start".
     */
    private void stopGame() {
        gameThread.interrupt();
        gameWindow.getStartButton().setText("Start");
        gameRunning = false;
    }

    private class GameLoopThread implements Runnable {

        @Override
        public void run() {

            while (true) {

                if (model.getNumLiveCells() == 0) {
                    stopGame();
                }

                try {
                    //Delay between ticks
                    //FIXME: Thread.sleep called in loop warning.
                    Thread.sleep(getSleepTime()*10);
                }
                catch (InterruptedException ex) {
                    //When interrupted, exit the run() function.
                    return;
                }

                model.tick();
                gameWindow.refreshBoard();

            }
        }
    }

}
