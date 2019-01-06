
package themazegame;

import java.awt.Toolkit;

/**
 * Gra labirynt.
 * @author wykaj
 */
public class TheMazeGame {

    static long start;
    static TheMazeWindow game;
    static int xCenter;
    static int yCenter;
     
    /**
     * Metoda uruchamia grę.
     * Pobierane są parametry ekranu, po to, aby pole gry było 
     * wyświetlane na środku ekranu.
     */
    public static void main(String[] args) throws InterruptedException  {

       int gameWidth=700;
       int gameHeight=800;
        
       int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
       int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        
       xCenter=(screenWidth-gameWidth)/2;
       yCenter=(screenHeight-gameHeight)/2;       
       Menu menu = new Menu(xCenter,yCenter);

    }
}
