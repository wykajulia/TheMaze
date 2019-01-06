
package themazegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/*
 *
 * @author wykaj
 */

/**
 * Klasa odpwoiedzialna za sterowanie ruchem pionka.
 * @author wykaj
 */

public class WalkingUnicorn extends TheMazeImages implements KeyListener{
   
   /** Wynik równania matematycznego */ 
   String wynik; 
   /** Wylosowana cyfra do równania matematycznego */
   int a;
   /** Wylosowana cyfra do równania matematycznego */
   int b;
   /** Zmienna do przechowywania zdobytych punktów */
   static int score = 0;
   /** Liczba ruchów */
   static int numberOfMoves = 15;
   /** Koniec pomiaru czasu */
   static long stop;
   static int sc;
  
   
   WalkingUnicorn() throws InterruptedException
   {
       addKeyListener(this); 
   }
   
    /**
     * Losowanie cyfr do równania matematycznego
     * @return zwraca int
     */
    public int exercise()
    {   
          Random r = new Random();
          int n= r.nextInt(9) + 1; 
          int m= r.nextInt(9) + 1; 

          return n+m; 
    }
    
    /**
     * Sprawdzanie wyniku podanego przez gracza. Dodanie lub odjęcie punktów.
     * @param c pierwsza cyfra wylosowna do równania
     * @param d druga cyfra wylosowana do równania
     */
    public void check(int c, int d)
    {
        try {

        if( c+d == Integer.parseInt(wynik))
        {
        score ++;
        JOptionPane.showMessageDialog(null,  "Dobra odpowiedź!","", JOptionPane.NO_OPTION);
        }
        else 
        {
        score--;
        JOptionPane.showMessageDialog(null, "Zła odpowiedź :(","", JOptionPane.ERROR_MESSAGE);
        }
      } 
        catch(NumberFormatException e) {
	System.err.println("This is not a number!"); }
         
        scorecheck();       
    }  

    /**
     * Sprawdzenie ile ruchów pozostało graczowi. Gdy numberOfMves=0 gra się 
     * zakończy, pomiar czasu zostanie zatrzymany, wyświetli się informacja
     * o czasie gry oraz zdobytych punktów. Okno zostanie zamknięte.
     */
     public void movescheck() 
    {  
        if (numberOfMoves <=0)
     {   
         repaint();
         stop=System.currentTimeMillis();
         long x=(stop - TheMazeGame.start)/1000;
         JOptionPane.showMessageDialog(null, "Twoje ruchy się skończyły. Zdobyłes " + score + " punktów. W czasie : " + x + "s" );
         TheMazeGame.game.dispose();
         sc=score;
         numberOfMoves=15;
         score=0;
         
     }
    }
    
    /**
     * Gdy gracz zdobędzie 3,6,9 lub 12 punktów otrzymuje w nagrodę jeden ruch. 
     */
    public void scorecheck()
    {
        if ( score==3 || score ==6 || score ==9 || score ==12)
        {
        numberOfMoves++;
          JOptionPane.showMessageDialog(null, "Brawo! Masz już "+ score + " punkty. Otrzymujesz dodatkowy ruch" );   
        }    
    }
    
    /**
     * Funkcja odpowiedzialna za wyświetlanie zadania. Po otrzymaniu wyniku 
     * następuje jego sprawdzenie.
     */
    public void doit()
    {
        a=exercise();
        b =exercise();
        wynik  =  JOptionPane.showInputDialog(null, "Podaj wynik:  " + a + " + " + b );
        
        check(a,b);  
    }
    
    /**
     * Fukcja odpowiada za zakończenie gry, gdy użytkownik wejdzie na bombę.
     * Okno się zamyka.
     */
    public void boom()
    {
        JOptionPane.showMessageDialog(null, "Wszedłeś na bombe! Wybuchasz. Gra skończona" );
        numberOfMoves =15;
        sc=0;
        score = 0;
        TheMazeGame.game.dispose();
    }
    
    /**
     *
     * @param arg0
     */
    @Override
    public void keyTyped(KeyEvent arg0) {
       
    }

    /**
     * Funkcja odpowiedzialna za poruszanie się pionka oraz za wykonanie 
     * wszystkich czynności sprawdzających i wyświetlanie zadań.
     * @param k - wciśniećie klawisza klawiatury
     */
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
             {  
                x++;
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
             {   
                y++;
                board[x][y]=2;
                board[x][y-1]=0;
                numberOfMoves--;
                movescheck();
             } 
            else if (board[x][y+1]==3)
            {   
                y++;
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
            {   
                y--;
                board[x][y]=2;
                board[x][y+1]=0;
                numberOfMoves--;
                movescheck();
            } 
           else if (board[x][y-1]==3)
           {    
               y--;
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
    
    /**
     * Funkcja odpowiedzialna za odtworzenie dźwieku po wejściu na bombę.
     * @param f
     */
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
    }

    /**
     *
     * @param arg0
     */
    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    
}
