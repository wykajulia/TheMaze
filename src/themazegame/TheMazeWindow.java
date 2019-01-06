
package themazegame;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * Tworzenie okna gry.
 * @author wykaj
 */
public class TheMazeWindow extends WalkingUnicorn{
    
    /**
     * Konstruktor klasy.
     * @param x  odpowiedzialne za ustawienie menu na środku ekranu.
     * @param y  odpowiedzialne za ustawienie menu na środku ekranu.
     * @throws InterruptedException
     */
    public TheMazeWindow (int x, int y) throws InterruptedException
    { 
        setSize(700,780);
        setLayout(null);
        setResizable(false);
        setBackground(Color.LIGHT_GRAY); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);
        setTitle("The Maze");
 
    }
}
