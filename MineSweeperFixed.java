// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Mine Sweeper

/**
   MineSweeperFixed -- main class for a GUI minesweeper game.
 */

import javax.swing.JFrame;

public class MineSweeperFixed {
   
   private static boolean[][] smallMineField = 
      {{false, false, false, false}, 
       {true, false, false, false}, 
       {false, true, true, false},
       {false, true, false, true}};
   
   private static boolean[][] emptyMineField = 
      {{false, false, false, false}, 
       {false, false, false, false}, 
       {false, false, false, false},
       {false, false, false, false}};
   
   private static boolean[][] almostEmptyMineField = 
      {{false, false, false, false}, 
       {false, false, false, false}, 
       {false, false, false, false},
       {false, true, false, false}};
       

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 425;
      

   public static void main(String[] args) {

      JFrame frame = new JFrame();

      frame.setTitle("Minesweeper");

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

      GameBoardPanel gameBoard = new GameBoardPanel(new VisibleField(new MineField(almostEmptyMineField)));

      frame.add(gameBoard);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.setVisible(true);

   }

}

