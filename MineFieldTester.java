// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Mine Sweeper

import java.util.*;

public class MineFieldTester {
   public static void main(String[] args)   {
      
      System.out.println("Test 1 arg constructor [expected true positions: (1,0), (2,1), (2,2), (3,1), (3,3)]: ");
      boolean[][] mineData = 
      {{false, false, false, false}, 
       {true, false, false, false}, 
       {false, true, true, false},
       {false, true, false, true}};
      MineField myMineField = new MineField(mineData);
      String myMineFieldString = myMineField.toString();
      int pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test numAdjacentMines method [expected: 3]: ");
      System.out.println(myMineField.numAdjacentMines(2, 0));
      System.out.println("Test numAdjacentMines method [expected: 1]: ");
      System.out.println(myMineField.numAdjacentMines(3, 3));
      System.out.println("Test numAdjacentMines method [expected: 0]: ");
      System.out.println(myMineField.numAdjacentMines(0, 3));
      
      
      System.out.println("Test inRange method [expected: false]: ");
      System.out.println(myMineField.inRange(4, 1));
      System.out.println("Test inRange method [expected: true]: ");
      System.out.println(myMineField.inRange(2, 1));
      
      System.out.println("Test numRows method [expected: 4]: ");
      System.out.println(myMineField.numRows());
      
      System.out.println("Test numCols method [expected: 4]: ");
      System.out.println(myMineField.numCols());
      
      System.out.println("Test hasMine method [expected: false]: ");
      System.out.println(myMineField.hasMine(1, 2));
      System.out.println("Test hasMine method [expected: true]: ");
      System.out.println(myMineField.hasMine(2, 1));
      
      System.out.println("Test numMines method [expected: 5]: ");
      System.out.println(myMineField.numMines());
      
      System.out.println("Test resetEmpty method [expected: no true positions]: ");
      myMineField.resetEmpty();
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test populateMineField method after resetEmpty [expected: 5 true positions, position (1, 1) always false]: ");
      myMineField.populateMineField(1, 1);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test 1 arg constructor [expected true positions: no]: ");
      boolean[][] mineDataOneOne = {{false}};
      myMineField = new MineField(mineDataOneOne);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test populateMineField method [expected: no true position]: ");
      myMineField.populateMineField(0, 0);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      //--------------------------------------------------------------------------------------------------------------------------------
      System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
      
      System.out.println("Test 3-arg constructor [expected: no true positions, 7 rows, 5 columns]: ");
      myMineField = new MineField(7, 5, 10);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test populateMineField method [expected: 10 true positions, position (3, 4) always false]: ");
      myMineField.populateMineField(3, 4);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test resetEmpty method [expected: no true positions]: ");
      myMineField.resetEmpty();
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test populateMineField method after resetEmpty [expected: 10 true positions, position (1, 1) always false]: ");
      myMineField.populateMineField(1, 1);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test 3-arg constructor [expected: no true positions, 1 row, 1 column]: ");
      myMineField = new MineField(1, 1, 0);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      //--------------
      
      System.out.println("Test 3-arg constructor [expected: no true positions, 9 rows, 9 columns]: ");
      myMineField = new MineField(9, 9, 20);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
      
      System.out.println("Test populateMineField method [expected: 20 true positions, position (3, 3) always false]: ");
      myMineField.populateMineField(3, 3);
      myMineFieldString = myMineField.toString();
      pos = 0;
      while(pos < myMineFieldString.length()){
         while(pos < myMineFieldString.length() && myMineFieldString.charAt(pos) != ','){
            System.out.print(myMineFieldString.charAt(pos));
            ++pos;
         }
         System.out.println();
         ++pos;
      }
   }
}