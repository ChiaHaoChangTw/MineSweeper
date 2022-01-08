// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Mine Sweeper

/** 
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */

import java.util.Arrays;
import java.util.Random;

public class MineField {
   
   /**
     * Representation invariant:
     * 
     * a) myMineData.length >= 1
     * b) myMineData[0].length >= 1
     * c) numMines >= 0
     * d) numMines < (numRows * numCols) / 3.0
     * 
     */
   
   private boolean[][] myMineData;
   private int numMines;
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
      @param mineData  the data for the mines; must have at least one row and one col,
                       and must be rectangular (i.e., every row is the same length)
    */
   public MineField(boolean[][] mineData) {
      
      assert mineData.length >= 1 && mineData[0].length >= 1;    

      boolean isRectangular = true;
      myMineData = new boolean[mineData.length][];
      
      for(int i = 0; i < mineData.length; ++i){
         myMineData[i] = new boolean[mineData[i].length];
         for(int j = 0; j < myMineData[i].length; ++j){
            if(mineData[i][j]){
               myMineData[i][j] = mineData[i][j];
               ++numMines;
            }            
         }
         if(i > 0 && myMineData[i].length != myMineData[i - 1].length){
            isRectangular = false;
         }
      }
      
      assert isRectangular;
      assert isValidMineField();
   }
      
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
      
      assert numRows > 0 && numCols > 0 && numMines >= 0 && numMines < ((numRows * numCols) / 3.0);
      
      myMineData = new boolean[numRows][numCols];
      this.numMines = numMines;
      
      assert isValidMineField();
   }
   
   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col) and numMines() < (1/3 * numRows() * numCols())
    */
   public void populateMineField(int row, int col) {
      
      assert inRange(row, col) && this.numMines() < ((this.numRows() * this.numCols()) / 3.0);
      
      this.resetEmpty();
      int totalSquares = this.numRows() * this.numCols();
      Random generator = new Random();
      
      int currNumMines = 0;
      while(currNumMines < this.numMines()){
         int mineIndex = generator.nextInt(totalSquares);
         int newMineRow = mineIndex / this.numCols();
         int newMineCol = mineIndex % this.numCols();
         if((newMineRow != row || newMineCol != col) && !hasMine(newMineRow, newMineCol)){
            myMineData[newMineRow][newMineCol] = true;
            ++currNumMines;
         }
      }
      
      assert isValidMineField();
   }
      
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state a minefield created with the three-arg constructor is in 
         at the beginning of a game.
    */
   public void resetEmpty() {
      
      for(int i = 0; i < this.numRows(); ++i){
         for(int j = 0; j < this.numCols(); ++j){
            if(this.hasMine(i, j)){
               myMineData[i][j] = false;
            }
         }
      }
      
      assert isValidMineField();
   }
   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
      
      assert inRange(row, col);
      
      int numAdjacentMines = 0;
      int[][] offsets = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
      
      for(int[] offset: offsets){
         if(inRange(row + offset[0], col + offset[1]) && hasMine(row + offset[0], col + offset[1])){
            ++numAdjacentMines;
         }
      }
      
      assert isValidMineField();
      return numAdjacentMines;
   }
      
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
      
      assert isValidMineField();
      return row >= 0 && row < myMineData.length && col >= 0 && col < myMineData[0].length;
   }
      
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      
      assert isValidMineField();
      return myMineData.length;
   }
    
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      
      assert isValidMineField();
      return myMineData[0].length;
   }
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      
      assert inRange(row, col); 
      
      assert isValidMineField();
      return myMineData[row][col];
   }
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return the number of mines you can have in this minefield
    */
   public int numMines() {
      
      assert isValidMineField();
      return numMines;
   }

   /**
      Returns string representation of this MineFiled object. Rows are separated by commas. 
      @return string representation of this MineFiled object
   */     
   public String toString() {
      
      String myMineDataString = "";
      
      for(int i = 0; i < myMineData.length; ++i){
         for(int j = 0; j < myMineData[i].length; ++j){
            myMineDataString += myMineData[i][j] + " ";
         }
         myMineDataString += ",";
      }
      
      assert isValidMineField();
      return myMineDataString;
   }
   
   /**
      Returns true iff the MineField data is in a valid state. 
      @return strue iff the MineField data is in a valid state
   */    
   private boolean isValidMineField(){
      
      return myMineData.length >= 1 && myMineData[0].length >= 1 && numMines >= 0 && numMines < (myMineData.length * myMineData[0].length) / 3.0;
   }
}