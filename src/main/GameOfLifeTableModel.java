/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * The GameOfLifeTableModel is used as the TableModel for the JTable in
 * GameTablePanel.java, and wraps the GameOfLifeModel.
 * 
 * @author Brett
 */
public class GameOfLifeTableModel implements TableModel {

    private final GameOfLifeModel gameOfLifeModel;

    public GameOfLifeTableModel(GameOfLifeModel gameOfLifeModel) {
        this.gameOfLifeModel = gameOfLifeModel;
    }

    @Override
    public int getRowCount() {
        return gameOfLifeModel.getRows();
    }

    @Override
    public int getColumnCount() {
        return gameOfLifeModel.getCols();
    }

    @Override
    public String getColumnName(int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Integer.toString(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return gameOfLifeModel.cellExistsAt(rowIndex, columnIndex) ? 1 : 0;
    }

    /**
     * Not used. Updating the model via placeCell() and removeCell() works.
     *
     * @param aValue
     * @param rowIndex
     * @param columnIndex
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        gameOfLifeModel.updateGridAt(rowIndex, columnIndex);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
