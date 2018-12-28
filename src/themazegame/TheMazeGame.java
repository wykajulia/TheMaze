/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themazegame;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wykaj
 */
public class TheMazeGame {

    static long start;
    static TheMazeWindow game;
    static int xCenter;
    static int yCenter;
     
//* @param args the command line arguments
  //   */
    public static void main(String[] args) throws InterruptedException  {
        // TODO code application logic here
        
       // start=System.currentTimeMillis();
        //game = new TheMazeWindow();
       // WalkingUnicorn.timer();
       int gameWidth=700;
       int gameHeight=800;
        
        
        //pobierz rozmiar ekranu
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        
        //oblicz wspĂłĹ‚rzÄ™dne naroĹĽnika tak, aby pole gry byĹ‚o wyĹ›rodkowane
        xCenter=(screenWidth-gameWidth)/2;
        yCenter=(screenHeight-gameHeight)/2;       
       Menu menu = new Menu(xCenter,yCenter);
       /// game.addKeyListener(new WalkingUnicorn());
       
        
        
        
           
    }
    
}
