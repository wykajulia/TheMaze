/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themaze;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author wykaj
 */
public class TheMaze extends TheMap  implements KeyListener {

   TheMaze()
   {
       addKeyListener(this);
   }
       
    
    public static void main(String[] args) {
        // TODO code application logic here
        TheMaze game = new TheMaze();
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
       
    }

    @Override
   public void keyPressed(KeyEvent k) {
         int move = k.getKeyCode();
      // int num = num();
       
       switch(move)
       {
           case 38:
            if (board[x-1][y]==0 && board[x-1][y]!=3)//&&(plansza[x-1][y]!=1))
               {   x--;
                   board[x][y]=2;
                   board[x+1][y]=0; 
               } 
            else if (board[x-1][y]==3)
            {
                System.out.println("zadanie");
                 x--;
                 board[x][y]=2;
                 board[x+1][y]=0;
                   
            }
               break;
           case 40:
           if (board[x+1][y]!=1 && board[x][y]!=3) //&& (plansza.length > 0) && (plansza[x+1][y]!=1))
             {   x++;
               board[x][y]=2;
             board[x-1][y]=0;
            } 
         //  else if (plansza[x][y]==3)
          // {
            //   plansza[x][y]=0;
          // }
           break;
            case 39:
            if (board[x][y+1]!=1) //&& plansza.length > 0 && plansza[x][y+1]!=1)
               {   y++;
                   board[x][y]=2;
                   board[x][y-1]=0;
               } 
               break;
           case 37:
           if (board[x][y-1]!=1 )//&& plansza.length > 0 && plansza[x][y-1]!=1)
             {   y--;
               board[x][y]=2;
             board[x][y+1]=0;
            } 
           break;
       }
       repaint();
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    
}
