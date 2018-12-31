/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themazegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 *
 * @author wykaj
 */
public class WalkingUnicorn extends TheMazeImages implements KeyListener{
    
   String wynik; 
   int a;
   int b;
   static int score = 0;
   static int time =0;
   static int numberOfMoves = 15;
   static long stop;
 // static int time = timer();
  //long start=System.currentTimeMillis();
  
   
   WalkingUnicorn() throws InterruptedException
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
      // if(!wynik.getClass().isAssignableFrom(Integer.class))
       //repaint();
        try {

        if( c+d == Integer.parseInt(wynik))
        {
        score ++;
        //JOptionPane.showMessageDialog(null, "Dobra odpowiedź!");
        JOptionPane.showMessageDialog(null,  "Dobra odpowiedź!","", JOptionPane.NO_OPTION);
        }
        else 
        {
        score--;
        //JOptionPane.showMessageDialog(null, "Zła odpowiedź :( ");
        JOptionPane.showMessageDialog(null, "Zła odpowiedź :(","", JOptionPane.ERROR_MESSAGE);
        }
      } 
        catch(NumberFormatException e) {
	System.err.println("This is not a number!"); }
         
        scorecheck();
        
    }  
    
    public void movescheck() 
    {
       
        if (numberOfMoves <=0)
     {   
         repaint();
         stop=System.currentTimeMillis();
         long x=(stop - TheMazeGame.start)/1000;
         JOptionPane.showMessageDialog(null, "Twoje ruchy się skończyły. Zdobyłes " + score + " punktów. W czasie : " + x + "s" );
         TheMazeGame.game.dispose();
         numberOfMoves=15;
         score=0;
        
        // Menu menu = new Menu();
        // restartGame();
           
          //System.exit(0);
          
     }
    }
    
    public void scorecheck()
    {
        if ( score==3 || score ==6 || score ==9 || score ==12)
        {
        numberOfMoves++;
          JOptionPane.showMessageDialog(null, "Brawo! Masz już "+ score + " punkty. Otrzymujesz dodatkowy ruch" );
          
        }
          
    }
    
    public void doit()
    {
        a=exercise();
        b =exercise();
        wynik  =  JOptionPane.showInputDialog(null, "Podaj wynik:  " + a + " + " + b );
       // wynik = Integer.parseInt(inputString);

        check(a,b);
        
    }
    
    public void boom()
    {
        JOptionPane.showMessageDialog(null, "Wszedłeś na bombe! Wybuchasz. Gra skończona" );
        numberOfMoves =15;
        score = 0;
        TheMazeGame.game.dispose();
    }
    

    @Override
    public void keyTyped(KeyEvent arg0) {
       
    }

    @Override
   public void keyPressed(KeyEvent k) {
         int move = k.getKeyCode();
       
       switch(move)
       {
           case 38:            
            if (board[x-1][y]!=1 && board[x-1][y]!=3 && board[x-1][y]!=4)
               {  
                   x--;
                   board[x][y]=2;
                   board[x+1][y]=0; 
                   numberOfMoves--;     
                   movescheck();
               } 
            else if (board[x-1][y]==3)
            {
                 x--;
                 board[x][y]=2;
                 board[x+1][y]=0;
                 doit();  
                 numberOfMoves--;
                 movescheck();
            }
            else if(board[x-1][y]==4)
            {   
                playSound(new File("boooom.wav"));
                boom();
            }
            
               break;
           case 40:
                
           if (board[x+1][y]!=1 && board[x+1][y]!=3 && board[x+1][y]!=4) 
             {   x++;
               board[x][y]=2;
             board[x-1][y]=0;
             numberOfMoves--;
             movescheck();
            } 
         else if (board[x+1][y]==3)
          {
            x++;
               board[x][y]=2;
             board[x-1][y]=0;
             doit();
            numberOfMoves--;
            movescheck();
          }
         else if( board[x+1][y]==4)
            {   
                playSound(new File("boooom.wav"));
                boom();
            }
           
           break;
            case 39:
                
            if (board[x][y+1]!=1 && board[x][y+1]!=3 && board[x][y+1]!=4) 
               {   y++;
                   board[x][y]=2;
                   board[x][y-1]=0;
                   numberOfMoves--;
                   movescheck();
               } 
            else if (board[x][y+1]==3)
            {      y++;
                   board[x][y]=2;
                   board[x][y-1]=0;
                   doit();
                numberOfMoves--;
                movescheck();
            }
            else if(board[x][y+1]==4)
               {   
                playSound(new File("boooom.wav"));
                boom();
            }
            
               break;
           case 37:
                
           if (board[x][y-1]!=1 && board[x][y-1]!=3 && board[x][y-1]!=4)
             {   y--;
               board[x][y]=2;
             board[x][y+1]=0;
             numberOfMoves--;
             movescheck();
            } 
           else if (board[x][y-1]==3)
           {    y--;
               board[x][y]=2;
             board[x][y+1]=0;
               doit();
               numberOfMoves--;
               movescheck();
           }
           else if(board[x][y-1]==4)
           {   
                playSound(new File("boooom.wav"));
                boom();
            }
           
           break;
          
       }
       repaint();
    }
    
    public static synchronized void playSound(final File f) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }//playSound()

   
    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    
    
    
 /* public int timer () throws InterruptedException
    {
      int start = 0;
      
      do 
      //if(numberOfMoves > 0)
      { 
         System.out.println(start);
         time ++;
         start++;
         sleep(1000);
         repaint();
      }
      while (numberOfMoves > 0);
      
      return start;
      
    }  
  
   /*public void restartGame()
  {
      numberOfMoves=5;
      score=0;
     // TheMazeGame.start=0;
     // stop= System.currentTimeMillis()/1000 - x;
      
      create();
      repaint();
  } */
    
}
