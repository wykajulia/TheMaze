package themaze;


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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wykaj
 */
public class TheMap extends JFrame {
    
     int[][]board=new int[10][10];
      private Image wall,man,grass,task;
      int x=5; //random();
      int y=7; //random();
      
      public TheMap()
      {
         setSize(700,700);
        setLayout(null);
        setResizable(false);
         
        
        
          try {
                wall= ImageIO.read(new File("wall2.png"));
                grass= ImageIO.read(new File("grass.png"));
                man= ImageIO.read(new File("man.png"));
                task = ImageIO.read(new File("task.png"));

          } catch (IOException ex) {
              Logger.getLogger(TheMaze.class.getName()).log(Level.SEVERE, null, ex);
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
                         {1,0,0,0,0,0,0,0,0,1},
                         {1,0,0,1,1,1,0,0,0,1},
                         {1,0,0,0,0,0,0,0,0,1},
                         {1,1,1,0,1,0,0,0,0,1},
                         {1,0,0,0,1,0,0,0,0,1},
                         {1,0,1,0,1,0,0,0,0,1},
                         {1,0,1,0,1,0,0,0,0,1},
                         {1,0,0,0,1,0,0,0,0,1},
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
      
      @Override
        public void paint(Graphics g)
    {
        drawTheMap(g);
    }
      
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
                        g2.drawImage(man, 70*j,70*i, this);
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
   }
}
