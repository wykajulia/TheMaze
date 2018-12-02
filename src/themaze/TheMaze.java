/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themaze;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author wykaj
 */
public class TheMaze extends TheMap implements KeyListener {
    
   String wynik; 
   int a;
   int b;
  static int score = 0;
  static int numberOfMoves=20;
  
  
   
   TheMaze() throws InterruptedException
   {
       addKeyListener(this);      
   }
   
    public int exercise()
    {   
       
          Random r = new Random();
          int n= r.nextInt(9) + 1; 
          int m= r.nextInt(9) + 1; 

          return n+m; 
    }
    
    public void check(int c, int d)
    {
        if( c+d == Integer.parseInt(wynik))
        {
        score ++;
        JOptionPane.showMessageDialog(null, "Dobra odpowiedź!");
        }
        else 
        {
        score--;
        JOptionPane.showMessageDialog(null, "Zła odpowiedź :( ");
        }
        
        System.out.println(score);
    }       
    
    public void doit()
    {
        a=exercise();
        b =exercise();
        wynik =  JOptionPane.showInputDialog(null, "Podaj wynik:  " + a + " + " + b);
        check(a,b);
    }
    
    public static void main(String[] args) throws InterruptedException  {
        // TODO code application logic here
        TheMaze game = new TheMaze();
        
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLocation(600,180);
        game.timer();
       
        
        
       
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
            numberOfMoves--;
            if (board[x-1][y]==0 && board[x-1][y]!=3)//&&(plansza[x-1][y]!=1))
               {   x--;
                   board[x][y]=2;
                   board[x+1][y]=0; 
                 
               } 
            else if (board[x-1][y]==3)
            {
                 x--;
                 board[x][y]=2;
                 board[x+1][y]=0;
                 doit();  
                
            }
               break;
           case 40:
                numberOfMoves--;
           if (board[x+1][y]!=1 && board[x+1][y]!=3) //&& (plansza.length > 0) && (plansza[x+1][y]!=1))
             {   x++;
               board[x][y]=2;
             board[x-1][y]=0;
            } 
         else if (board[x+1][y]==3)
          {
            x++;
               board[x][y]=2;
             board[x-1][y]=0;
             doit();
          }
           break;
            case 39:
                 numberOfMoves--;
            if (board[x][y+1]!=1 && board[x][y+1]!=3) //&& plansza.length > 0 && plansza[x][y+1]!=1)
               {   y++;
                   board[x][y]=2;
                   board[x][y-1]=0;
               } 
            else if (board[x][y+1]==3)
            {      y++;
                   board[x][y]=2;
                   board[x][y-1]=0;
                   doit();
                
            }
            
               break;
           case 37:
                numberOfMoves--;
           if (board[x][y-1]!=1 && board[x][y-1]!=3)//&& plansza.length > 0 && plansza[x][y-1]!=1)
             {   y--;
               board[x][y]=2;
             board[x][y+1]=0;
            } 
           else if (board[x][y-1]==3)
           {    y--;
               board[x][y]=2;
             board[x][y+1]=0;
               doit();
           }
           break;
       }
       repaint();
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    
    
   public void timer () throws InterruptedException
    {
      int start = 5;
      
      do 
      { System.out.println(start);
         start --;
         sleep(1000);
      }
      while (start > 0);
      
    }  
    
 
}
