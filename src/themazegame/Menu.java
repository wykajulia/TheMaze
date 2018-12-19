/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themazegame;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author wykaj
 */
public class Menu extends JFrame {
    
    Menu()
    {
        setSize(700,780);
        setLayout(null);
        setResizable(false);
        setBackground(Color.LIGHT_GRAY); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600,180);
        setTitle("The Menu");
    }
    
    
}
