package view;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class SubChanger {

    
    public static void main(String[] args) {       
         EventQueue.invokeLater(new Runnable() {
             @Override
             public void run() {
                 GUI frame = new GUI();
                 frame.setTitle("Untitled-SubChanger");
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setVisible(true);
             }
         });
    }
    
}
