
package themazegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;



/**
 *Klasa odpowiedzialna za tworzenie "mapki" labiryntu
 * @author wykaj
 */
public class TheMazeImages extends JFrame implements ActionListener{
     
    /** Ikona obiektu: ściana, pionek, trawa, zadanie, bomba */
    public Image wall,unicorn,grass,task, bomb; 
    /** Tablica mapy */
    int[][]board=new int[10][10];
    /** Współrzędne ustawienia pionka */ 
     int x=5; 
     int y=7;
     /** Zmienna do zliczania czasu */
     int time = 0;
     /** Timer potrzebny do wyświetlania czasu gry co sekundę */
     Timer timer=new Timer(1000, (ActionListener) this);

     /** 
      * Konstruktor odpowiedzialny za wczytanie obrazków z pliku 
      */
     public TheMazeImages()
     {
         timer.start();
         try {
             wall= ImageIO.read(new File("wall.png"));
             grass= ImageIO.read(new File("grass.png"));
             unicorn= ImageIO.read(new File("unicorn.png"));
             task = ImageIO.read(new File("star.png"));
             bomb =ImageIO.read(new File("bomb.png"));
         } catch (IOException ex) {
             Logger.getLogger(TheMazeImages.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         create();
     }
     
    /**
     * Losowanie cyfr, aby pole z zadaniem miało losowe miejsce w tablicy
     * @return zwraca int
     */
       public int random()
      {
          Random r = new Random();
          int n= r.nextInt(9) + 1;
          return n;
      }
        
      /** 
       * Towrzenie mapy/planszy.
       * Konkretnnym miejscom w tablicy przypisywane są cyfry.
       */ 
      public void create()
      {    
          
          int board2[][] = {{1,1,1,1,1,1,1,1,1,1},
                         {1,0,1,0,1,0,1,0,0,1},
                         {1,0,1,0,4,0,1,0,1,1},
                         {1,0,0,0,0,0,1,0,0,1},
                         {1,1,1,0,1,1,1,0,0,1},
                         {1,0,0,0,1,4,0,0,0,1},
                         {1,0,1,0,0,0,0,1,1,1},
                         {1,0,1,1,0,1,0,0,0,1},
                         {1,0,0,0,0,1,0,0,0,1},
                         {1,1,1,1,1,1,1,1,1,1}
                         };
         
          
          //ustawienie pionka
          for(int i=0; i<10;i++)
        {
            for(int j=0; j<10;j++)
            {   
                if( board2[i][j] == board[x][y] ) 
                    board[x][y]=2;             
                else 
                board[i][j]=board2[i][j];
            }
        }
          //losowe ustawianie gwiazdek
          for(int k=0; k<10 ; k++){
              int o = random();
              int p =random();
              if(board[o][p]==0)
              board[o][p]=3;
              else k--;
          }
      }
      
      //@Override

    /**
     * Rusowanie mapy
     * @param g
     */
        public void paint(Graphics g)
    {
        drawTheMap(g);   
    }
     /**
     * Funkcja odpowiedzialna za rysowanie tablicy. 
     * Odpowiednie cyfry odpowiadają konkretnym ikonom.
     * Dodatkowo wyświetlanych jest czas, liczba punktów i ruchów.
     * @param g
      */        
       public void drawTheMap(Graphics g)
       {
          
       Image img=createImage(getSize().width, getSize().height);
       Graphics2D g2=(Graphics2D)img.getGraphics();
     
       
        for(int i=0; i<10 ; i++)
      {
            for (int j=0; j<10 ; j++)
            {
                int pole = board[i][j];
                   
                switch(pole)
             {      
                    case 1: 
                        g2.drawImage(wall, 70*j, 70*i, this);
                        break;
                    case 2:
                        g2.drawImage(unicorn, 70*j,70*i, this);
                        break;
                    case 3:
                       g2.drawImage(task, 70*j,70*i, this);
                        break;
                     case 4:
                        g2.drawImage(bomb, 70*j,70*i, this);
                        break;               
                    case 0:
                        g2.drawImage(grass, 70*j,70*i, this);
                        break;            
                    
               }
            }
        }
             
        g.drawImage(img, 0, 0, this); 
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString("Liczba punktów: " + WalkingUnicorn.score  ,20, 740);
        g.drawString("Czas: " + time +" s",240, 740);
        g.drawString("Pozostało ruchów: " + WalkingUnicorn.numberOfMoves ,380, 740);
      
   }
    

    /**
     * Funkcja odpowiedzialna za odświeżanie co sekunde, aby aktualny czas gry  
     * był dobrze wyświetlany
     * @param ev
     */
     public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==timer){
        time++;
        repaint();
        }    
    } 
}
