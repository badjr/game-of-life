/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/*
 Via https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
    
 At each step in time, the following transitions occur:

 1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 2. Any live cell with two or three live neighbours lives on to the next generation.
 3. Any live cell with more than three live neighbours dies, as if by overcrowding.
 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    
 //TODO: Implement this logic.

 */
/**
 * The GameOfLifeModel is the representation of the current state of the game
 * grid.
 *
 */
public class GameOfLifeModel {

    private final int gameBoard[][];
    private final int rows;
    private final int cols;
    private int numLiveCells;

    public GameOfLifeModel(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        gameBoard = new int[rows][cols];
        numLiveCells = 0;

    }

    /*
     Getters
     */
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getNumLiveCells() {
        return numLiveCells;
    }

    /*
     Setters
     */
    /**
     * Places cell on grid at the specified location.
     *
     * @param row
     * @param col
     */
    public void placeCell(int row, int col) {
        if (!cellExistsAt(row, col)) {
            gameBoard[row][col] = 1;
            numLiveCells++;
        }
    }

    /**
     * Removes cell from grid at the specified location.
     *
     * @param row
     * @param col
     */
    public void removeCell(int row, int col) {
        if (cellExistsAt(row, col)) {
            gameBoard[row][col] = 0;
            numLiveCells--;
        }
    }

    /*
     Methods
     */
    /**
     * Checks if a cell exists at (row, col) of the grid.
     *
     * @param row
     * @param col
     *
     * @return True if a cell occupies the grid at row, col, false otherwise.
     */
    public boolean cellExistsAt(int row, int col) {
        return gameBoard[row][col] == 1;
    }

    /**
     * Toggles a cell occupying a location at row, col.
     *
     * @param row
     * @param col
     */
    public void updateGridAt(int row, int col) {
        if (cellExistsAt(row, col)) {
            removeCell(row, col);
        }
        else {
            placeCell(row, col);
        }
    }

    public void printBoard() {
//        try {
//            Runtime.getRuntime().exec("clear");
//        }
//        catch (IOException ex) {
//            Logger.getLogger(GameOfLifeTableModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Determines if a cell at i, j will be alive at the next tick.
     *
     * @param i Row
     * @param j Column
     *
     * @return true or false if a cell will be alive at i, j at the next tick.
     *
     */
    public boolean cellAliveNextTickAt(int i, int j) {

        int numNeighbors = 0;

        boolean isAlive = cellExistsAt(i, j);
        if (i > 0 && cellExistsAt(i - 1, j)) {
            numNeighbors++;//top neighbor
        }
        if (i > 0 && j > 0 && cellExistsAt(i - 1, j - 1)) {
            numNeighbors++;//top_left neighbor
        }
        if (i > 0 && j < cols - 1 && cellExistsAt(i - 1, j + 1)) {
            numNeighbors++;//top_right neighbor
        }
        if (j > 0 && cellExistsAt(i, j - 1)) {
            numNeighbors++;//left neighbor
        }
        if (j < cols - 1 && cellExistsAt(i, j + 1)) {
            numNeighbors++;//right neighbor
        }
        if (i < rows - 1 && cellExistsAt(i + 1, j)) {
            numNeighbors++;//bottom neighbor
        }
        if (i < rows - 1 && j > 0 && cellExistsAt(i + 1, j - 1)) {
            numNeighbors++;//bottom_left neighbor
        }
        if (i < rows - 1 && j < cols - 1 && cellExistsAt(i + 1, j + 1)) {
            numNeighbors++;//bottom_right neighbor
        }        //synchronize here--(for threads)-------------------------------------------------------------

//       //        1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
//        //       2. Any live cell with two or three live neighbours lives on to the next generation.
//                 3. Any live cell with more than three live neighbours dies, as if by overcrowding.
//               
//      //         4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        return ( //                !(isAlive && numNeighbors < 2) || 
                (isAlive && (numNeighbors == 2 || numNeighbors == 3))
                || //                !(isAlive && numNeighbors > 3) || 
                (!isAlive && numNeighbors == 3));

        /*
         if (isAlive && numNeighbors < 2) {
         return false;
         }
         else if (isAlive && (numNeighbors == 2 || numNeighbors == 3)) {
         return true;
         }
         else if (isAlive && numNeighbors > 3) {
         return false;
         }
         else if (!isAlive && numNeighbors == 3) {
         return true;
         }
         else {
         return false;
         }
         */
    }

    /**
     * Moves forward one time unit.
     */
    public void tick() {
        //the survival table is used to determine if a cell is occupied or not
        //for the next time unit
        int survivalTable[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cellAliveNextTickAt(i, j)) {
                    survivalTable[i][j] = 1;
                }
                else {
                    survivalTable[i][j] = 0;
                }
            }
        }

        //Use survival table to adjust game table for next time unit
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (survivalTable[i][j] == 1) {
                    placeCell(i, j);
                }
                else {
                    removeCell(i, j);
                }
            }
        }
    }

}
