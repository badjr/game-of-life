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

    public GameOfLifeModel(int rows, int cols) {
        
        this.rows = rows;
        this.cols = cols;
        gameBoard = new int[rows][cols];

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
        gameBoard[row][col] = 1;
    }

    /**
     * Removes cell from grid at the specified location.
     *
     * @param row
     * @param col
     */
    public void removeCell(int row, int col) {
        gameBoard[row][col] = 0;
    }
    
    /*
        Methods
    */
    
    /**
     * Checks if a cell exists at (row, col) of the grid.
     * @param row
     * @param col
     * @return True if a cell occupies the grid at row, col, false otherwise.
     */
    public boolean cellExistsAt(int row, int col) {
        return gameBoard[row][col] == 1;
    }    
    
    /**
     * Toggles a cell occupying a location at row, col.
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
    
    
        public boolean implementLogic(int i, int j){
        
        
        int count=0;
       
               boolean isAlive=cellExistsAt(i,j);
               if(i>0&&cellExistsAt(i-1,j))count++;//top neighbor
               if(i>0&&j>0&&cellExistsAt(i-1,j-1))count++;//top_left neighbor
               if(i>0&&j<cols-1&&cellExistsAt(i-1,j+1))count++;//top_right neighbor
               if(j>0&&cellExistsAt(i,j-1))count++;//left neighbor
               if(j<cols-1&&cellExistsAt(i,j+1))count++;//right neighbor
               if(i<rows-1&&cellExistsAt(i+1,j))count++;//bottom neighbor
               if(i<rows-1&&j>0&&cellExistsAt(i+1,j-1))count++;//bottom_left neighbor
               if(i<rows-1&&j<cols-1&&cellExistsAt(i+1,j+1))count++;//bottom_right neighbor
//synchronize here--(for threads)-------------------------------------------------------------
               
//       //        1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.

//        //       2. Any live cell with two or three live neighbours lives on to the next generation.
//                 3. Any live cell with more than three live neighbours dies, as if by overcrowding.
//               
//      //         4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

               
           
           return ((count<2)||(count>3 && isAlive)||(!isAlive && count==3));
              
                             
    }
         
    
    
    

}
