/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themazegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author wykaj
 */
public class Menu extends JFrame implements ActionListener{
    
     JButton startGame , theEnd , button;
     
    
    Menu()
    {   
        setSize(700,780);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600,180);
        setTitle("The Menu");
        
        
        startGame = new JButton("Start");
        theEnd = new JButton("Zakończ");
        setLayout(new GridLayout(5,0,100,20));
	setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //startGame.setPreferredSize(new Dimension(10, 27));
        
        startGame.addActionListener(this);
        theEnd.addActionListener(this);
        
        startGame.setBackground(new Color(137, 98, 98));
        theEnd.setBackground(new Color(137, 98, 98));
        add(startGame);
        add(theEnd);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        
        if (action.getSource() == startGame)
            try {
                TheMazeGame.game = new TheMazeWindow(); 
                TheMazeGame.start =System.currentTimeMillis();
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if (action.getSource() == theEnd)
            System.exit(0);
       
    }
    
    
}
