
package themazegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Klasa służąca do stworzenia menu.
 * Przycisk startGame rozpoczyna grę. Otwierane jest nowe okienko z grą. 
 * Rozpoczyna się pomiar czasu.
 * Przycisk theEnd zamyka okno Menu.
 * Przycisk ranking pokazuje imie i wynik gracza.
 * @author wykaj
 */
public class Menu extends JFrame implements ActionListener{
     /** Przyciski rozpoczęcia i zakończenia gry */
     JButton startGame , theEnd , ranking;
     /** Przchowuje imie*/
     String name;
     /**
      * Konstruktor klasy pola graficznego menu.
      * @param x 
      * @param y odpowiedzialne za ustawienie menu na środku ekranu.
      */
    Menu(int x, int y)
    {   
        setSize(700,780);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);
        setTitle("The Menu");       
        
        startGame = new JButton("Start");
        theEnd = new JButton("Zakończ");
        ranking = new JButton("Przypomnij wynik");
        setLayout(new GridLayout(5,0,100,20));
	setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        startGame.addActionListener(this);
        theEnd.addActionListener(this);
        ranking.addActionListener(this);
        
        startGame.setBackground(new Color(137, 98, 98));
        theEnd.setBackground(new Color(137, 98, 98));
        ranking.setBackground(new Color(137, 98, 98));
        add(startGame);
        add(theEnd);
        add(ranking);
        
        setVisible(true);
    }

    /**
     * Funkcja odpowiedzialna za akcję przycisków.
     * @param action akcja 
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        
        if (action.getSource() == startGame) //rozpoczyna się gra oraz pomiar czasu
            try {
                TheMazeGame.game = new TheMazeWindow(TheMazeGame.xCenter,TheMazeGame.yCenter); 
                name =  JOptionPane.showInputDialog(null, "Jak masz na imię? " );
                TheMazeGame.start =System.currentTimeMillis();
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if (action.getSource() == theEnd) //koniec gry
            System.exit(0);
        else if (action.getSource() == ranking) //Przypomina graczowi o wyniku w poprzedniej rozgrywce.
        {
            if(name!=null)
            JOptionPane.showMessageDialog(null, "Witaj " + name + " . W poprzedniej grze zdobyłeś/aś " + WalkingUnicorn.sc + " pkt.");
            else 
            JOptionPane.showMessageDialog(null, "Witaj. Jeszcze nie zagrałeś :)");
                
        }
       
    }
   
}
