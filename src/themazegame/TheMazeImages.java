/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themazegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


/**
 *
 * @author wykaj
 */
public class TheMazeImages extends JFrame{
    
     public Image wall,unicorn,grass,task;
     int[][]board=new int[10][10];
     int board2[][];
     int x=5; 
     int y=7;
     
     public TheMazeImages()
     {

         try {
             wall= ImageIO.read(new File("wall.png"));
             grass= ImageIO.read(new File("grass.png"));
             unicorn= ImageIO.read(new File("unicorn.png"));
             task = ImageIO.read(new File("star.png"));
         } catch (IOException ex) {
             Logger.getLogger(TheMazeImages.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         create();
 
     }
     
       public int random()
      {
          Random r = new Random();
          int n= r.nextInt(9) + 1;
          return n;
      }
      
     
       
      public void create()
      {    
          
          int board2[][] = {{1,1,1,1,1,1,1,1,1,1},
                         {1,0,1,0,1,0,1,0,0,1},
                         {1,0,1,0,0,0,1,0,1,1},
                         {1,0,0,0,0,0,1,0,0,1},
                         {1,1,1,0,1,1,1,0,0,1},
                         {1,0,0,0,1,0,0,0,0,1},
                         {1,0,1,0,0,0,0,1,1,1},
                         {1,0,1,1,0,1,0,0,0,1},
                         {1,0,0,0,0,1,0,0,0,1},
                         {1,1,1,1,1,1,1,1,1,1}
                         };
         
          
          //ustawienie ludzika
          for(int i=0; i<10;i++)
        {
            for(int j=0; j<10;j++)
            {   
                if( board2[i][j] == board[x][y] ) // board2[i][j]!=1 &&
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
        public void paint(Graphics g)
    {
        drawTheMap(g);
        
    }
      
  /*   private void drawScore(Graphics2D g) {

        
        String s;

        
        g.setColor(new Color(96, 128, 255));
        s = "Score: " + TheMaze.score;
        g.drawString(s, 100,710);

       
    }  */
        
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
                         //Rectangle2D rectangle = new Rectangle2D.Double(10, 10, 380, 380);
                         //g2.draw(rectangle);
                        g2.drawImage(wall, 70*j, 70*i, this);
                        break;
                    case 2:
                        g2.drawImage(unicorn, 70*j,70*i, this);
                        break;
                    case 3:
                       g2.drawImage(task, 70*j,70*i, this);
                        break;
                                
                    case 0:
                        g2.drawImage(grass, 70*j,70*i, this);
                        break;            
                    
               }
            }
        }
        
      
      g.drawImage(img, 0, 0, this); 
     //  g.setColor(new Color(96, 128, 255));
     g.setColor(Color.DARK_GRAY);
     g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
      g.drawString("Liczba punktów: " + WalkingUnicorn.score  ,20, 740);
        
             //   drawScore(g2);
             g.drawString("Czas: " /*+  TheMazeGame.start/1000 */ + " s",240, 740);
        
      g.drawString("Pozostało ruchów: " + WalkingUnicorn.numberOfMoves ,380, 740);
      
   }
      
       
}
