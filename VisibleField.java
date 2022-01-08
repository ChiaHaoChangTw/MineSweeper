// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Mine Sweeper

/**
  VisibleField class  
 */

import java.util.Arrays;

public class VisibleField {
   
   // The following are the covered states (all negative values):
   public static final int COVERED = -1;   // initial value of all squares
   public static final int MINE_GUESS = -2;
   public static final int QUESTION = -3;

   // The following are the uncovered states (all non-negative values):
   
   // values in the range [0,8] corresponds to number of mines adjacent to this square
   
   public static final int NO_NEIGHBOR_MINES = 0; // is a loc has no mines in its neighbor locs
   public static final int MINE = 9;      // this loc is a mine that hasn't been guessed already (end of losing game)
   public static final int INCORRECT_GUESS = 10;  // is displayed a specific way at the end of losing game
   public static final int EXPLODED_MINE = 11;   // the one you uncovered by mistake (that caused you to lose)
   // ----------------------------------------------------------   
  
   /**
     * Representation invariant:
     * 
     * a) myMineFieldStatus.length >= 1 && myMineFieldStatus.length == myMineField.numRows()
     * b) myMineFieldStatus[0].length >= 1 && myMineFieldStatus[0].length == myMineField.numCols()
     * c) -3 <= any data in myMineFieldStatus <= 11
     * d) guessedMineNumber >= 0 && guessedMineNumber <= myMineField.numRows() * myMineField.numCols()
     * e) uncoveredNumber >= 0 && uncoveredNumber <= myMineField.numRows() * myMineField.numCols() - myMineField.numMines()
     * 
     */
   
   private MineField myMineField;
   private int[][] myMineFieldStatus;
   private boolean isGameOver;
   private int guessedMineNumber;
   private int uncoveredNumber;
   
   /**
      Create a visible field that has the given underlying mineField.
      The initial state will have all the mines covered up, no mines guessed, and the game
      not over.
      @param mineField  the minefield to use for for this VisibleField
    */
   public VisibleField(MineField mineField) {
      
      myMineField = mineField;
      
      myMineFieldStatus = new int[myMineField.numRows()][myMineField.numCols()];
      for(int[] row: myMineFieldStatus){
         Arrays.fill(row, COVERED);
      }
      
      isGameOver = false;
      
      guessedMineNumber = 0;
      uncoveredNumber = 0;
      
      assert isValidVisibleField();
   }
   
   /**
      Reset the object to its initial state (see constructor comments), using the same underlying
      MineField. 
   */     
   public void resetGameDisplay() {
      
      for(int[] row: myMineFieldStatus){
         Arrays.fill(row, COVERED);
      }
      
      isGameOver = false;
      
      guessedMineNumber = 0;
      uncoveredNumber = 0;
      
      assert isValidVisibleField();
   }
  
   /**
      Returns a reference to the mineField that this VisibleField "covers"
      @return the minefield
    */
   public MineField getMineField() {
      
      assert isValidVisibleField();
      return myMineField;
   }
     
   /**
      Returns the visible status of the square indicated.
      @param row  row of the square
      @param col  col of the square
      @return the status of the square at location (row, col).  See the public constants at the beginning of the class
      for the possible values that may be returned, and their meanings.
      PRE: getMineField().inRange(row, col)
    */
   public int getStatus(int row, int col) {
      
      assert this.getMineField().inRange(row, col);
      
      assert isValidVisibleField();
      return myMineFieldStatus[row][col];
   }

   /**
      Returns the the number of mines left to guess.  This has nothing to do with whether the mines guessed are correct
      or not.  Just gives the user an indication of how many more mines the user might want to guess.  This value can
      be negative, if they have guessed more than the number of mines in the minefield.     
      @return the number of mines left to guess.
    */
   public int numMinesLeft() {
      
      assert isValidVisibleField();
      return this.getMineField().numMines() - guessedMineNumber;
   }
 
   /**
      Cycles through covered states for a square, updating number of guesses as necessary.  Call on a COVERED square
      changes its status to MINE_GUESS; call on a MINE_GUESS square changes it to QUESTION;  call on a QUESTION square
      changes it to COVERED again; call on an uncovered square has no effect.  
      @param row  row of the square
      @param col  col of the square
      PRE: getMineField().inRange(row, col)
    */
   public void cycleGuess(int row, int col) {
      
      assert this.getMineField().inRange(row, col);
      
      if(myMineFieldStatus[row][col] == COVERED){
         myMineFieldStatus[row][col] = MINE_GUESS;
         ++guessedMineNumber;
      }
      else if(myMineFieldStatus[row][col] == MINE_GUESS){
         myMineFieldStatus[row][col] = QUESTION;
         --guessedMineNumber;
      }
      else if(myMineFieldStatus[row][col] == QUESTION){
         myMineFieldStatus[row][col] = COVERED;
      }
      
      assert isValidVisibleField();
   }

   /**
      Uncovers this square and returns false iff you uncover a mine here.
      If the square wasn't a mine or adjacent to a mine it also uncovers all the squares in 
      the neighboring area that are also not next to any mines, possibly uncovering a large region.
      Any mine-adjacent squares you reach will also be uncovered, and form 
      (possibly along with parts of the edge of the whole field) the boundary of this region.
      Does not uncover, or keep searching through, squares that have the status MINE_GUESS. 
      Note: this action may cause the game to end: either in a win (opened all the non-mine squares)
      or a loss (opened a mine).
      @param row  of the square
      @param col  of the square
      @return false   iff you uncover a mine at (row, col)
      PRE: getMineField().inRange(row, col)
    */
   public boolean uncover(int row, int col) {
      
      assert this.getMineField().inRange(row, col);
      if(myMineFieldStatus[row][col] == MINE_GUESS){
         assert isValidVisibleField();
         return true;
      }
      if(this.getMineField().hasMine(row, col)){
         for(int i = 0; i < this.getMineField().numRows(); ++i){
            for(int j = 0; j < this.getMineField().numCols(); ++j){
               if(!this.getMineField().hasMine(i, j) && myMineFieldStatus[i][j] == MINE_GUESS){
                  myMineFieldStatus[i][j] = INCORRECT_GUESS;
               }
               if(this.getMineField().hasMine(i, j) && myMineFieldStatus[i][j] != MINE_GUESS){
                  myMineFieldStatus[i][j] = MINE;
               }
            }
         }
         myMineFieldStatus[row][col] = EXPLODED_MINE;         
         isGameOver = true;
         assert isValidVisibleField();
         return false;
      }
      uncoverHelper(row, col);
      isGameOver = (uncoveredNumber + this.getMineField().numMines() == this.getMineField().numRows() * this.getMineField().numCols()) ? true : false;
      
      assert isValidVisibleField();
      return true;
   }
   
   /**
      Returns whether the game is over.
      (Note: This is not a mutator.)
      @return whether game over
    */
   public boolean isGameOver() {
      
      assert isValidVisibleField();
      return isGameOver;
   }
 
   /**
      Returns whether this square has been uncovered.  (i.e., is in any one of the uncovered states, 
      vs. any one of the covered states).
      @param row of the square
      @param col of the square
      @return whether the square is uncovered
      PRE: getMineField().inRange(row, col)
    */
   public boolean isUncovered(int row, int col) {
      
      assert this.getMineField().inRange(row, col);
      
      assert isValidVisibleField();
      return myMineFieldStatus[row][col] >= 0;
   }
   
   /**
      Recursively find neighbor squares without mines, uncover them, and change their statuses accordingly.
      @param row of the square
      @param col of the square
      PRE: getMineField().inRange(row, col)
    */
   private void uncoverHelper(int row, int col){
      
      assert this.getMineField().inRange(row, col);
      
      if(this.getMineField().hasMine(row, col)){
         assert isValidVisibleField();
         return;
      }
      if(myMineFieldStatus[row][col] != COVERED && myMineFieldStatus[row][col] != QUESTION){
         assert isValidVisibleField();
         return;
      }
      myMineFieldStatus[row][col] = this.getMineField().numAdjacentMines(row, col);
      ++uncoveredNumber;
      if(myMineFieldStatus[row][col] != NO_NEIGHBOR_MINES){
         assert isValidVisibleField();
         return;
      }
      
      int[][] offsets = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      for(int[] offset: offsets){
         int nextRow = row + offset[0];
         int nextCol = col + offset[1];
         if(nextRow >= 0 && nextRow < this.getMineField().numRows() && nextCol >= 0 && nextCol < this.getMineField().numCols()){
            uncoverHelper(nextRow, nextCol);
         }
      }
      assert isValidVisibleField();
      return;
   }
   
   /**
      Returns true iff the VisibleField data is in a valid state. 
      @return strue iff the VisibleField data is in a valid state
   */   
   private boolean isValidVisibleField(){
      
      if(myMineFieldStatus.length < 1 && myMineFieldStatus.length != myMineField.numRows()){
         return false;
      }
      
      if(myMineFieldStatus[0].length < 1 && myMineFieldStatus[0].length != myMineField.numCols()){
         return false;
      }
      
      for(int i = 0; i < myMineFieldStatus.length; ++i){
         for(int j = 0; j < myMineFieldStatus[0].length; ++j){
            if(myMineFieldStatus[i][j] < -3 || myMineFieldStatus[i][j] > 11){
               return false;
            }
         }
      }
      
      if(guessedMineNumber < 0 && guessedMineNumber > myMineField.numRows() * myMineField.numCols()){
         return false;
      }
      
      return uncoveredNumber >= 0 && uncoveredNumber <= myMineField.numRows() * myMineField.numCols() - myMineField.numMines();
   }  
}