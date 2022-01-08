// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Mine Sweeper

import java.util.*;

public class VisibleFieldTester {
   public static void main(String[] args)   {
      
      System.out.println("Test constructor [expected true positions: (1,0), (2,1), (2,2), (3,1), (3,3)]: ");
      boolean[][] mineData = 
      {{false, false, false, false}, 
       {true, false, false, false}, 
       {false, true, true, false},
       {false, true, false, true}};
      MineField myMineField = new MineField(mineData);
      VisibleField myVisibleField = new VisibleField(myMineField);
      String myMineFieldString = myVisibleField.getMineField().toString();
      int pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      System.out.println("Current VisibleField status [expected: all -1]: ");
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: 5]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));

      //----------------------------------------------------------------------------------------------------------------
      
      System.out.println("Test uncover function [expected true positions: (1,0), (2,1), (2,2), (3,1), (3,3)]: ");
      myMineFieldString = myVisibleField.getMineField().toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Current VisibleField status [expected: position (3, 2) == 4, other positions are -1s]: ");
      myVisibleField.uncover(3, 2);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: 5]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: true]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
      
      System.out.println("Current VisibleField status [expected: position (3, 2) == 4, position (3, 0) == 2, other positions are -1s]: ");
      myVisibleField.uncover(3, 0);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: 5]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(2, 0));
      
      //----------------------------------------------------------------------------------------------------------------------------------------
      
      System.out.println("Test resetGameDisplay function [expected true positions: (1,0), (2,1), (2,2), (3,1), (3,3)]: ");
      myMineFieldString = myVisibleField.getMineField().toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Current VisibleField status [expected: all -1]: ");
      myVisibleField.resetGameDisplay();
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: 5]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
      
      //----------------------------------------------------------------------------------------------------------------------------------------
      
      System.out.println("Test cycleGuess function [expected true positions: (1,0), (2,1), (2,2), (3,1), (3,3)]: ");
      myMineFieldString = myVisibleField.getMineField().toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Current VisibleField status [expected: position (1, 0) is -2, other positions are -1s]: ");
      myVisibleField.cycleGuess(1, 0);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: 4]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
      
      System.out.println("Current VisibleField status [expected: position (1, 0) is -3, other positions are -1s]: ");
      myVisibleField.cycleGuess(1, 0);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: 5]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
      
      System.out.println("Current VisibleField status [expected: all positions are -1s]: ");
      myVisibleField.cycleGuess(1, 0);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: 5]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
      
      System.out.println("Current VisibleField status [expected: row 1, position (2,0), (2,1) are -2, other positions are -1s]: ");
      myVisibleField.cycleGuess(1, 0);
      myVisibleField.cycleGuess(1, 1);
      myVisibleField.cycleGuess(1, 2);
      myVisibleField.cycleGuess(1, 3);
      myVisibleField.cycleGuess(2, 0);
      myVisibleField.cycleGuess(2, 1);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: -1]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
      
      System.out.println("Current VisibleField status [expected: row 1, position (2,0), (2,1) are -2; position (0, 0) is 1; other positions are -1s]: ");
      myVisibleField.uncover(0, 0);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: -1]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
      
      //----------------------------------------------------------------------------------------------------------------------------------------
      
      System.out.println("Test uncover function [expected true positions: (1,0), (2,1), (2,2), (3,1), (3,3)]: ");
      myMineFieldString = myVisibleField.getMineField().toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Current VisibleField status [expected: row 1, position (2,0), (2,1) are -2; position (0, 0) is 1; other positions are -1s]: ");
      myVisibleField.uncover(1, 0);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: false]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: -1]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
      
      System.out.println("Current VisibleField status [expected: position (1,0), (2,1) are -2; position (1,1) (1,2) (1,3) (2,0) are 10]: ");
      System.out.println("Current VisibleField status [expected: position (0,0) is 1; position (3,1) (2,2) are 9; position (3,3) is 11; other positions are -1s]: ");
      myVisibleField.uncover(3, 3);
      for(int i = 0; i < myVisibleField.getMineField().numRows(); ++i){
         for(int j = 0; j < myVisibleField.getMineField().numCols(); ++j){
            System.out.print(myVisibleField.getStatus(i, j) + " ");
         }
         System.out.println();
      }
      System.out.println("Game is over or not [expected: true]: ");
      System.out.println(myVisibleField.isGameOver());
      System.out.println("Mine number left to guess is [expected: -1]: ");
      System.out.println(myVisibleField.numMinesLeft());
      System.out.println("Uncover or not [expected: false]: ");
      System.out.println(myVisibleField.isUncovered(3, 2));
   }
}